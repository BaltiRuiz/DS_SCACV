package SubsistemaMonitorizacion;

import SubsistemaControl.Almacenador;
import junit.framework.TestCase;

public class ControladorMonitorizadorTest extends TestCase{
	public void testReflexivo(){
		Almacenador operando1 = new Almacenador() ;
		ControladorMonitorizador operando2 = ControladorMonitorizador.getInstance(operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		Almacenador operando1 = new Almacenador() ;
		ControladorMonitorizador operando2 = ControladorMonitorizador.getInstance(operando1) ;
		ControladorMonitorizador operando3 = ControladorMonitorizador.getInstance(operando1) ;
		assertEquals(operando2, operando3) ;
		assertEquals(operando3, operando2) ;
	}
	
	public void testTransitivo(){
		Almacenador operando1 = new Almacenador() ;
		ControladorMonitorizador operando2 = ControladorMonitorizador.getInstance(operando1) ;
		ControladorMonitorizador operando3 = ControladorMonitorizador.getInstance(operando1) ;
		ControladorMonitorizador operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
}
