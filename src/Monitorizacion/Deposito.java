package Monitorizacion;

import ControlVelocidad.Eje;

public final class Deposito {
	
	private double _nivelActual ;
	private final double NIVEL_INICIAL = 100 ;
	private final double RATIO_CONSUMO = 0.0000000005 ;
	
	protected Deposito() {
		_nivelActual = NIVEL_INICIAL ;
	}
	
	// MODIFICADA VISIBILIDAD
	
	public double leerNivelActual() {
		return _nivelActual ;
	}
	
	// AÑADIDO
	
	public void setNivelActual(double elnivel){
		_nivelActual = elnivel ;
	}
	
	// MODIFICADA VISIBILIDAD
	
	public double leerNivelInicial() {
		return NIVEL_INICIAL ;
	}
	
	// AÑADIDO
	
	public double getRatioConsumo() {
		return RATIO_CONSUMO ;
	}
	
	protected void actualizarDeposito(Eje Eje_e) {
		int rev = Eje_e.leerRevoluciones() ;
		_nivelActual -= (rev*(rev/15))*RATIO_CONSUMO ;
		if(_nivelActual <= 0){
			_nivelActual = 0 ;
		}
	}
	
	protected void cambiarANivelInicial() {
		_nivelActual = NIVEL_INICIAL ;
	}
	
	// AÑADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof Deposito){
			Deposito deposito = (Deposito) objeto ;
			return (deposito.leerNivelActual() == leerNivelActual() && deposito.leerNivelInicial() == leerNivelInicial()
					&& deposito.getRatioConsumo() == getRatioConsumo()) ;
		}
		
		return false ;
	}
}