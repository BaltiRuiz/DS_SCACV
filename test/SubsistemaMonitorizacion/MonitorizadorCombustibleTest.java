package SubsistemaMonitorizacion;

import junit.framework.TestCase;

public class MonitorizadorCombustibleTest extends TestCase{	
	public void testReflexivo(){
		MonitorizadorCombustible operando1 = new MonitorizadorCombustible(100) ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		MonitorizadorCombustible operando1 = new MonitorizadorCombustible(100) ;
		MonitorizadorCombustible operando2 = new MonitorizadorCombustible(100) ;
		MonitorizadorCombustible operando3 = new MonitorizadorCombustible(500) ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		MonitorizadorCombustible operando1 = new MonitorizadorCombustible(100) ;
		MonitorizadorCombustible operando2 = new MonitorizadorCombustible(100) ;
		MonitorizadorCombustible operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testActualizarValores(){
		MonitorizadorCombustible operando1 = new MonitorizadorCombustible(100) ;
		operando1.actualizarValores(50, 100) ;
		assertEquals(50, operando1.getGastoTotal()) ;
		assertEquals(100, operando1.getTiempo()) ;
	}
	
	public void testCalcularVelocidadPromedio(){
		MonitorizadorCombustible operando1 = new MonitorizadorCombustible(100) ;
		assertEquals(0, (int) operando1.calcularGastoCombustiblePromedio()) ;
		operando1.actualizarValores(50, 100) ;
		assertTrue(0.5 == operando1.calcularGastoCombustiblePromedio()) ;
	}
	
	public void testReiniciarValores(){
		MonitorizadorCombustible operando1 = new MonitorizadorCombustible(100) ;
		operando1.actualizarValores(25, 100) ;
		operando1.reiniciarValores(50) ;
		assertEquals(50, operando1.getValorAnterior()) ;
		assertEquals(0, operando1.getGastoTotal()) ;
	}
}
