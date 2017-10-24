package GUI;

import javax.swing.JPanel;

import SubsistemaMonitorizacion.ControladorMonitorizador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

// Panel que contiene la informaci贸n de estado y mantenimiento del sistema: Estado de la palanca,
// estado del acelerador y el freno, y la necesidad o no de realizar una de las tareas de mantenimiento.

public class PanelInformativo extends JPanel {
	
	private ControladorMonitorizador controladormonitorizador ;
	private ObservadorEstado observadorestado ;
	private ObservadorMonitorizacion observadormonitorizacion ;
	private JLabel estadopalanca ;
	private JLabel estadoacelerador ;
	private JLabel estadofreno ;
	private JLabel cambioaceite ;
	private JLabel cambiopastillas ;
	private JLabel revisiongeneral ;
	private JLabel infocambioaceite ;
	private JLabel infocambiopastillas ;
	private JLabel inforevisiongeneral ;
	private JButton solicitarcambioaceite ;
	private JButton solicitarcambiopastillas ;
	private JButton solicitarrevisiongeneral ;
	
	private boolean avisaraceite ;
	private boolean avisarpastillas ;
	private boolean avisarrevision ;
	private Clip clipaviso ;
	private Clip clipboton ;

	/**
	 * Create the panel.
	 */
	
	// Constructor de la clase. Recibe como argumentos la clase controladora necesaria para llamar a los
	// m茅todos de mantenimiento, adem谩s de los observadores con la informaci贸n de estado y 
	// de monitorizaci贸n con los que actualizar las etiquetas. Se encarga de crear los clips de aviso 
	// y de pulsaci贸n de bot贸n, las diferentes etiquetas y los botones de mantenimiento, los cuales estar谩n 
	// inicialmente desactivados hasta que la tarea de mantenimiento sea necesario solicitarla
	
	public PanelInformativo(ControladorMonitorizador elcontrolador, ObservadorEstado elobservador, ObservadorMonitorizacion otroobservador) {
		setLayout(null) ;
		
		controladormonitorizador = elcontrolador ;
		observadorestado = elobservador ;
		observadormonitorizacion = otroobservador ;
		
		try{
			File sonidoaviso = new File("Sounds/slow_ding_dong_bell_door.wav") ;
			File sonidoboton = new File("Sounds/toggle_switch.wav") ;
			AudioInputStream streamaviso = AudioSystem.getAudioInputStream(sonidoaviso) ;
			AudioInputStream streamboton = AudioSystem.getAudioInputStream(sonidoboton) ;
			AudioFormat formataviso = streamaviso.getFormat() ;
			AudioFormat formatboton = streamboton.getFormat() ;
			DataLine.Info infoaviso = new DataLine.Info(Clip.class, formataviso) ;
			DataLine.Info infoboton = new DataLine.Info(Clip.class, formatboton) ;
			clipaviso = (Clip) AudioSystem.getLine(infoaviso) ;
			clipboton = (Clip) AudioSystem.getLine(infoboton) ;
			clipaviso.open(streamaviso) ;
			clipboton.open(streamboton) ;
		}
		catch (Exception e){
			e.printStackTrace() ;
		}
		
		avisaraceite = false ;
		avisarpastillas = false ;
		avisarrevision = false ;
		
		JLabel tituloestadofreno = new JLabel("ESTADO DEL FRENO:") ;
		tituloestadofreno.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		tituloestadofreno.setBounds(12, 373, 180, 15) ;
		add(tituloestadofreno) ;
		
		JLabel tituloestadoacelerador = new JLabel("ESTADO DEL ACELERADOR:") ;
		tituloestadoacelerador.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		tituloestadoacelerador.setBounds(12, 346, 230, 15) ;
		add(tituloestadoacelerador) ;
		
		estadoacelerador = new JLabel() ;
		estadoacelerador.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		estadoacelerador.setBounds(254, 346, 59, 15) ;
		add(estadoacelerador) ;
		
		estadofreno = new JLabel() ;
		estadofreno.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		estadofreno.setBounds(254, 373, 59, 15) ;
		add(estadofreno) ;
		
		JLabel tituloestadopalanca = new JLabel("PALANCA:") ;
		tituloestadopalanca.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		tituloestadopalanca.setBounds(12, 22, 100, 15) ;
		add(tituloestadopalanca) ;
		
		estadopalanca = new JLabel("") ;
		estadopalanca.setBorder(new LineBorder(new Color(0, 0, 0))) ;
		estadopalanca.setForeground(Color.BLUE);
		estadopalanca.setFont(new Font("Liberation Sans", Font.BOLD | Font.ITALIC, 15)) ;
		estadopalanca.setBounds(124, 12, 189, 30) ;
		add(estadopalanca) ;
		
		cambioaceite = new JLabel("AMBIO DE ACEITE NECESARIO!") ;
		cambioaceite.setForeground(new Color(220, 220, 220)) ;
		cambioaceite.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		cambioaceite.setBounds(12, 60, 300, 15) ;
		add(cambioaceite) ;
		
		cambiopastillas = new JLabel("　CAMBIO DE PASTILLAS NECESARIO!!") ;
		cambiopastillas.setForeground(new Color(220, 220, 220)) ;
		cambiopastillas.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		cambiopastillas.setBounds(12, 151, 300, 15) ;
		add(cambiopastillas) ;
		
		revisiongeneral = new JLabel("　EVISI覰 GENERAL NECESARIA!!!") ;
		revisiongeneral.setForeground(new Color(220, 220, 220)) ;
		revisiongeneral.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		revisiongeneral.setBounds(12, 242, 300, 15) ;
		add(revisiongeneral) ;
		
		solicitarcambioaceite = new JButton("SOLICITAR CAMBIO DE ACEITE") ;
		solicitarcambioaceite.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clipboton.setFramePosition(0) ;
				clipboton.start() ;
				controladormonitorizador.getMantenimiento().arreglarVehiculo(0) ;
				infocambioaceite.setText("Aceite cambiado a las " + observadormonitorizacion.getRevolucionesAceite() + " revoluciones") ;
			}
		});
		solicitarcambioaceite.setEnabled(false);
		solicitarcambioaceite.setBounds(12, 87, 301, 25) ;
		add(solicitarcambioaceite) ;
		
		solicitarcambiopastillas = new JButton("SOLICITAR CAMBIO DE PASTILLAS") ;
		solicitarcambiopastillas.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clipboton.setFramePosition(0) ;
				clipboton.start() ;
				controladormonitorizador.getMantenimiento().arreglarVehiculo(1) ;
				infocambiopastillas.setText("Pastillas cambiadas a las " + observadormonitorizacion.getRevolucionesPastillas() + " revoluciones") ;
			}
		});
		solicitarcambiopastillas.setEnabled(false);
		solicitarcambiopastillas.setBounds(12, 178, 301, 25) ;
		add(solicitarcambiopastillas) ;
		
		solicitarrevisiongeneral = new JButton("SOLICITAR REVISI覰 GENERAL") ;
		solicitarrevisiongeneral.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clipboton.setFramePosition(0) ;
				clipboton.start() ;
				controladormonitorizador.getMantenimiento().arreglarVehiculo(2) ;
				inforevisiongeneral.setText("Revisi髇 realizada a las " + observadormonitorizacion.getRevolucionesRevisionGeneral() + " revoluciones") ;
			}
		});
		solicitarrevisiongeneral.setEnabled(false);
		solicitarrevisiongeneral.setBounds(12, 269, 301, 25) ;
		add(solicitarrevisiongeneral) ;
		
		inforevisiongeneral = new JLabel() ;
		inforevisiongeneral.setFont(new Font("Liberation Sans", Font.BOLD, 12)) ;
		inforevisiongeneral.setBounds(12, 306, 301, 15) ;
		add(inforevisiongeneral) ;
		
		infocambiopastillas = new JLabel() ;
		infocambiopastillas.setFont(new Font("Liberation Sans", Font.BOLD, 12)) ;
		infocambiopastillas.setBounds(12, 215, 301, 15) ;
		add(infocambiopastillas) ;
		
		infocambioaceite = new JLabel() ;
		infocambioaceite.setFont(new Font("Liberation Sans", Font.BOLD, 12)) ;
		infocambioaceite.setBounds(12, 124, 301, 15) ;
		add(infocambioaceite) ;
	}
	
	// Realiza las tareas peri贸dicas asociadas a este panel. Comprueba en cada instante si una de las
	// tres tareas de mantenimiento es necesario realizarla. En ese momento, pone en rojo el mensaje de
	// aviso y habilita el bot贸n asociado a la tarea que se tiene que solicitar. Cuando la tarea se
	// realiza, tanto el mensaje como el bot贸n vuelven al estado inicial. Adem谩s, se comprueba el estado
	// del acelerador y el freno, indicando con un OFF negro o un ON rojo su estado actual
	
	public synchronized void accionesPeriodicas(){
		estadopalanca.setText("  " + String.valueOf(observadorestado.getEstadoPalanca())) ;
		
		if (observadormonitorizacion.getCambioAceite() == 1){
			if (!avisaraceite){
				clipaviso.setFramePosition(0) ;
				clipaviso.start() ;
				avisaraceite = true ;
			}
			cambioaceite.setForeground(Color.red) ;
			solicitarcambioaceite.setEnabled(true) ;
		}
		else{
			cambioaceite.setForeground(new Color(220, 220, 220)) ;
			solicitarcambioaceite.setEnabled(false) ;
			avisaraceite = false ;
		}
		
		if (observadormonitorizacion.getCambioPastillas() == 1){
			if (!avisarpastillas){
				clipaviso.setFramePosition(0) ;
				clipaviso.start() ;
				avisarpastillas = true ;
			}
			cambiopastillas.setForeground(Color.red) ;
			solicitarcambiopastillas.setEnabled(true) ;
		}
		else{
			cambiopastillas.setForeground(new Color(220, 220, 220)) ;
			solicitarcambiopastillas.setEnabled(false) ;
			avisarpastillas = false ;
		}
		
		if (observadormonitorizacion.getRevisionGeneral() == 1){
			if (!avisarrevision){
				clipaviso.setFramePosition(0) ;
				clipaviso.start() ;
				avisarrevision = true ;
			}
			revisiongeneral.setForeground(Color.red) ;
			solicitarrevisiongeneral.setEnabled(true) ;
		}
		else{
			revisiongeneral.setForeground(new Color(220, 220, 220)) ;
			solicitarrevisiongeneral.setEnabled(false) ;
			avisarrevision = false ;
		}
		
		if (observadorestado.getEstadoAcelerador() == 1){
			estadoacelerador.setText("ON") ;
			estadoacelerador.setForeground(Color.red) ;
		}
		else{
			estadoacelerador.setText("OFF") ;
			estadoacelerador.setForeground(Color.black) ;
		}
		
		if (observadorestado.getEstadoFreno() == 1){
			estadofreno.setText("ON") ;
			estadofreno.setForeground(Color.red) ;
		}
		else{
			estadofreno.setText("OFF") ;
			estadofreno.setForeground(Color.black) ;
		}
	}
}
