package ControlVelocidad;

import junit.framework.TestCase;

public class PedalTest extends TestCase {
	
	private Pedal operando1 ;
	private Pedal operando2 ;
	private Pedal operando3 ;
	private Pedal operando4 ;
	private Pedal operando5 ;
	private Pedal operando6 ;
	private Pedal operando7 ;
	private Pedal operando8 ;
	
	public void setUp(){
		operando1 = new Acelerador() ;
		operando2 = new Acelerador() ;
		operando3 = new Acelerador() ;
		operando4 = new Freno() ;
		operando5 = new Freno() ;
		operando6 = new Freno() ;
		operando7 = new Acelerador() ;
		operando8 = new Freno() ;
		operando3.pisar() ;
		operando6.pisar() ;
	}
	
	public void testLeerEstado(){
		assertEquals(false, operando1.leerEstado()) ;
		assertEquals(true, operando3.leerEstado()) ;
		assertEquals(false, operando4.leerEstado()) ;
		assertEquals(true, operando6.leerEstado()) ;
	}
	
	public void testPisar(){
		operando1.pisar() ;
		assertEquals(true, operando1.leerEstado()) ;
		operando4.pisar() ;
		assertEquals(true, operando4.leerEstado()) ;
	}
	
	public void testSoltar(){
		operando3.soltar() ;
		assertEquals(false, operando3.leerEstado()) ;
		operando6.soltar() ;
		assertEquals(false, operando6.leerEstado()) ;
	}
	
	public void testActualizar(){
		assertTrue(300 == operando1.actualizar()) ;
		assertTrue(800 == operando4.actualizar()) ;
	}
	
	public void testReflexivo(){
		assertEquals(operando1, operando1) ;
		assertEquals(operando4, operando4) ;
	}
	
	public void testSimetrico(){
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando3.equals(operando1)) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando2)) ;
		assertFalse(operando6.equals(operando4)) ;
		assertFalse(operando4.equals(operando6)) ;
		assertFalse(operando6.equals(operando5)) ;
		assertFalse(operando5.equals(operando6)) ;
	}
	
	public void testTransitivo(){
		assertEquals(operando2, operando7) ;
		assertEquals(operando1, operando7) ;
		assertEquals(operando5, operando8) ;
		assertEquals(operando4, operando8) ;
	}
}
