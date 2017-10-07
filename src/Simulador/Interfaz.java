package Simulador;
import javax.swing.*;
import ControlVelocidad.*;
import Monitorizacion.*;

@SuppressWarnings("serial")
public class Interfaz extends JApplet {
	JLabel etiquetaVelAuto, etiquetaEstado ;
	Simulacion simulacion ;
	Monitorizacion monitor ;
	ControlVelocidad control ;
	PanelEtiquetas panelE ;
	PanelBotones panelB ;
	
	public void init(){
		this.setSize(800, 600) ;
	}
	
	public Interfaz(){
		panelE = new PanelEtiquetas(this) ;
		panelB = new PanelBotones(this) ;
		simulacion = new Simulacion() ;
		simulacion.addObservador(panelE) ;
		simulacion.addObservador(panelB) ;
		control = new ControlVelocidad(250) ;
		monitor = new Monitorizacion(control.eje) ;		
		panelE.aniadirComponentes(monitor, control) ;
		panelB.aniadirComponentes(monitor, control) ;
		simulacion.start() ;
		control.start() ;
		monitor.start() ;
		add(panelB) ;		
		add(panelE) ;
		setVisible(true) ;
		destroy() ;
	}
	
	public Simulacion getSimulacion(){
		return simulacion ;
	}
	
	public Monitorizacion getMonitor(){
		return monitor ;
	}
	
	public ControlVelocidad getControl(){
		return control ;
	}
	
	public PanelEtiquetas getPanelEtiquetas(){
		return panelE ;
	}
	
	public PanelBotones getPanelBotones(){
		return panelB ;
	}
}




