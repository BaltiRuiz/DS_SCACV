package ControlVelocidad;

public final class Eje {
	
	public final double RADIO = 0.8 ;
	private int vueltas ;
	private long vueltasTotales ;
	private CalculadorVel calculadorVel ;
	public final int MAXVUELTAS = 10000 ;
	private int velAnterior ;				// VISIBILIDAD MODIFICADA AL A�ADIR YA UN M�TODO GET PARA DICHO ATRIBUTO
	
	public Eje() {
		calculadorVel = new CalculadorVel() ;
		vueltas = 0 ;
		vueltasTotales = 0 ;
	}
	
	// A�ADIDO
	
	public double getRadio(){
		return RADIO ;
	}
	
	// A�ADIDO
	
	public int getMaxVueltas(){
		return MAXVUELTAS ;
	}
	
	// A�ADIDO
	
	public int getVelAnterior(){
		return velAnterior ;
	}
	
	// A�ADIDO
	
	public void setVueltas(int lasvueltas){
		vueltas = lasvueltas ;
	}
	
	// A�ADIDO
	
	public void setVelAnterior(int velanterior){
		velAnterior = velanterior ;
	}
	
	// A�ADIDO
	
	public void setVueltasTotales(int vueltas){
		vueltasTotales = vueltas ;
	}
	
	synchronized public void incrementarVueltas(int aumento) {
		if(vueltas<=MAXVUELTAS || aumento<0){
			vueltas += aumento;
			if(vueltas < 0){
				vueltas = 0 ;
			}
		}
	}
	
	synchronized public void resetear() {
		vueltasTotales = 0 ;
	}

	synchronized public int leerRevoluciones() {
		return vueltas ;
	}
	
	synchronized public long leerRevolucionesTotales() {
		return vueltasTotales ;
	}
	
	synchronized public void calcularVelocidad(Almacenamiento almacena){
		velAnterior = calculadorVel.calcularVelocidad(vueltas, RADIO, almacena) ;
		vueltasTotales += vueltas/24 ;
	}
	
	// A�ADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof Eje){
			Eje eje = (Eje) objeto ;
			return (eje.getMaxVueltas() == getMaxVueltas() && eje.getRadio() == getRadio() && eje.getVelAnterior() == getVelAnterior()
					&& eje.leerRevoluciones() == leerRevoluciones() && eje.leerRevolucionesTotales() == leerRevolucionesTotales()) ;
		}
		
		return false ;
	}
}