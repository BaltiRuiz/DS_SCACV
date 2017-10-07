package ControlVelocidad;

import junit.framework.TestCase;

public class PalancaTest extends TestCase {
	
	private Palanca operando1 ;
	private Palanca operando2 ;
	private Palanca operando3 ;
	private Palanca operando4 ;
	
	public void setUp(){
		operando1 = new Palanca() ;
		operando2 = new Palanca() ;
		operando3 = new Palanca() ;
		operando4 = new Palanca() ;
		
		operando3.cambiarEstado(Palanca.MANTENIENDO) ;
	}
	
	public void testCambiarEstado(){
		assertEquals(Palanca.APAGADO, operando1.leerEstado()) ;
		operando1.cambiarEstado(Palanca.REINICIANDO) ;
		assertEquals(Palanca.REINICIANDO, operando1.leerEstado()) ;
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
