package SubsistemaControl;

// Clase que representa el freno del vehículo. Consta de un único estado, indicando si el freno está siendo
// pisado (1) o no (0)

public class DispositivoFreno {
	private int estado ;
	
	// Constructor de la clase
	
	public DispositivoFreno(){
		estado = 0 ;
	}
	
	// Devuelve el estado actual del freno
	
	public int getEstadoFreno(){
		return estado ;
	}
	
	// Pone el estado del freno a 1 para indicar que está siendo pisado
	
	public void pisarFreno(){
		estado = 1 ;
	}
	
	// Pone el estado del freno a 0 para indicar que ha sido soltado
	
	public void soltarFreno(){
		estado = 0 ;
	}
	
	// Compara el objeto actual con otro de su misma clase. Devuelve true cuando ambos presentan
	// el mismo valor entero en el único campo que caracteriza esta clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof DispositivoFreno){
			DispositivoFreno freno = (DispositivoFreno) objeto ;
			return (freno.getEstadoFreno() == getEstadoFreno()) ;
		}
		
		return false ;
	}
}
