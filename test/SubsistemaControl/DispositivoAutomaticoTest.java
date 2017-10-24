package SubsistemaControl;

import junit.framework.TestCase;

public class DispositivoAutomaticoTest extends TestCase{	
	public void testReflexivo(){
		DispositivoAutomatico operando1 = new DispositivoAutomatico() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		DispositivoAutomatico operando1 = new DispositivoAutomatico() ;
		DispositivoAutomatico operando2 = new DispositivoAutomatico() ;
		DispositivoAutomatico operando3 = new DispositivoAutomatico() ;
		operando3.activarControlAutomatico(10.0) ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		DispositivoAutomatico operando1 = new DispositivoAutomatico() ;
		DispositivoAutomatico operando2 = new DispositivoAutomatico() ;
		DispositivoAutomatico operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testActivarControlAutomatico(){
		DispositivoAutomatico operando1 = new DispositivoAutomatico() ;
		operando1.activarControlAutomatico(10.0) ;
		assertEquals(1, operando1.getEstado()) ;
		assertEquals(10, (int) operando1.getVelocidadAutomatica()) ;
	}
	
	public void testDesactivarControlAutomatico(){
		DispositivoAutomatico operando1 = new DispositivoAutomatico() ;
		operando1.activarControlAutomatico(10.0) ;
		operando1.desactivarControlAutomatico() ;
		assertEquals(0, operando1.getEstado()) ;
	}
	
	public void testOlvidarVelocidadAutomatica(){
		DispositivoAutomatico operando1 = new DispositivoAutomatico() ;
		operando1.activarControlAutomatico(10.0) ;
		operando1.olvidarVelocidadAutomatica() ;
		assertEquals(0, (int) operando1.getVelocidadAutomatica()) ;
	}
}
