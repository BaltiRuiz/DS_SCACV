package SubsistemaControl;

import junit.framework.TestCase;

public class DepositoTest extends TestCase{	
	public void testReflexivo(){
		Deposito operando1 = new Deposito() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		Deposito operando1 = new Deposito() ;
		Deposito operando2 = new Deposito() ;
		Deposito operando3 = new Deposito() ;
		operando3.vaciarDeposito(100000) ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		Deposito operando1 = new Deposito() ;
		Deposito operando2 = new Deposito() ;
		Deposito operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testRellenarDeposito(){
		Deposito operando = new Deposito() ;
		operando.rellenarDeposito() ;
		assertEquals(4000000, operando.getNivelDeposito()) ;
	}
	
	public void testVaciarDeposito(){
		Deposito operando = new Deposito() ;
		operando.vaciarDeposito(1000000) ;
		assertEquals(3000000, operando.getNivelDeposito()) ;
	}
}
