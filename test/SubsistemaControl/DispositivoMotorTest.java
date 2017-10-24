package SubsistemaControl;

import junit.framework.TestCase;

public class DispositivoMotorTest extends TestCase{	
	public void testReflexivo(){
		DispositivoMotor operando1 = new DispositivoMotor() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		DispositivoMotor operando1 = new DispositivoMotor() ;
		DispositivoMotor operando2 = new DispositivoMotor() ;
		DispositivoMotor operando3 = new DispositivoMotor() ;
		operando3.encenderMotor() ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		DispositivoMotor operando1 = new DispositivoMotor() ;
		DispositivoMotor operando2 = new DispositivoMotor() ;
		DispositivoMotor operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testEncenderMotor(){
		DispositivoMotor operando = new DispositivoMotor() ;
		operando.encenderMotor() ;
		assertEquals(1, operando.getEstadoMotor()) ;
	}
	
	public void testApagarMotor(){
		DispositivoMotor operando = new DispositivoMotor() ;
		operando.apagarMotor() ;
		assertEquals(0, operando.getEstadoMotor()) ;
	}
}
