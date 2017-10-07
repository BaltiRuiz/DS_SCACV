package ControlVelocidad;

import junit.framework.TestCase;

public class AutomaticoTest extends TestCase {
	
	private Automatico automatico ;
	private Acelerador acelerador ;
	private Freno freno ;
	private Almacenamiento almacenamiento ;
	private Eje eje ;
	
	public void setUp(){
		automatico = new Automatico() ;
		acelerador = new Acelerador() ;
		freno = new Freno() ;
		almacenamiento = new Almacenamiento() ;
		eje = new Eje() ;
	}
	
	public void testMantenerVelocidad(){
		almacenamiento.almacenarVelocidad(100) ;
		eje.incrementarVueltas(500) ;
		automatico.mantenerVelocidad(acelerador, freno, almacenamiento, eje) ;
		assertEquals(200, eje.leerRevoluciones()) ;
		almacenamiento.almacenarVelSeleccionada() ;
		almacenamiento.almacenarVelocidad(50) ;
		automatico.mantenerVelocidad(acelerador, freno, almacenamiento, eje) ;
		assertEquals(500, eje.leerRevoluciones()) ;
		almacenamiento.almacenarVelSeleccionada() ;
		automatico.mantenerVelocidad(acelerador, freno, almacenamiento, eje) ;
		assertEquals(500, eje.leerRevoluciones()) ;
	}
}
