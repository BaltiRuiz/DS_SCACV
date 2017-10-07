package Monitorizacion;

import ControlVelocidad.Eje;
import junit.framework.TestCase;

public class NotificacionesTest extends TestCase {
	
	private Notificaciones operando1 ;
	private Notificaciones operando2 ;
	private Notificaciones operando3 ;
	private Notificaciones operando4 ;
	private Eje operando5 ;
	
	public void setUp(){
		operando1 = new Notificaciones() ;
		operando2 = new Notificaciones() ;
		operando3 = new Notificaciones() ;
		operando4 = new Notificaciones() ;
		operando5 = new Eje() ;
		
		operando5.setVueltasTotales(100) ;
		operando3.actualizarNotificaciones(operando5) ;
	}
	
	public void testActualizar(){
		operando1.actualizarNotificaciones(operando5) ;
		assertEquals(100, operando1.leerRevolAceite()) ;
		assertEquals(100, operando1.leerRevolPastillas()) ;
		assertEquals(100, operando1.leerRevolRevision()) ;
	}
	
	public void testNotificar(){
		assertEquals(false, operando1.notificarAceite()) ;
		operando1.setRevolAceite(operando1.getInicialAceite() + 1) ;
		assertEquals(true, operando1.notificarAceite()) ;
		assertEquals(false, operando1.notificarPastillas()) ;
		operando1.setRevolPastillas(operando1.getInicialPastillas() + 1) ;
		assertEquals(true, operando1.notificarPastillas()) ;
		assertEquals(false, operando1.notificarRevision()) ;
		operando1.setRevolRevision(operando1.getInicialRevision() + 1) ;
		assertEquals(true, operando1.notificarRevision()) ;
	}
	
	public void testReflexivo(){
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando3.equals(operando1)) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando2)) ;
		assertFalse(operando2.equals(operando3)) ;
	}
	
	public void testTransitivo(){
		assertEquals(operando2, operando4) ;
		assertEquals(operando1, operando4) ;
	}
}
