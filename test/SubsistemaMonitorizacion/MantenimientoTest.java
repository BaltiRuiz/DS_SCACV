package SubsistemaMonitorizacion;

import junit.framework.TestCase;

public class MantenimientoTest extends TestCase{	
	public void testReflexivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		Mantenimiento operando3 = new Mantenimiento(operando2) ;
		assertEquals(operando3, operando3) ;
	}
	
	public void testSimetrico(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		Mantenimiento operando3 = new Mantenimiento(operando2) ;
		Mantenimiento operando4 = new Mantenimiento(operando2) ;
		Mantenimiento operando5 = new Mantenimiento(operando2) ;
		operando5.actualizarValoresRevoluciones(100) ;
		assertEquals(operando3, operando4) ;
		assertEquals(operando4, operando3) ;
		assertFalse(operando3.equals(operando5)) ;
		assertFalse(operando5.equals(operando3)) ;
	}
	
	public void testTransitivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		Mantenimiento operando3 = new Mantenimiento(operando2) ;
		Mantenimiento operando4 = new Mantenimiento(operando2) ;
		Mantenimiento operando5 = operando4 ;
		assertEquals(operando5, operando4) ;
		assertEquals(operando3, operando5) ;
	}
	
	public void testActualizarValores(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		Mantenimiento operando3 = new Mantenimiento(operando2) ;
		operando3.actualizarValoresRevoluciones(5000000) ;
		assertEquals(5000000, operando3.getContadorRevoluciones()) ;
		assertEquals(5000000, operando3.getRevolucionesAnteriores()) ;
		assertEquals(5000000, operando3.getRevolucionesAceite()) ;
		assertEquals(1, operando1.getCambioAceite()) ;
		assertTrue(operando3.getCambiarAceite()) ;
	}
	
	public void testReiniciarValores(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		Mantenimiento operando3 = new Mantenimiento(operando2) ;
		operando3.actualizarValoresRevoluciones(100) ;
		operando3.reiniciarValores() ;
		assertEquals(0, operando3.getRevolucionesAnteriores()) ;
	}
	
	public void testArreglarVehiculo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		Mantenimiento operando3 = new Mantenimiento(operando2) ;
		operando3.actualizarValoresRevoluciones(100) ;
		operando3.arreglarVehiculo(0) ;
		assertEquals(0, operando3.getRevolucionesAceite()) ;
		assertTrue(!operando3.getCambiarAceite()) ;
		assertEquals(0, operando1.getCambioAceite()) ;
		assertEquals(100, operando1.getRevolucionesAceite()) ;
	}
}
