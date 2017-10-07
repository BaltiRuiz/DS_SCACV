package ControlVelocidad;

import junit.framework.TestCase;

public class CalculadorVelTest extends TestCase {
	
	private CalculadorVel calculador ;
	private Almacenamiento almacenamiento ;
	
	public void setUp(){
		calculador = new CalculadorVel() ;
		almacenamiento = new Almacenamiento() ;
	}
	
	public void testCalculadorVelocidad(){
		calculador.almacenarVelocidad(50, almacenamiento) ;
		assertEquals(50, almacenamiento.leerVelocidad()) ;
		int velocidad = calculador.calcularVelocidad(100, 4, almacenamiento) ;
		assertEquals(10, velocidad) ;
	}
}
