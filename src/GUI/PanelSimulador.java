package GUI;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JApplet;
import javax.swing.JButton;

import SubsistemaControl.Controlador;
import SubsistemaMonitorizacion.ControladorMonitorizador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

// JApplet principal con el panel de simulación del SCACV.

public class PanelSimulador extends JApplet {
	
	private Controlador controlador ;
	private ControladorMonitorizador monitorizador ;

	private PanelDeposito paneldeposito ;
	private PanelVelocidad panelvelocidad ;
	private PanelInformativo panelinformativo ;
	private PanelBotones panelbotones ;
	
	private ObservadorDeposito observadordeposito ;
	private ObservadorEstado observadorestado ;
	private ObservadorVelocidad observadorvelocidad ;
	private ObservadorMonitorizacion observadormonitorizacion ;
	
	private Clip clip ;
	
	/**
	 * Create the applet.
	 */
	
	// Constructor de la clase. Se encarga de instanciar las dos clases controladoras, los 4
	// observadores del sistema, el botón de salida de la aplicación junto a su clip asociado, y los
	// 4 paneles secundarios
	
	public PanelSimulador() {
		getContentPane().setBackground(new Color(25, 25, 112)) ;
		getContentPane().setLayout(null) ;
		
		controlador = Controlador.getInstance() ;
		monitorizador = ControladorMonitorizador.getInstance(controlador.getAlmacenador()) ;
		
		observadorvelocidad = new ObservadorVelocidad(controlador.getAlmacenador()) ;
		observadordeposito = new ObservadorDeposito(controlador.getAlmacenador()) ;
		observadorestado = new ObservadorEstado(controlador.getAlmacenador()) ;
		observadormonitorizacion = new ObservadorMonitorizacion(monitorizador.getAlmacenadorMonitorizador()) ;
		
		Reloj reloj = new Reloj(this) ;
		
		try{
			File archivosonido = new File("Sounds/toggle_switch.wav") ;
			AudioInputStream stream = AudioSystem.getAudioInputStream(archivosonido) ;
			AudioFormat format = stream.getFormat() ;
			DataLine.Info info = new DataLine.Info(Clip.class, format) ;
			clip = (Clip) AudioSystem.getLine(info) ;
			clip.open(stream) ;
		}
		catch (Exception e){
			e.printStackTrace() ;
		}
		
		panelbotones = new PanelBotones(controlador, observadorestado) ;
		panelbotones.setBounds(351, 284, 262, 345) ;
		getContentPane().add(panelbotones) ;
		
		panelinformativo = new PanelInformativo(monitorizador, observadorestado, observadormonitorizacion) ;
		panelinformativo.setBounds(12, 284, 325, 404) ;
		getContentPane().add(panelinformativo) ;
		
		panelvelocidad = new PanelVelocidad(observadorvelocidad) ;
		panelvelocidad.setBounds(12, 12, 325, 250) ;
		getContentPane().add(panelvelocidad) ;
		
		paneldeposito = new PanelDeposito(observadordeposito) ;
		paneldeposito.setBounds(351, 12, 262, 250) ;
		getContentPane().add(paneldeposito) ;
		
		JLabel scacv = new JLabel("SCACV UGR") ;
		scacv.setFont(new Font("SansSerif", Font.ITALIC, 20)) ;
		scacv.setForeground(Color.WHITE) ;
		scacv.setBounds(490, 649, 123, 47) ;
		getContentPane().add(scacv) ;
		
		JButton botonsalir = new JButton("SALIR") ;
		botonsalir.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.start() ;
				System.exit(0) ;
			}
		});
		botonsalir.setBackground(new Color(250, 0, 50)) ;
		botonsalir.setBounds(351, 663, 123, 25) ;
		getContentPane().add(botonsalir) ;
		
		controlador.iniciarControl() ;
		monitorizador.iniciarMonitorizacion() ;
		reloj.start() ;
	}
	
	// Llama periódicamente al método 'accionesPeriodicas' de cada uno de los 4 paneles, en los
	// cuales se realizarán las actualizaciones pertinentes para mantener informado en todo momento
	// al usuario del estado completo actual del vehículo
	
	public synchronized void accionesPeriodicas(){
		panelinformativo.accionesPeriodicas() ;
		panelbotones.accionesPeriodicas() ;
		panelvelocidad.accionesPeriodicas() ;
		paneldeposito.accionesPeriodicas() ;
	}
}
