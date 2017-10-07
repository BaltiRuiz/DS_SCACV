package Monitorizacion;

import ControlVelocidad.Eje;
import junit.framework.TestCase;

public class CalculadorVelMedTest extends TestCase{
	
	private CalculadorVelMed operando1 ;
	private CalculadorVelMed operando2 ;
	private CalculadorVelMed operando3 ;
	private Eje operando4 ;
	private Deposito operando5 ;
	private CalculadorVelMed operando6 ;

	public void setUp(){
		operando1 = new CalculadorVelMed() ;
		operando2 = new CalculadorVelMed() ;
		operando3 = new CalculadorVelMed() ;
		operando4 = new Eje() ;
		operando5 = new Deposito() ;
		operando6 = new CalculadorVelMed() ;
		operando4.setVelAnterior(50) ;
		operando3.calcularVelocidadMedia(operando4) ;
	}
	
	public void testCalcularVelMedia(){
		assertEquals(50, (int) operando3.getVelMedia()) ;
		operando4.setVelAnterior(30) ;
		operando3.calcularVelocidadMedia(operando4) ;
		assertEquals(40, (int) operando3.getVelMedia()) ;
		operando3.setSumatoriaVel(1000000080) ;
		assertFalse(0 == operando3.getSumatoriaVel()) ;
		operando3.calcularVelocidadMedia(operando4) ;
		assertTrue(0 == operando3.getSumatoriaVel()) ;
	}
	
	public void testCalcularGastoMedio(){
		operando4.incrementarVueltas(10000) ;
		operando5.actualizarDeposito(operando4) ;
		double resultado = (operando3.getGastoValorAnterior() - operando5.leerNivelActual()) * 100 ;
		operando3.calcularGastoMedio(operando4, operando5) ;
		assertTrue(resultado == operando3.getGastoMedio()) ;
		
		double sumatoriagastemp = operando3.getSumatoriaGas() ;
		assertEquals(sumatoriagastemp, operando3.getSumatoriaGas()) ;
		operando3.calcularGastoMedio(operando4, operando5) ;
		assertEquals(sumatoriagastemp, operando3.getSumatoriaGas()) ;
		
		operando3.setSumatoriaGas(1500000000) ;
		assertFalse(0 == operando3.getSumatoriaGas()) ;
		operando3.calcularGastoMedio(operando4, operando5) ;
		assertTrue(0 == operando3.getSumatoriaGas()) ;
	}
	
	public void testResetear(){
		operando3.resetearTiempo() ;
		assertEquals(0, (int) operando3.getSumatoriaGas()) ;
		assertEquals(0, (int) operando3.getSumatoriaVel()) ;
		assertEquals(1, operando3.getTiempoGas()) ;
		assertEquals(1, operando3.getTiempoVel()) ;
	}
	
	public void testReflexivo(){
		assertEquals(operando1, operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
		assertFalse(operando2.equals(operando3)) ;
		assertFalse(operando3.equals(operando2)) ;
	}
	
	public void testTransitivo(){
		assertEquals(operando2, operando6) ;
		assertEquals(operando1, operando6) ;
	}
}
