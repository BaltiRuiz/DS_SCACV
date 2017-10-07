package ControlVelocidad;

import junit.framework.TestCase;

public class ControlVelocidadTest extends TestCase {

	private ControlVelocidad elcontrol ;
	private Reloj elreloj ;
	
	public void setUp(){
		elcontrol = new ControlVelocidad(100) ;
		elreloj = elcontrol.getReloj() ;
		elcontrol.start() ;
	}
	
	public void testStartControlVelocidad(){
		assertSame(elcontrol.getReloj(), elreloj) ;
	}
	
	public void testCaminosControlVelocidad(){
		elcontrol.controlarEstado() ;
		assertEquals(0, elcontrol.getCamino()) ;
		elcontrol.getMotor().cambiarEstado() ;
		elcontrol.getAcelerador().pisar() ;
		elcontrol.controlarEstado() ;
		assertEquals(1, elcontrol.getCamino()) ;
		elcontrol.getAcelerador().soltar() ;
		elcontrol.getFreno().pisar() ;
		elcontrol.controlarEstado() ;
		assertEquals(2, elcontrol.getCamino()) ;
		elcontrol.getFreno().soltar() ;
		elcontrol.controlarEstado() ;
		assertEquals(3, elcontrol.getCamino()) ;
		elcontrol.getPalanca().cambiarEstado(Palanca.MANTENIENDO) ;
		elcontrol.controlarEstado() ;
		assertEquals(4, elcontrol.getCamino()) ;
		elcontrol.getPalanca().cambiarEstado(Palanca.REINICIANDO) ;
		elcontrol.controlarEstado() ;
		assertEquals(5, elcontrol.getCamino()) ;
		elcontrol.getMotor().cambiarEstado() ;
		elcontrol.getFreno().pisar() ;
		elcontrol.controlarEstado() ;
		assertEquals(6, elcontrol.getCamino()) ;
		elcontrol.getFreno().soltar() ;
	}
}
