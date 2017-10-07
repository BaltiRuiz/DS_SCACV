package ControlVelocidad;

public class Acelerador implements Pedal {
	
	private boolean _estado ;
	private final int aceleracion = 300 ;
	private double velocidadanterior ;			// AÑADIDO
	public static final int ROZAMIENTO = 100 ;
	
	public Acelerador() {
		_estado = false ;
	}
	
	// AÑADIDO
	
	public int getAceleracion(){
		return aceleracion ;
	}
	
	// AÑADIDO
	
	public double getVelAnterior(){
		return velocidadanterior ;
	}
	
	// AÑADIDO
	
	public int getRozamiento(){
		return ROZAMIENTO ;
	}
	
	public void incrementar(int aceleracion, Eje eje) {	
		eje.incrementarVueltas(aceleracion) ;
	}
	
	// AÑADIDO
	
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
	
	// AÑADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof Acelerador){
			Acelerador acelerador = (Acelerador) objeto ;
			return (acelerador.getAceleracion() == getAceleracion() && acelerador.leerEstado() == leerEstado() &&
					acelerador.getRozamiento() == getRozamiento() && acelerador.getVelAnterior() == getVelAnterior()) ;
		}
		
		return false ;
	}
}