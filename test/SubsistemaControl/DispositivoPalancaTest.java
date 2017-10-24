package SubsistemaControl;

import junit.framework.TestCase;

public class DispositivoPalancaTest extends TestCase{	
	public void testReflexivo(){
		Controlador operando1 = Controlador.getInstance() ;
		DispositivoPalanca operando2 = new DispositivoPalanca(operando1) ;
		assertEquals(operando2, operando2) ;
	}
	
	public void testSimetrico(){
		Controlador operando1 = Controlador.getInstance() ;
		DispositivoPalanca operando2 = new DispositivoPalanca(operando1) ;
		DispositivoPalanca operando3 = new DispositivoPalanca(operando1) ;
		DispositivoPalanca operando4 = new DispositivoPalanca(operando1) ;
		operando4.moverPalanca(PalancaEstado.ENCENDIDO) ;
		assertEquals(operando2, operando3) ;
		assertEquals(operando3, operando2) ;
		assertFalse(operando2.equals(operando4)) ;
		assertFalse(operando4.equals(operando2)) ;
	}
	
	public void testTransitivo(){
		Controlador operando1 = Controlador.getInstance() ;
		DispositivoPalanca operando2 = new DispositivoPalanca(operando1) ;
		DispositivoPalanca operando3 = new DispositivoPalanca(operando1) ;
		DispositivoPalanca operando4 = operando3 ;
		assertEquals(operando4, operando3) ;
		assertEquals(operando2, operando4) ;
	}
	
	public void testMoverPalanca(){
		Controlador operando1 = Controlador.getInstance() ;
		DispositivoPalanca operando2 = new DispositivoPalanca(operando1) ;
		
		operando2.moverPalanca(PalancaEstado.ENCENDIDO) ;
		assertEquals(PalancaEstado.ENCENDIDO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.APAGADO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.APAGADO) ;
		
		operando2.moverPalanca(PalancaEstado.ACELERANDO) ;
		assertEquals(PalancaEstado.ACELERANDO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.REINICIANDO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.REINICIANDO) ;
		
		operando2.moverPalanca(PalancaEstado.AUTOMATICO) ;
		assertEquals(PalancaEstado.AUTOMATICO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.ENCENDIDO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.ENCENDIDO) ;
		
		operando2.moverPalanca(PalancaEstado.APAGADO) ;
		assertEquals(PalancaEstado.APAGADO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.AUTOMATICO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.AUTOMATICO) ;
		
		operando2.moverPalanca(PalancaEstado.REINICIANDO) ;
		assertEquals(PalancaEstado.REINICIANDO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.APAGADO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.APAGADO) ;
		
		operando2.moverPalanca(PalancaEstado.FRENANDO) ;
		assertEquals(PalancaEstado.FRENANDO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.MOTORAPAGADO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.MOTORAPAGADO) ;
		
		operando2.moverPalanca(PalancaEstado.ENCENDIDO) ;
		assertEquals(PalancaEstado.ENCENDIDO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.FRENANDO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.FRENANDO) ;
		
		operando2.moverPalanca(PalancaEstado.MOTORAPAGADO) ;
		assertEquals(PalancaEstado.MOTORAPAGADO, operando2.getEstadoPalanca()) ;
		operando2.moverPalanca(PalancaEstado.ACELERANDO) ;
		assertTrue(operando2.getEstadoPalanca() != PalancaEstado.ACELERANDO) ;
	}
}
