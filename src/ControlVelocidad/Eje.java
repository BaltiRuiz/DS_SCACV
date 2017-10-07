package ControlVelocidad;

public final class Eje {
	
	public final double RADIO = 0.8 ;
	private int vueltas ;
	private long vueltasTotales ;
	private CalculadorVel calculadorVel ;
	public final int MAXVUELTAS = 10000 ;
	private int velAnterior ;				// VISIBILIDAD MODIFICADA AL AÑADIR YA UN MÉTODO GET PARA DICHO ATRIBUTO
	
	public Eje() {
		calculadorVel = new CalculadorVel() ;
		vueltas = 0 ;
		vueltasTotales = 0 ;
	}
	
	// AÑADIDO
	
	public double getRadio(){
		return RADIO ;
	}
	
	// AÑADIDO
	
	public int getMaxVueltas(){
		return MAXVUELTAS ;
	}
	
	// AÑADIDO
	
	public int getVelAnterior(){
		return velAnterior ;
	}
	
	// AÑADIDO
	
	public void setVueltas(int lasvueltas){
		vueltas = lasvueltas ;
	}
	
	// AÑADIDO
	
	public void setVelAnterior(int velanterior){
		velAnterior = velanterior ;
	}
	
	// AÑADIDO
	
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
	
	// AÑADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof Eje){
			Eje eje = (Eje) objeto ;
			return (eje.getMaxVueltas() == getMaxVueltas() && eje.getRadio() == getRadio() && eje.getVelAnterior() == getVelAnterior()
					&& eje.leerRevoluciones() == leerRevoluciones() && eje.leerRevolucionesTotales() == leerRevolucionesTotales()) ;
		}
		
		return false ;
	}
}