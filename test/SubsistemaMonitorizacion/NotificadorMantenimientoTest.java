package SubsistemaMonitorizacion;

import junit.framework.TestCase;

public class NotificadorMantenimientoTest extends TestCase{	
	public void testReflexivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		AlmacenadorMonitorizador operando2 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando3 = new NotificadorMantenimiento(operando1) ;
		NotificadorMantenimiento operando4 = new NotificadorMantenimiento(operando1) ;
		NotificadorMantenimiento operando5 = new NotificadorMantenimiento(operando2) ;
		operando5.notificarCambioAceite() ;
		assertEquals(operando3, operando4) ;
		assertEquals(operando4, operando3) ;
		assertFalse(operando3.equals(operando5)) ;
		assertFalse(operando5.equals(operando3)) ;
	}
	
	public void testTransitivo(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando2 = new NotificadorMantenimiento(operando1) ;
		NotificadorMantenimiento operando3 = new NotificadorMantenimiento(operando1) ;
		NotificadorMantenimiento operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
	
	public void testNotificar(){
		AlmacenadorMonitorizador operando1 = new AlmacenadorMonitorizador() ;
		AlmacenadorMonitorizador operando2 = new AlmacenadorMonitorizador() ;
		NotificadorMantenimiento operando3 = new NotificadorMantenimiento(operando1) ;
		NotificadorMantenimiento operando4 = new NotificadorMantenimiento(operando2) ;
		operando3.notificarCambioAceite() ;
		operando4.notificarCambioAceite() ;
		assertEquals(operando3, operando4) ;
		operando3.notificarCambioPastillas() ;
		assertFalse(operando3.equals(operando4)) ;
		operando4.notificarCambioPastillas() ;
		assertEquals(operando3, operando4) ;
		operando4.notificarRevisionGeneral() ;
		assertFalse(operando4.equals(operando3)) ;
		operando3.notificarRevisionGeneral() ;
		assertEquals(operando3, operando4) ;
		operando3.notificarArregloVehiculo(0, 500) ;
		operando4.notificarArregloVehiculo(0, 500) ;
		assertEquals(operando3, operando4) ;
		operando3.notificarArregloVehiculo(1, 500) ;
		operando4.notificarArregloVehiculo(2, 500) ;
		assertFalse(operando3.equals(operando4)) ;
	}
}
