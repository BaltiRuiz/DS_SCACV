package ControlVelocidad;

public class Freno implements Pedal {
	
	private boolean _estado ;
	private final int desaceleracion = 700 ;
	public static final int ROZAMIENTO = 100 ;
	
	public Freno() {
		_estado = false ;
	}
	
	// AÑADIDO
	
	public int getDesaceleracion(){
		return desaceleracion ;
	}
	
	// AÑADIDO
	
	public int getRozamiento(){
		return ROZAMIENTO ;
	}
	
	public void decremento(int desaceleracion, Eje eje) {	
		eje.incrementarVueltas(-desaceleracion) ;
	}
	
	public double actualizar() {
		return desaceleracion + ROZAMIENTO ;
	}
	
	public void soltar() {
		_estado = false ;
	}
	
	public void pisar() {
		_estado = true ; 
	}
	
	public boolean leerEstado() {
		return _estado ;
	}
	
	// AÑADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof Freno){
			Freno freno = (Freno) objeto ;
			return (freno.getDesaceleracion() == getDesaceleracion() && freno.getRozamiento() == getRozamiento() 
					&& freno.leerEstado() == leerEstado()) ;
		}
		
		return false ;
	}
}