package GUI;

import SubsistemaControl.Almacenador;
import junit.framework.TestCase;

public class ObservadorDepositoTest extends TestCase{
	public void testReflexivo(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorDeposito operando2 = new ObservadorDeposito(operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		Almacenador operando1 = new Almacenador() ;
		Almacenador operando2 = new Almacenador() ;
		ObservadorDeposito operando3 = new ObservadorDeposito(operando1) ;
		ObservadorDeposito operando4 = new ObservadorDeposito(operando1) ;
		ObservadorDeposito operando5 = new ObservadorDeposito(operando2) ;
		operando2.almacenarNivelDeposito(50) ;
		assertEquals(operando3, operando4) ;
		assertEquals(operando4, operando3) ;
		assertFalse(operando3.equals(operando5)) ;
		assertFalse(operando5.equals(operando3)) ;
	}
	
	public void testTransitivo(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorDeposito operando2 = new ObservadorDeposito(operando1) ;
		ObservadorDeposito operando3 = new ObservadorDeposito(operando1) ;
		ObservadorDeposito operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
	
	public void testManejarEvento(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorDeposito operando2 = new ObservadorDeposito(operando1) ;
		operando1.almacenarNivelDeposito(50) ;
		operando1.almacenarGastoCombustibleMedio(30) ;
		assertEquals(50, operando2.getNivelDeposito()) ;
		assertEquals(30, (int) operando2.getGastoMedio()) ;
	}
}
