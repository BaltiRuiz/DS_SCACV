package GUI;

import SubsistemaControl.Almacenador;
import junit.framework.TestCase;

public class ObservadorVelocidadTest extends TestCase{
	public void testReflexivo(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorVelocidad operando2 = new ObservadorVelocidad(operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		Almacenador operando1 = new Almacenador() ;
		Almacenador operando2 = new Almacenador() ;
		ObservadorVelocidad operando3 = new ObservadorVelocidad(operando1) ;
		ObservadorVelocidad operando4 = new ObservadorVelocidad(operando1) ;
		ObservadorVelocidad operando5 = new ObservadorVelocidad(operando2) ;
		operando2.almacenarVelocidad(50) ;
		assertEquals(operando3, operando4) ;
		assertEquals(operando4, operando3) ;
		assertFalse(operando3.equals(operando5)) ;
		assertFalse(operando5.equals(operando3)) ;
	}
	
	public void testTransitivo(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorVelocidad operando2 = new ObservadorVelocidad(operando1) ;
		ObservadorVelocidad operando3 = new ObservadorVelocidad(operando1) ;
		ObservadorVelocidad operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
	
	public void testManejarEvento(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorVelocidad operando2 = new ObservadorVelocidad(operando1) ;
		operando1.almacenarVelocidad(50) ;
		operando1.almacenarVelocidadAutomatica(50) ;
		operando1.almacenarVelocidadMedia(30) ;
		assertEquals(50, (int) operando2.getVelocidadActual()) ;
		assertEquals(50, (int) operando2.getVelocidadAutomatica()) ;
		assertEquals(30, (int) operando2.getVelocidadMedia()) ;
	}
}
