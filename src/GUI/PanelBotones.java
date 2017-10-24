package GUI;

import javax.swing.JPanel;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;

import SubsistemaControl.Controlador;
import SubsistemaControl.PalancaEstado;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

// Panel que contiene los botones necesarios para mover la palanca entre los 7 distintos estados que
// la caracterizan, así como un botón extra para rellenar el depósito del vehículo. Rodeando a los botones
// se encuentra un rectángulo rojo que se coloca sobre el botón asociado al estado actual de la palanca,
// para informar más fácilmente de este aspecto al usuario de la aplicación.

public class PanelBotones extends JPanel {
	
	private Controlador controlador ;
	private ObservadorEstado observadorestado ;
	
	private JButton botonRellenar ;
	private JButton botonApagar ;
	private JButton botonEncender ;
	private JButton botonAcelerar ;
	private JButton botonDesactivar ;
	private JButton botonReiniciar ;
	private JButton botonActivar ;
	private JButton botonFrenar ;
	
	private JLabel botonActivo ;
	private boolean pulsandoBotonFrenar ;
	
	private Clip clip ;

	/**
	 * Create the panel.
	 */
	
	// Constructor del panel. Recibe como argumentos el controlador necesario para actuar sobre la
	// palanca y rellenar el depósito, además del observador necesario para saber el estado actual 
	// de la palanca. Se encarga de crear los diferentes botones, la etiqueta rectangular roja y 
	// el clip de sonido asociado a la pulsación de un botón
	
	public PanelBotones(Controlador elcontrolador, ObservadorEstado elobservador){
		setLayout(null) ;
		
		controlador = elcontrolador ;
		observadorestado = elobservador ;
		
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
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonApagar = new JButton("<html>" + "APAGAR" + "<br>" + "MOTOR" + "</html>") ;
		botonApagar.setBackground(new Color(250, 0, 50)) ;
		botonApagar.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.setFramePosition(0) ;
				clip.start() ;
				controlador.getPalanca().moverPalanca(PalancaEstado.MOTORAPAGADO) ;
			}
		}) ;
		botonApagar.setBounds(12, 49, 100, 87) ;
		add(botonApagar) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonRellenar = new JButton("RELLENAR DEP�SITO") ;
		botonRellenar.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.setFramePosition(0) ;
				clip.start() ;
				controlador.rellenarDeposito() ;
			}
		}) ;
		botonRellenar.setBounds(12, 12, 238, 25) ;
		add(botonRellenar) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonEncender = new JButton("<html>" + "ENCENDER" + "<br>" + "MOTOR" + "</html>") ;
		botonEncender.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.setFramePosition(0) ;
				clip.start() ;
				controlador.getPalanca().moverPalanca(PalancaEstado.ENCENDIDO) ;
			}
		}) ;
		botonEncender.setBounds(124, 49, 126, 87) ;
		add(botonEncender) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonAcelerar = new JButton("ACELERAR") ;
		botonAcelerar.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.setFramePosition(0) ;
				clip.start() ;
				controlador.getPalanca().moverPalanca(PalancaEstado.ACELERANDO) ;
			}
		}) ;
		botonAcelerar.setBounds(124, 160, 126, 25) ;
		add(botonAcelerar) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonActivar = new JButton("ACTIVAR AUTOM�TICO") ;
		botonActivar.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.setFramePosition(0) ;
				clip.start() ;
				controlador.getPalanca().moverPalanca(PalancaEstado.AUTOMATICO) ;
			}
		}) ;
		botonActivar.setBounds(12, 208, 238, 25) ;
		add(botonActivar) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonDesactivar = new JButton("APAGAR AUTOM�TICO") ;
		botonDesactivar.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.setFramePosition(0) ;
				clip.start() ;
				controlador.getPalanca().moverPalanca(PalancaEstado.APAGADO) ;
			}
		}) ;
		botonDesactivar.setBounds(12, 308, 238, 25) ;
		add(botonDesactivar) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonReiniciar = new JButton("REINICIAR") ;
		botonReiniciar.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				clip.setFramePosition(0) ;
				clip.start() ;
				controlador.getPalanca().moverPalanca(PalancaEstado.REINICIANDO) ;
			}
		}) ;
		botonReiniciar.setBounds(12, 258, 238, 25) ;
		add(botonReiniciar) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonFrenar = new JButton("FRENAR") ;
		botonFrenar.setBounds(12, 160, 100, 25) ;
		add(botonFrenar) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		botonActivo = new JLabel() ;
		botonActivo.setBorder(new LineBorder(Color.RED)) ;
		botonActivo.setBounds(8, 45, 108, 95) ;
		add(botonActivo) ;
		
		////////////////////////////////////////////////////////////////////////////////////
		
		pulsandoBotonFrenar = false ;
	}
	
	// Realiza las tareas periódicas asociadas a este panel. En función del estado actual de la
	// palanca, mueve la etiqueta que representa el rectángulo rojo al botón asociado a dicho estado
	// de la palanca. Por otra parte, realiza las tareas pertinentes cuando el botón frenar es pulsado
	// y se deja de pulsar, ya que es el único de los 8 botones que actúa cuando se mantiene 
	// el clic sobre él
	
	public synchronized void accionesPeriodicas(){
		if (botonFrenar.getModel().isPressed()){
			controlador.getPalanca().moverPalanca(PalancaEstado.FRENANDO) ;
			if (!pulsandoBotonFrenar){
				clip.setFramePosition(0) ;
				clip.start() ;
				pulsandoBotonFrenar = true ;
			}
		}
		
		else if (!botonFrenar.getModel().isPressed()){
			pulsandoBotonFrenar = false ;
			if (observadorestado.getEstadoPalanca() == PalancaEstado.FRENANDO)
				controlador.getPalanca().moverPalanca(PalancaEstado.APAGADO) ;
		}
		
		switch(observadorestado.getEstadoPalanca()){
			case MOTORAPAGADO: botonActivo.setBounds(8, 45, 108, 95) ;
			break ;
			case ENCENDIDO: botonActivo.setBounds(120, 45, 134, 95) ;
			break ;
			case ACELERANDO: botonActivo.setBounds(120, 156, 134, 33) ;
			break ;
			case FRENANDO: botonActivo.setBounds(8, 156, 108, 33) ;
			break ;
			case AUTOMATICO: botonActivo.setBounds(8, 204, 246, 33) ;
			break ;
			case REINICIANDO: botonActivo.setBounds(8, 254, 246, 33) ;
			break ;
			case APAGADO: botonActivo.setBounds(8, 304, 246, 33) ;
			break ;
		}
	}
}




