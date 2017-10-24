package GUI;

import SubsistemaMonitorizacion.AlmacenadorMonitorizador;
import junit.framework.TestCase;

public class ObservadorMonitorizacionTest extends TestCase{
	public void testReflexivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		ObservadorMonitorizacion operando2 = new ObservadorMonitorizacion(operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		AlmacenadorMonitorizador operando2 = new AlmacenadorMonitorizador() ;
		ObservadorMonitorizacion operando3 = new ObservadorMonitorizacion(operando1) ;
		ObservadorMonitorizacion operando4 = new ObservadorMonitorizacion(operando1) ;
		ObservadorMonitorizacion operando5 = new ObservadorMonitorizacion(operando2) ;
		operando2.almacenarCambioAceite(1) ;
		assertEquals(operando3, operando4) ;
		assertEquals(operando4, operando3) ;
		assertFalse(operando3.equals(operando5)) ;
		assertFalse(operando5.equals(operando3)) ;
	}
	
	public void testTransitivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		ObservadorMonitorizacion operando2 = new ObservadorMonitorizacion(operando1) ;
		ObservadorMonitorizacion operando3 = new ObservadorMonitorizacion(operando1) ;
		ObservadorMonitorizacion operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
	
	public void testManejarEvento(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		ObservadorMonitorizacion operando2 = new ObservadorMonitorizacion(operando1) ;
		operando1.almacenarCambioAceite(1) ;
		operando1.almacenarCambioPastillas(1) ;
		operando1.almacenarRevisionGeneral(1) ;
		operando1.almacenarRevolucionesAceite(50) ;
		operando1.almacenarRevolucionesGeneral(100) ;
		operando1.almacenarRevolucionesPastillas(70) ;
		assertEquals(1, operando2.getCambioAceite()) ;
		assertEquals(1, operando2.getCambioPastillas()) ;
		assertEquals(1, operando2.getRevisionGeneral()) ;
		assertEquals(50, operando2.getRevolucionesAceite()) ;
		assertEquals(70, operando2.getRevolucionesPastillas()) ;
		assertEquals(100, operando2.getRevolucionesRevisionGeneral()) ;
	}
}
