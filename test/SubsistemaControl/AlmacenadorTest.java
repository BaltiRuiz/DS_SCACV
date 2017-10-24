package SubsistemaControl;

import junit.framework.TestCase;

public class AlmacenadorTest extends TestCase{	
	public void testReflexivo(){
		Almacenador operando1 = new Almacenador() ;
		assertEquals(operando1, operando1) ;
	}
	
	public void testSimetrico(){
		Almacenador operando1 = new Almacenador() ;
		Almacenador operando2 = new Almacenador() ;
		Almacenador operando3 = new Almacenador() ;
		operando3.almacenarEstadoAcelerador(1) ;
		assertEquals(operando1, operando2) ;
		assertEquals(operando2, operando1) ;
		assertFalse(operando1.equals(operando3)) ;
		assertFalse(operando3.equals(operando1)) ;
	}
	
	public void testTransitivo(){
		Almacenador operando1 = new Almacenador() ;
		Almacenador operando2 = new Almacenador() ;
		Almacenador operando3 = operando2 ;
		assertEquals(operando3, operando2) ;
		assertEquals(operando1, operando3) ;
	}
	
	public void testAlmacenar(){
		Almacenador operando1 = new Almacenador() ;
		operando1.almacenarEstadoPalanca(PalancaEstado.ENCENDIDO) ;
		assertEquals(PalancaEstado.ENCENDIDO, operando1.getEstadoPalanca()) ;
		operando1.almacenarVelocidad(50.0) ;
		double operando2 = 50.0 ;
		assertTrue(operando2 == operando1.getVelocidad()) ;
		operando1.almacenarVelocidadAutomatica(50.0) ;
		assertTrue(operando2 == operando1.getVelocidadAutomatica()) ;
		operando1.almacenarVelocidadMedia(50.0) ;
		assertTrue(operando2 == operando1.getVelocidadMedia()) ;
		operando1.almacenarNivelDeposito(50) ;
		assertEquals((int) operando2, operando1.getNivelDeposito()) ;
		operando1.almacenarGastoCombustibleMedio(50.0) ;
		assertTrue(operando2 == operando1.getGastoCombustibleMedio()) ;
		operando1.almacenarRevolucionesEje(50) ;
		assertEquals((int) operando2, operando1.getRevolucionesEje()) ;
		operando1.almacenarRadioEje(50.0) ;
		assertTrue(operando2 == operando1.getRadioEje()) ;
		operando1.almacenarEstadoAcelerador(1) ;
		assertEquals(1, operando1.getEstadoAcelerador()) ;
		operando1.almacenarEstadoFreno(1) ;
		assertEquals(1, operando1.getEstadoFreno()) ;
		operando1.almacenarTiempo(100) ;
		assertEquals(100, operando1.getTiempo()) ;
	}
}
