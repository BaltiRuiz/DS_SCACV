package Simulador;

import java.util.ArrayList;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

public class ObservadorTestListener implements TestListener, Observador {

	private ArrayList<Object> listaeventos = new ArrayList<Object>() ;
	
	public ArrayList<Object> getListaEventos(){
		return listaeventos ;
	}
	
	public void actualizar() {
		listaeventos.add("Actualizar") ;
	}
	
	public void startTest(Test arg0) {
		listaeventos.add("Start") ;
	}

	public void addError(Test arg0, Throwable arg1) {
		listaeventos.add("Error") ;
	}

	public void addFailure(Test arg0, AssertionFailedError arg1) {
		listaeventos.add("Failure") ;
	}

	public void endTest(Test arg0) {
		listaeventos.add("End") ;
	}
}


