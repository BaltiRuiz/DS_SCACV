package SubsistemaControl;

import junit.framework.TestCase;

public class DispositivoFrenoTest extends TestCase{
	public void testReflexivo(){
		DispositivoFreno operando1 = new DispositivoFreno() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		DispositivoFreno operando1 = new DispositivoFreno() ;
		DispositivoFreno operando2 = new DispositivoFreno() ;
		DispositivoFreno operando3 = new DispositivoFreno() ;
		operando3.pisarFreno() ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		DispositivoFreno operando1 = new DispositivoFreno() ;
		DispositivoFreno operando2 = new DispositivoFreno() ;
		DispositivoFreno operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testPisarFreno(){
		DispositivoFreno operando1 = new DispositivoFreno() ;
		operando1.pisarFreno() ;
		assertEquals(1, operando1.getEstadoFreno()) ;
	}
	
	public void testSoltarFreno(){
		DispositivoFreno operando1 = new DispositivoFreno() ;
		operando1.soltarFreno() ;
		assertEquals(0, operando1.getEstadoFreno()) ;
	}
}
