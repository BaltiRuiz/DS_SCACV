package Monitorizacion;

import ControlVelocidad.Eje;
import junit.framework.TestCase;

public class DepositoTest extends TestCase {
	
	private Deposito operando1 ;
	private Deposito operando2 ;
	private Deposito operando3 ;
	private Deposito operando4 ;
	private Eje operando5 ;
	
	public void setUp(){
		operando1 = new Deposito() ;
		operando2 = new Deposito() ;
		operando3 = new Deposito() ;
		operando4 = new Deposito() ;
		operando5 = new Eje() ;
		operando5.incrementarVueltas(10000) ;
		operando3.actualizarDeposito(operando5) ;
	}
	
	public void testActualizarDeposito(){
		double resultado = operando3.leerNivelInicial() - (operando5.leerRevoluciones()*( (operando5.leerRevoluciones()/15)) * operando1.getRatioConsumo() ) ;
		assertTrue(resultado == operando3.leerNivelActual()) ;
		operando3.setNivelActual(-100) ;
		operando3.actualizarDeposito(operando5) ;
		assertTrue(0 == operando3.leerNivelActual()) ;
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
