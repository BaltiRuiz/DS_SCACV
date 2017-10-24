package SubsistemaControl;

import junit.framework.TestCase;

public class ControladorTest extends TestCase{
	public void testReflexivo(){
		Controlador operando1 = Controlador.getInstance() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		Controlador operando1 = Controlador.getInstance() ;
		Controlador operando2 = Controlador.getInstance() ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
	}
	
	public void testTransitivo(){
		Controlador operando1 = Controlador.getInstance() ;
		Controlador operando2 = Controlador.getInstance() ;
		Controlador operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testVelocidadExcesiva(){
		try{
			Controlador operando1 = Controlador.getInstance() ;
			operando1.getMotor().encenderMotor() ;
			for (int i = 0 ; i < 40 ; i++)
				operando1.getEje().incrementarVueltas(1) ;
			operando1.accionesPeriodicas() ;
			fail("Debería lanzar una excepción por superar los 250 km/h") ;
		}
		catch(Exception e){
			assertTrue(e instanceof IllegalStateException) ;
			assertTrue("Velocidad excesiva".equals(e.getMessage())) ;
		}
	}
	
	public void testDepositoVacio(){
		try{
			Controlador operando1 = Controlador.getInstance() ;
			operando1.getMotor().encenderMotor() ;
			operando1.getDeposito().vaciarDeposito(operando1.getDeposito().getNivelDeposito()) ;
			operando1.accionesPeriodicas() ;
			fail("Debería lanzar una excepción si hay nivel 0 en el depósito") ;
		}
		catch(Exception e){
			assertTrue(e instanceof IllegalStateException) ;
			assertTrue("Depósito vacío".equals(e.getMessage())) ;
		}
	}
}
