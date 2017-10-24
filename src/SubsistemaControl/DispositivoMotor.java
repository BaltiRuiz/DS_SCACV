package SubsistemaControl;

// Clase que representa el motor del vehículo. Consta de un único estado, indicando si el motor está
// encendido (1) o apagado (0)

public class DispositivoMotor {
	private int estado ;
	
	// Constructor de la clase
	
	public DispositivoMotor(){
		estado = 0 ;
	}
	
	// Devuelve el estado actual del motor
	
	public int getEstadoMotor(){
		return estado ;
	}
	
	// Pone el estado del motor a 1 para indicar que ha sido encendido
	
	public void encenderMotor(){
		estado = 1 ;
	}
	
	// Pone el estado del motor a 0 para indicar que ha sido apagado
	
	public void apagarMotor(){
		estado = 0 ;
	}
	
	// Compara este objeto con otro de su misma clase. Devuelve true cuando ambos presentan el mismo
	// valor entero en el único campo que caracteriza a esta clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof DispositivoMotor){
			DispositivoMotor motor = (DispositivoMotor) objeto ;
			return (motor.getEstadoMotor() == getEstadoMotor()) ;
		}
		
		return false ;
	}
}
