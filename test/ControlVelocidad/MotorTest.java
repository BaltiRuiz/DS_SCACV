package ControlVelocidad;

import junit.framework.TestCase;

public class MotorTest extends TestCase {
	
	private Motor operando1 ;
	private Motor operando2 ;
	private Motor operando3 ;
	private Motor operando4 ;
	
	public void setUp(){
		operando1 = new Motor() ;
		operando2 = new Motor() ;
		operando3 = new Motor() ;
		operando4 = new Motor() ;
		
		operando3.cambiarEstado() ;
	}
	
	public void testCambiarEstado(){
		assertEquals(false, operando1.leerEstado()) ;
		operando1.cambiarEstado() ;
		assertEquals(true, operando1.leerEstado()) ;
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
