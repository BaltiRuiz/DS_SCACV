package GUI;

import SubsistemaControl.Almacenador;
import SubsistemaControl.PalancaEstado;
import junit.framework.TestCase;

public class ObservadorEstadoTest extends TestCase{
	public void testReflexivo(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorEstado operando2 = new ObservadorEstado(operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		Almacenador operando1 = new Almacenador() ;
		Almacenador operando2 = new Almacenador() ;
		ObservadorEstado operando3 = new ObservadorEstado(operando1) ;
		ObservadorEstado operando4 = new ObservadorEstado(operando1) ;
		ObservadorEstado operando5 = new ObservadorEstado(operando2) ;
		operando2.almacenarEstadoAcelerador(1) ;
		assertEquals(operando3, operando4) ;
		assertEquals(operando4, operando3) ;
		assertFalse(operando3.equals(operando5)) ;
		assertFalse(operando5.equals(operando3)) ;
	}
	
	public void testTransitivo(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorEstado operando2 = new ObservadorEstado(operando1) ;
		ObservadorEstado operando3 = new ObservadorEstado(operando1) ;
		ObservadorEstado operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
	
	public void testManejarEvento(){
		Almacenador operando1 = new Almacenador() ;
		ObservadorEstado operando2 = new ObservadorEstado(operando1) ;
		operando1.almacenarEstadoPalanca(PalancaEstado.ENCENDIDO) ;
		operando1.almacenarRevolucionesEje(100) ;
		operando1.almacenarEstadoAcelerador(1) ;
		operando1.almacenarEstadoFreno(1) ;
		assertEquals(PalancaEstado.ENCENDIDO, operando2.getEstadoPalanca()) ;
		assertEquals(100, operando2.getNumRevoluciones()) ;
		assertEquals(1, operando2.getEstadoAcelerador()) ;
		assertEquals(1, operando2.getEstadoFreno()) ;
	}
}

