package ControlVelocidad;

public class Motor {
	
	private boolean _estado ;
	
	public Motor() {
		_estado = false ;
	}
	
	public boolean leerEstado() {
		return _estado ;
	}
	
	public void cambiarEstado() {
		if(_estado == false){
			_estado = true ;
		}
		else{
			_estado = false ;
		}
	}
	
	// AÑADIDO
	
	public boolean equals(Object objeto){
		if (objeto instanceof Motor){
			Motor motor = (Motor) objeto ;
			return (motor.leerEstado() == leerEstado()) ;
		}
		
		return false ;
	}
}