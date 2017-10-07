package ControlVelocidad;

public class Acelerador implements Pedal {
	
	private boolean _estado ;
	private final int aceleracion = 300 ;
	private double velocidadanterior ;			// A�ADIDO
	public static final int ROZAMIENTO = 100 ;
	
	public Acelerador() {
		_estado = false ;
	}
	
	// A�ADIDO
	
	public int getAceleracion(){
		return aceleracion ;
	}
	
	// A�ADIDO
	
	public double getVelAnterior(){
		return velocidadanterior ;
	}
	
	// A�ADIDO
	
	public int getRozamiento(){
		return ROZAMIENTO ;
	}
	
	public void incrementar(int aceleracion, Eje eje) {	
		eje.incrementarVueltas(aceleracion) ;
	}
	
	// A�ADIDO
	
	public void guardarVelocidadAnterior(double velAnterior){
		velocidadanterior = velAnterior ;
	}
	
	// MODIFICADO
	
	public double actualizar() {
		return (aceleracion - (ROZAMIENTO*0.015*velocidadanterior)) ;
	}
	
	public void soltar() {
		_estado = false ;
	}
	
	public boolean leerEstado() {
		return _estado ;
	}
	
	public void pisar() {
		_estado = true ;
	}
	
	// A�ADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof Acelerador){
			Acelerador acelerador = (Acelerador) objeto ;
			return (acelerador.getAceleracion() == getAceleracion() && acelerador.leerEstado() == leerEstado() &&
					acelerador.getRozamiento() == getRozamiento() && acelerador.getVelAnterior() == getVelAnterior()) ;
		}
		
		return false ;
	}
}