package Monitorizacion;

import junit.framework.Test;
import junit.framework.TestSuite;

public class MonitorizacionTestSuite {

	public static Test suite(){
		TestSuite suite = new TestSuite(MonitorizacionTestSuite.class.getName()) ;
		
		suite.addTestSuite(CalculadorVelMedTest.class) ;
		suite.addTestSuite(DepositoTest.class) ;
		suite.addTestSuite(NotificacionesTest.class) ;
		suite.addTestSuite(ReseteoTest.class) ;
		suite.addTestSuite(MonitorizacionTest.class) ;
		
		return suite ;
	}
}
