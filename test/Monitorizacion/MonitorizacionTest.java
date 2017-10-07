package Monitorizacion;

import ControlVelocidad.Eje;
import junit.framework.TestCase;

public class MonitorizacionTest extends TestCase {
	
	private Eje eleje ;
	private Monitorizacion elmonitor ;
	private RelojM elreloj ;
	
	public void setUp(){
		eleje = new Eje() ;
		elmonitor = new Monitorizacion(eleje) ;
		elreloj = elmonitor.getReloj() ;
		elmonitor.start() ;
	}
	
	public void testStartMonitorizacion(){
		assertSame(elmonitor.getReloj(), elreloj) ;
	}
	
	public void testComprobarNotificaciones(){
		assertNull(elmonitor.comprobarNotificacionesAceite()) ;
		elmonitor.getNotificaciones().setRevolAceite(elmonitor.getNotificaciones().getInicialAceite() + 1) ;
		assertEquals(elmonitor.getNotificaciones().leerNotifAceite(), elmonitor.comprobarNotificacionesAceite()) ;
		assertNull(elmonitor.comprobarNotificacionesPastillas()) ;
		elmonitor.getNotificaciones().setRevolPastillas(elmonitor.getNotificaciones().getInicialPastillas() + 1) ;
		assertEquals(elmonitor.getNotificaciones().leerNotifPastillas(), elmonitor.comprobarNotificacionesPastillas()) ;
		assertNull(elmonitor.comprobarNotificacionesGeneral()) ;
		elmonitor.getNotificaciones().setRevolRevision(elmonitor.getNotificaciones().getInicialRevision() + 1) ;
		assertEquals(elmonitor.getNotificaciones().leerNotifRevision(), elmonitor.comprobarNotificacionesGeneral()) ;
	}
}
