package SubsistemaControl;

// Clase que representa el dispositivo de aceleración del vehículo. Presenta un único atributo,
// indicando el estado de dicho dispositivo: 0 (acelerador no pisado) ó 1 (acelerador pisado).

public class DispositivoAcelerador {
	private int estado ;
	
	// Constructor de la clase
	
	public DispositivoAcelerador(){
		estado = 0 ;
	}
	
	// Devuelve el estado del acelerador
	
	public int getEstadoAcelerador(){
		return estado ;
	}
	
	// Pone el estado del acelerador a 1 para indicar que está siendo pisado
	
	public void pisarAcelerador(){
		estado = 1 ;
	}
	
	// Pone el estado del acelerador a 0 para indicar que ha sido soltado
	
	public void soltarAcelerador(){
		estado = 0 ;
	}
	
	// Compara este objeto con otro de su misma clase. Devuelve true cuando ambos objetos tienen
	// el mismo valor en el entero que indica el estado de la clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof DispositivoAcelerador){
			DispositivoAcelerador acelerador = (DispositivoAcelerador) objeto ;
			return (acelerador.getEstadoAcelerador() == getEstadoAcelerador()) ;
		}
		
		return false ;
	}
}
