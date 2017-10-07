package Simulador;

import junit.framework.TestCase;

public class ObservableTest extends TestCase {
	
	private Observable observable ;
	private ObservadorNulo observador ;
	
	public void setUp(){
		observable = new ListaObservadoresObservables() ;
		observador = new ObservadorNulo() ;
	}
	
	public void testNotificarObservador(){
		assertEquals(0, observador.getValorActualizar()) ;
		testAniadirObservador() ;
		assertEquals(0, observador.getValorActualizar()) ;
		observable.notificarObservador() ;
		assertEquals(1, observador.getValorActualizar()) ;
	}
	
	public void testAniadirObservador(){
		observable.agregarObservador(observador) ;
		assertEquals((((ListaObservadoresObservables) observable).coleccionObservadores()).size(), 1) ;
		assertTrue((((ListaObservadoresObservables) observable).coleccionObservadores()).contains(observador)) ;
	}
	
	public void testEliminarObservador(){
		testAniadirObservador() ;
		observable.eliminarObservador(observador) ;
		assertEquals((((ListaObservadoresObservables) observable).coleccionObservadores()).size(), 0) ;
	}
}
