package SubsistemaMonitorizacion;

import junit.framework.TestCase;

public class AlmacenadorMonitorizadorTest extends TestCase{	
	public void testReflexivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		AlmacenadorMonitorizador operando2 = new AlmacenadorMonitorizador() ;
		AlmacenadorMonitorizador operando3 = new AlmacenadorMonitorizador() ;
		operando3.almacenarCambioAceite(1) ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		AlmacenadorMonitorizador operando2 = new AlmacenadorMonitorizador() ;
		AlmacenadorMonitorizador operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testAlmacenar(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		operando1.almacenarCambioAceite(1) ;
		assertEquals(1, operando1.getCambioAceite()) ;
		operando1.almacenarCambioPastillas(1) ;
		assertEquals(1, operando1.getCambioPastillas()) ;
		operando1.almacenarRevisionGeneral(1) ;
		assertEquals(1, operando1.getRevisionGeneral()) ;
		operando1.almacenarRevolucionesAceite(500) ;
		assertEquals(500, operando1.getRevolucionesAceite()) ;
		operando1.almacenarRevolucionesPastillas(500) ;
		assertEquals(500, operando1.getRevolucionesPastillas()) ;
		operando1.almacenarRevolucionesGeneral(500) ;
		assertEquals(500, operando1.getRevolucionesGeneral()) ;
	}
}
