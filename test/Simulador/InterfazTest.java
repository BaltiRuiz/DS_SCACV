package Simulador;

import ControlVelocidad.ControlVelocidad;
import Monitorizacion.Monitorizacion;
import junit.framework.TestCase;

public class InterfazTest extends TestCase {
	
	private Interfaz lainterfaz ;
	
	public void setUp(){
		lainterfaz = new Interfaz() ;
	}
	
	public void testInterfaz(){
		assertNotNull(lainterfaz.getSimulacion()) ;
		assertTrue(lainterfaz.getSimulacion() instanceof Simulacion) ;
		assertNotNull(lainterfaz.getMonitor()) ;
		assertTrue(lainterfaz.getMonitor() instanceof Monitorizacion) ;
		assertNotNull(lainterfaz.getControl()) ;
		assertTrue(lainterfaz.getControl() instanceof ControlVelocidad) ;
		assertNotNull(lainterfaz.getPanelBotones()) ;
		assertTrue(lainterfaz.getPanelBotones() instanceof PanelBotones) ;
		assertNotNull(lainterfaz.getPanelEtiquetas()) ;
		assertTrue(lainterfaz.getPanelEtiquetas() instanceof PanelEtiquetas) ;
	}
}
