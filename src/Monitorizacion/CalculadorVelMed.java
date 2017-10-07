package Monitorizacion;

import ControlVelocidad.Eje;

public class CalculadorVelMed {
	
	private double _velMedia ;
	private long sumatoria_vel ;
	private double sumatoria_gas ;
	private double _gastoMedio ;
	private double _gastoValorAnterior ;
	private int _tiempo_gas, tiempo_vel ;
	
	protected CalculadorVelMed() {
		_velMedia = 0 ;
		sumatoria_vel = 0 ;
		sumatoria_gas = 0.0 ;
		_tiempo_gas = tiempo_vel = 1 ;
		_gastoValorAnterior = 100.0 ;
	}
	
	// A�ADIDO
	
	public double getVelMedia(){
		return _velMedia ;
	}
	
	// A�ADIDO
	
	public long getSumatoriaVel(){
		return sumatoria_vel ;
	}
	
	// A�ADIDO
	
	public void setSumatoriaVel(long lasumatoriavel){
		sumatoria_vel = lasumatoriavel ;
	}
	
	// A�ADIDO
	
	public double getSumatoriaGas(){
		return sumatoria_gas ;
	}
	
	// A�ADIDO
	
	public void setSumatoriaGas(long lasumatoriagas){
		sumatoria_gas = lasumatoriagas ;
	}
	
	// A�ADIDO
	
	public double getGastoMedio(){
		return _gastoMedio ;
	}
	
	// A�ADIDO
	
	public double getGastoValorAnterior(){
		return _gastoValorAnterior ;
	}
	
	// A�ADIDO
	
	public void setGastoValorAnterior(double elgastovaloranterior){
		_gastoValorAnterior = elgastovaloranterior ;
	}
	
	// A�ADIDO
	
	public int getTiempoGas(){
		return _tiempo_gas ;
	}
	
	// A�ADIDO
	
	public int getTiempoVel(){
		return tiempo_vel ;
	}
	
	protected void calcularVelocidadMedia(Eje aEje_e) {
		if(aEje_e.getVelAnterior() != 0){
			if(sumatoria_vel < 1000000000){
				sumatoria_vel += aEje_e.getVelAnterior() ;
				_velMedia = sumatoria_vel /tiempo_vel ;
				tiempo_vel++ ;
			}
			else{
				resetearTiempo() ;
			}
		}
	}
	
	protected void resetearTiempo() {
		sumatoria_gas = sumatoria_vel = 0 ;
		_tiempo_gas = tiempo_vel = 1 ;
	}
	
	protected double leerVelMedia() {
		return _velMedia ;
	}
	
	public void calcularGastoMedio(Eje aEje_e, Deposito depo) {
		if(aEje_e.getVelAnterior() != 0){
			if(sumatoria_gas < 1000000000){
				if(_gastoValorAnterior - depo.leerNivelActual() > 0){
					sumatoria_gas += _gastoValorAnterior - depo.leerNivelActual() ;
				}
				_gastoValorAnterior = depo.leerNivelActual() ;
				_gastoMedio = (sumatoria_gas*100) / _tiempo_gas ;
				_tiempo_gas++ ;
			}
			else{
				resetearTiempo() ;
			}
		}
	}
	
	public double leerGastoMedio() {
		return _gastoMedio ;
	}
	
	// A�ADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof CalculadorVelMed){
			CalculadorVelMed calculador = (CalculadorVelMed) objeto ;
			return (calculador.getGastoMedio() == getGastoMedio() && calculador.getGastoValorAnterior() == getGastoValorAnterior() &&
					calculador.getSumatoriaGas() == getSumatoriaGas() && calculador.getSumatoriaVel() == getSumatoriaVel() &&
					calculador.getTiempoGas() == getTiempoGas() && calculador.getTiempoVel() == getTiempoVel() && calculador.getVelMedia() == getVelMedia()) ;
		}
		return false ;
	}
}