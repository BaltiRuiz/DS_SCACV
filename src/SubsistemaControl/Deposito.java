package SubsistemaControl;

// Clase que representa el depósito del coche. Consta de dos atributos: el nivel actual del 
// depósito, y el máximo nivel o tope que puede alcanzar y con el cual se inicializa esta parte
// del vehículo.

public class Deposito {
	private int nivel ;
	private final int TOPE = 4000000 ;
	
	// Constructor de la clase
	
	public Deposito(){
		nivel = TOPE ;
	}
	
	// Devuelve el nivel actual del depósito
	
	public int getNivelDeposito(){
		return nivel ;
	}
	
	// Devuelve el valor máximo del nivel del depósito o tope
	
	public int getTope(){
		return TOPE ;
	}
	
	// Rellena al máximo el depósito
	
	public void rellenarDeposito(){
		nivel = TOPE ;
	}
	
	// Vacía una determinada cantidad el nivel del depósito. Usualmente será la velocidad actual del
	// vehículo, simulando de esta manera una mayor pérdida de depósito a mayor velocidad
	
	public void vaciarDeposito(int cantidad){
		nivel -= cantidad ;
		if (nivel < 0)
			nivel = 0 ;
	}
	
	// Compara el objeto actual con otro de su misma clase. Devuelve true cuando ambos objetos presentan
	// los mismos valores en los dos atributos existentes en esta clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof Deposito){
			Deposito deposito = (Deposito) objeto ;
			return (deposito.getNivelDeposito() == getNivelDeposito() && deposito.getTope() == getTope()) ; 
		}
		return false ;
	}
}
