package SubsistemaControl;

import junit.framework.TestCase;

public class DispositivoAceleradorTest extends TestCase{
	public void testReflexivo(){
		DispositivoAcelerador operando1 = new DispositivoAcelerador() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		DispositivoAcelerador operando1 = new DispositivoAcelerador() ;
		DispositivoAcelerador operando2 = new DispositivoAcelerador() ;
		DispositivoAcelerador operando3 = new DispositivoAcelerador() ;
		operando3.pisarAcelerador() ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		DispositivoAcelerador operando1 = new DispositivoAcelerador() ;
		DispositivoAcelerador operando2 = new DispositivoAcelerador() ;
		DispositivoAcelerador operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testPisarAcelerador(){
		DispositivoAcelerador operando1 = new DispositivoAcelerador() ;
		operando1.pisarAcelerador() ;
		assertEquals(1, operando1.getEstadoAcelerador()) ;
	}
	
	public void testSoltarAcelerador(){
		DispositivoAcelerador operando1 = new DispositivoAcelerador() ;
		operando1.soltarAcelerador() ;
		assertEquals(0, operando1.getEstadoAcelerador()) ;
	}
}
