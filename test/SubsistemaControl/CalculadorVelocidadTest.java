package SubsistemaControl;

import junit.framework.TestCase;

public class CalculadorVelocidadTest extends TestCase{	
	public void testReflexivo(){
		DispositivoEje operando1 = new DispositivoEje() ;
		CalculadorVelocidad operando2 = new CalculadorVelocidad(100, operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		DispositivoEje operando1 = new DispositivoEje() ;
		CalculadorVelocidad operando2 = new CalculadorVelocidad(100, operando1) ;
		CalculadorVelocidad operando3 = new CalculadorVelocidad(100, operando1) ;
		CalculadorVelocidad operando4 = new CalculadorVelocidad(200, operando1) ;
		assertEquals(operando2, operando3) ;
		assertEquals(operando3, operando2) ;
		assertFalse(operando2.equals(operando4)) ;
		assertFalse(operando4.equals(operando2)) ;
	}
	
	public void testTransitivo(){
		DispositivoEje operando1 = new DispositivoEje() ;
		CalculadorVelocidad operando2 = new CalculadorVelocidad(100, operando1) ;
		CalculadorVelocidad operando3 = new CalculadorVelocidad(100, operando1) ;
		CalculadorVelocidad operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
	
	public void testCalcularVelocidad(){
		DispositivoEje operando1 = new DispositivoEje() ;
		CalculadorVelocidad operando2 = new CalculadorVelocidad(100, operando1) ;
		operando1.incrementarVueltas(1) ;
		double operando3 = (operando1.getVueltasEje() * 2 * Math.PI * operando1.getRadioEje()) / (double) 100 ;
		double operando4 = operando2.calcularVelocidad() ;
		assertTrue(operando3 == operando4) ;
	}
	
	public void testReiniciarValores(){
		DispositivoEje operando1 = new DispositivoEje() ;
		CalculadorVelocidad operando2 = new CalculadorVelocidad(100, operando1) ;
		operando1.incrementarVueltas(1) ;
		operando2.calcularVelocidad() ;
		operando2.reiniciarValores() ;
		assertEquals(0, operando2.getVueltasAnteriores()) ;
	}
}
