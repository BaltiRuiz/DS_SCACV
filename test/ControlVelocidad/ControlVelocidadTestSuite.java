package ControlVelocidad;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ControlVelocidadTestSuite {

	public static Test suite(){
		TestSuite suite = new TestSuite(ControlVelocidadTestSuite.class.getName()) ;
		
		suite.addTestSuite(AutomaticoTest.class) ;
		suite.addTestSuite(CalculadorVelTest.class) ;
		suite.addTestSuite(EjeTest.class) ;
		suite.addTestSuite(MotorTest.class) ;
		suite.addTestSuite(PalancaTest.class) ;
		suite.addTestSuite(PedalTest.class) ;
		suite.addTestSuite(ControlVelocidadTest.class) ;
		
		return suite ;
	}
}
