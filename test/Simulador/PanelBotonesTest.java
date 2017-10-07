package Simulador;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import ControlVelocidad.ControlVelocidad;
import ControlVelocidad.Palanca;
import Monitorizacion.Monitorizacion;
import junit.framework.TestCase;

public class PanelBotonesTest extends TestCase {

	private Interfaz lainterfaz ;
	private PanelBotones elpanel ;
	private ControlVelocidad elcontrol ;
	private Monitorizacion elmonitor ;
	private ActionEvent evento ;
	
	public void setUp(){
		lainterfaz = new Interfaz() ;
		elcontrol = lainterfaz.getControl() ;
		elmonitor = lainterfaz.getMonitor() ;
		elpanel = new PanelBotones(lainterfaz) ;
		elpanel.aniadirComponentes(elmonitor, elcontrol) ;
		
		MouseEvent eventoraton = new MouseEvent(new Label(), 0, 0, 0, 0, 0, 0, false) ;
		evento = new ActionEvent(eventoraton.getSource(), eventoraton.getID(), eventoraton.paramString()) ;
	}
	
	public void testBotonesControlActionPerformed(){
		assertTrue(!elcontrol.getMotor().leerEstado()) ;
		elpanel.BotonEncenderActionPerformed(evento) ;
		assertTrue(elcontrol.getMotor().leerEstado()) ;
		assertTrue(!elcontrol.getAcelerador().leerEstado()) ;
		
		assertTrue(elcontrol.getPalanca().leerEstado() == Palanca.APAGADO) ;
		assertTrue(!elcontrol.getAcelerador().leerEstado()) ;
		
		elpanel.BotonAcelerarActionPerformed(evento) ;
		assertTrue(elcontrol.getPalanca().leerEstado() == Palanca.APAGADO) ;
		assertTrue(elcontrol.getAcelerador().leerEstado()) ;
		assertTrue(!elcontrol.getFreno().leerEstado()) ;
		
		elpanel.BotonMantenerActionPerformed(evento) ;
		assertTrue(elcontrol.getPalanca().leerEstado() == Palanca.MANTENIENDO) ;
		
		elpanel.BotonPararActionPerformed(evento) ;
		assertTrue(elcontrol.getPalanca().leerEstado() == Palanca.APAGADO) ;
		assertTrue(!elcontrol.getAcelerador().leerEstado()) ;
		assertTrue(!elcontrol.getFreno().leerEstado()) ;
		
		elpanel.BotonReiniciarActionPerformed(evento) ;
		assertTrue(elcontrol.getPalanca().leerEstado() == Palanca.REINICIANDO) ;
		assertTrue(!elcontrol.getAcelerador().leerEstado()) ;
		assertTrue(!elcontrol.getFreno().leerEstado()) ;
		
		elpanel.getBotonFreno().setSelected(true) ;
		elpanel.BotonFrenoActionPerformed(evento) ;
		assertTrue(elcontrol.getPalanca().leerEstado() == Palanca.APAGADO) ;
		assertTrue(elcontrol.getFreno().leerEstado()) ;
		assertTrue(!elcontrol.getAcelerador().leerEstado()) ;
		elpanel.getBotonFreno().setSelected(false) ;
		elpanel.BotonFrenoActionPerformed(evento) ;
		assertTrue(!elcontrol.getFreno().leerEstado()) ;	
	}
	
	public void testBotonesMonitorActionPerformed(){
		elmonitor.getDeposito().setNivelActual(50) ;
		elpanel.BotonRepostarActionPerformed(evento) ;
		assertTrue(elmonitor.getDeposito().leerNivelActual() == elmonitor.getDeposito().leerNivelInicial()) ;
		
		// No realizo test sobre BotonRestearActionPerformed porque llama a un único método ('inicializarValores' de la clase
		// 'Reseteo') que ya es comprobado en su TestCase correspondiente
		
		elmonitor.getNotificaciones().setRevActuales(100) ;
		elpanel.BotonMecanico1ActionPerformed(evento) ;
		assertTrue(elmonitor.getNotificaciones().getAnteriorAceite() == 100) ;
		elpanel.BotonMecanico2ActionPerformed(evento) ;
		assertTrue(elmonitor.getNotificaciones().getAnteriorPastillas() == 100) ;
		elpanel.BotonMecanico3ActionPerformed(evento) ;
		assertTrue(elmonitor.getNotificaciones().getAnteriorRevision() == 100) ;
	}
	
	public void testActualizar(){
		elpanel.actualizar() ;
		assertTrue(elpanel.getBotonRepostar().isEnabled()) ;
		assertTrue(elpanel.getBotonRestear().isEnabled()) ;
		assertTrue(elpanel.getBotonMecanico1().isEnabled()) ;
		assertTrue(elpanel.getBotonMecanico2().isEnabled()) ;
		assertTrue(elpanel.getBotonMecanico3().isEnabled()) ;
		assertTrue(!elpanel.getBotonAcelerar().isEnabled()) ;
		assertTrue(!elpanel.getBotonParar().isEnabled()) ;
		assertTrue(!elpanel.getBotonMantener().isEnabled()) ;
		assertTrue(!elpanel.getBotonReiniciar().isEnabled()) ;
		
		elcontrol.getMotor().cambiarEstado() ;
		elpanel.actualizar() ;
		assertTrue(elpanel.getBotonAcelerar().isEnabled()) ;
		assertTrue(!elpanel.getBotonRepostar().isEnabled()) ;
		assertTrue(!elpanel.getBotonRestear().isEnabled()) ;
		assertTrue(!elpanel.getBotonMecanico1().isEnabled()) ;
		assertTrue(!elpanel.getBotonMecanico2().isEnabled()) ;
		assertTrue(!elpanel.getBotonMecanico3().isEnabled()) ;
		
		elcontrol.getAcelerador().pisar() ;
		elpanel.actualizar() ;
		assertTrue(elpanel.getBotonMantener().isEnabled()) ;
		assertTrue(elpanel.getBotonReiniciar().isEnabled()) ;
		assertTrue(!elpanel.getBotonParar().isEnabled()) ;
		assertTrue(!elpanel.getBotonAcelerar().isEnabled()) ;
		
		elcontrol.getPalanca().cambiarEstado(Palanca.MANTENIENDO) ;
		elpanel.actualizar() ;
		assertTrue(elpanel.getBotonAcelerar().isEnabled()) ;
		assertTrue(elpanel.getBotonParar().isEnabled()) ;
		assertTrue(!elpanel.getBotonMantener().isEnabled()) ;
		assertTrue(!elpanel.getBotonReiniciar().isEnabled()) ;
		
		elcontrol.getPalanca().cambiarEstado(Palanca.REINICIANDO) ;
		elpanel.actualizar() ;
		assertTrue(elpanel.getBotonAcelerar().isEnabled()) ;
		assertTrue(elpanel.getBotonParar().isEnabled()) ;
		assertTrue(!elpanel.getBotonMantener().isEnabled()) ;
		assertTrue(!elpanel.getBotonReiniciar().isEnabled()) ;
		
		elcontrol.getPalanca().cambiarEstado(Palanca.APAGADO) ;
		elcontrol.getAcelerador().soltar() ;
		elpanel.actualizar() ;
		assertTrue(elpanel.getBotonAcelerar().isEnabled()) ;
		assertTrue(elpanel.getBotonReiniciar().isEnabled()) ;
		assertTrue(!elpanel.getBotonParar().isEnabled()) ;
		assertTrue(!elpanel.getBotonMantener().isEnabled()) ;
	}
}
