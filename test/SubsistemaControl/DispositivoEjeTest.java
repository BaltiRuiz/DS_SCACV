package SubsistemaControl;

import junit.framework.TestCase;

public class DispositivoEjeTest extends TestCase{	
	public void testReflexivo(){
		DispositivoEje operando1 = new DispositivoEje() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		DispositivoEje operando1 = new DispositivoEje() ;
		DispositivoEje operando2 = new DispositivoEje() ;
		DispositivoEje operando3 = new DispositivoEje() ;
		operando3.incrementarVueltas(1) ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		DispositivoEje operando1 = new DispositivoEje() ;
		DispositivoEje operando2 = new DispositivoEje() ;
		DispositivoEje operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testIncrementarVueltas(){
		DispositivoEje operando1 = new DispositivoEje() ;
		operando1.incrementarVueltas(1) ;
		assertEquals(5, operando1.getVueltasEje()) ;
		operando1.incrementarVueltas(0) ;
		assertEquals(10, operando1.getVueltasEje()) ;
	}
	
	public void testDecrementarVueltas(){
		DispositivoEje operando1 = new DispositivoEje() ;
		operando1.incrementarVueltas(1) ;
		operando1.incrementarVueltas(1) ;
		operando1.decrementarVueltas(0) ;
		assertEquals(9, operando1.getIncremento()) ;
		operando1.decrementarVueltas(1) ;
		assertEquals(4, operando1.getIncremento()) ;
	}
	
	public void testReiniciarVueltas(){
		DispositivoEje operando1 = new DispositivoEje() ;
		operando1.incrementarVueltas(1) ;
		operando1.decrementarVueltas(0) ;
		operando1.reiniciarVueltas() ;
		assertEquals(0, operando1.getVueltasEje()) ;
		assertEquals(0, operando1.getIncremento()) ;
	}
}
