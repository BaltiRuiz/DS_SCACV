package SubsistemaMonitorizacion;

import junit.framework.TestCase;

public class MonitorizadorMotorTest extends TestCase{	
	public void testReflexivo(){
		MonitorizadorMotor operando1 = new MonitorizadorMotor(0.5) ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		MonitorizadorMotor operando1 = new MonitorizadorMotor(0.5) ;
		MonitorizadorMotor operando2 = new MonitorizadorMotor(0.5) ;
		MonitorizadorMotor operando3 = new MonitorizadorMotor(1) ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		MonitorizadorMotor operando1 = new MonitorizadorMotor(0.5) ;
		MonitorizadorMotor operando2 = new MonitorizadorMotor(0.5) ;
		MonitorizadorMotor operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testActualizarValores(){
		MonitorizadorMotor operando1 = new MonitorizadorMotor(1) ;
		operando1.actualizarValores(500, 100) ;
		assertEquals(500, operando1.getRevolucionesTotales()) ;
		assertEquals(100, operando1.getTiempo()) ;
	}
	
	public void testCalcularVelocidadPromedio(){
		MonitorizadorMotor operando1 = new MonitorizadorMotor(1) ;
		assertEquals(0, (int) operando1.calcularVelocidadPromedio()) ;
		operando1.actualizarValores(500, 100) ;
		double operando2 = (500 * 2 * Math.PI * 1) / (double) 100 ;
		assertTrue(operando2 == operando1.calcularVelocidadPromedio()) ;
	}
	
	public void testReiniciarValores(){
		MonitorizadorMotor operando1 = new MonitorizadorMotor(1) ;
		operando1.actualizarValores(500, 100) ;
		operando1.reiniciarValores() ;
		assertEquals(0, operando1.getRevolucionesTotales()) ;
	}
}
