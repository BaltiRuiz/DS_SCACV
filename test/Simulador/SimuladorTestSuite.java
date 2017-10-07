package Simulador;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SimuladorTestSuite {

	public static Test suite(){
		TestSuite suite = new TestSuite(SimuladorTestSuite.class.getName()) ;
		
		suite.addTestSuite(InterfazTest.class) ;
		suite.addTestSuite(ListaObservadoresObservablesTest.class) ;
		suite.addTestSuite(ObservableTest.class) ;
		suite.addTestSuite(PanelBotonesTest.class) ;
		
		return suite ;
	}
}
