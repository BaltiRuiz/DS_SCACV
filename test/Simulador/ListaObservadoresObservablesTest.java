package Simulador;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;

public class ListaObservadoresObservablesTest extends TestCase {
	
	private Observable observable ;
	private Interfaz interfaz ;
	private PanelBotones panelbotones ;
	private PanelEtiquetas paneletiquetas ;
	
	private TestResult testresult = new TestResult() ;
	private ObservadorTestListener observadortestlistener = new ObservadorTestListener() ;
	
	public void setUp(){
		Test test = (Test) this ;
		
		observable = new ListaObservadoresObservables() ;
		interfaz = new Interfaz() ;
		panelbotones = new PanelBotones(interfaz) ;
		panelbotones.aniadirComponentes(interfaz.getMonitor(), interfaz.getControl()) ;
		paneletiquetas = new PanelEtiquetas(interfaz) ;
		paneletiquetas.aniadirComponentes(interfaz.getMonitor(), interfaz.getControl()) ;
		
		testresult.addListener(observadortestlistener) ;
		testresult.startTest(test) ;
	}
	
	public void testNotificarObservador(){
		testAniadirObservador() ;
		observable.notificarObservador() ;
		assertEquals("Start", observadortestlistener.getListaEventos().get(0)) ;
		assertEquals("Actualizar", observadortestlistener.getListaEventos().get(1)) ;
	}
	
	public void testAniadirObservador(){
		observable.agregarObservador(panelbotones) ;
		observable.agregarObservador(paneletiquetas) ;
		observable.agregarObservador(observadortestlistener) ;
		assertEquals((((ListaObservadoresObservables) observable).coleccionObservadores()).size(), 3) ;
		assertTrue((((ListaObservadoresObservables) observable).coleccionObservadores()).contains(panelbotones)) ;
		assertTrue((((ListaObservadoresObservables) observable).coleccionObservadores()).contains(paneletiquetas)) ;
	}
	
	public void testEliminarObservador(){
		testAniadirObservador() ;
		observable.eliminarObservador(panelbotones) ;
		observable.eliminarObservador(paneletiquetas) ;
		observable.eliminarObservador(observadortestlistener) ;
		assertEquals((((ListaObservadoresObservables) observable).coleccionObservadores()).size(), 0) ;
	}
}

