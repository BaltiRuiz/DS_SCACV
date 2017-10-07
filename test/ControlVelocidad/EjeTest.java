package ControlVelocidad;

import junit.framework.TestCase;

public class EjeTest extends TestCase {

	private Eje operando1 ;
	private Eje operando2 ;
	private Eje operando3 ;
	private Eje operando4 ;
	private Almacenamiento operando5 ;
	
	public void setUp(){
		operando1 = new Eje() ;
		operando2 = new Eje() ;
		operando3 = new Eje() ;
		operando4 = new Eje() ;
		operando5 = new Almacenamiento() ;
		operando3.incrementarVueltas(100) ;
	}
	
	public void testIncrementarVueltas(){
		operando1.incrementarVueltas(500) ;
		assertEquals(500, operando1.leerRevoluciones()) ;
		operando1.incrementarVueltas(operando1.getMaxVueltas()) ;
		operando1.incrementarVueltas(operando1.getMaxVueltas() * 2) ;
		assertEquals(500 + operando1.getMaxVueltas(), operando1.leerRevoluciones()) ;
		operando1.setVueltas(-100) ;
		operando1.incrementarVueltas(50) ;
		assertEquals(0, operando1.leerRevoluciones()) ;
	}
	
	public void testCalcularVelocidad(){
		operando3.calcularVelocidad(operando5) ;
		assertEquals(2, operando3.getVelAnterior()) ;
		assertEquals(4, operando3.leerRevolucionesTotales()) ;
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
