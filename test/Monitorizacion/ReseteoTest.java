package Monitorizacion;

import ControlVelocidad.Eje;
import junit.framework.TestCase;

public class ReseteoTest extends TestCase {
	
	CalculadorVelMed operando1 ;
	Eje operando2 ;
	Reseteo operando3 ;
	
	public void setUp(){
		operando1 = new CalculadorVelMed() ;
		operando2 = new Eje() ;
		operando3 = new Reseteo() ;
		
		operando2.setVelAnterior(50) ;
		operando2.setVueltasTotales(100) ;
		operando1.calcularVelocidadMedia(operando2) ;
	}
	
	public void testInicializar(){
		assertTrue(0 != operando2.leerRevolucionesTotales()) ;
		assertTrue(0 != operando1.getSumatoriaVel()) ;
		assertTrue(1 != operando1.getTiempoVel()) ;
		operando3.inicializarValores(operando1, operando2) ;
		assertEquals(0, operando2.leerRevolucionesTotales()) ;
		assertEquals(0, operando1.getSumatoriaVel()) ;
		assertEquals(1, operando1.getTiempoVel()) ;
	}
}
