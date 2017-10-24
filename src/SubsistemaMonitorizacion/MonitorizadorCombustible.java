package SubsistemaMonitorizacion;

// Clase encargada de monitorizar el combustible del vehículo, calculando en cada instante el gasto medio
// del depósito.

public class MonitorizadorCombustible {
	private int valoranterior ;
	private int gastototal ;
	private int tiempo ;
	
	// Constructor de la clase. Recibe como argumento el tope del depósito
	
	public MonitorizadorCombustible(int ellimitedeposito){
		valoranterior = ellimitedeposito ;
		gastototal = 0 ;
		tiempo = 0 ;
	}
	
	// Devuelve el nivel del depósito existente en el instante de tiempo anterior
	
	public int getValorAnterior(){
		return valoranterior ;
	}
	
	// Devuelve el gasto total de combustible del vehículo desde que se inicia la monitorización
	
	public int getGastoTotal(){
		return gastototal ;
	}
	
	// Devuelve el instante de tiempo actual
	
	public int getTiempo(){
		return tiempo ;
	}
	
	// Actualiza los diferentes atributos de la clase teniendo en cuenta el nivel actual del
	// depósito y el instante de tiempo actual
	
	public void actualizarValores(int elnivel, int eltiempo){
		int diferencia = valoranterior - elnivel ;
		if (diferencia >= 0)
			gastototal += diferencia ;
		tiempo = eltiempo ;
		valoranterior = elnivel ;
	}
	
	// Utilizando las variables de gasto total de combustible y el total de tiempo transcurrido,
	// calcula el gasto medio de combustible del vehículo
	
	public double calcularGastoCombustiblePromedio(){
		double resultado ;
		
		if (tiempo == 0)
			resultado = 0 ;
		else
			resultado = gastototal / (double) tiempo ;
		
		return resultado ;
	}
	
	// Coloca a 0 el contador total de combustible y pone el valor anterior del depósito al tope
	// del mismo para reiniciar las cuentas sin problemas 
	
	public void reiniciarValores(int elnivel){
		valoranterior = elnivel ;
		gastototal = 0 ;
	}
	
	// Compara el objeto actual con otro de la misma clase. Devuelve true cuando ambos objetos
	// presentan los mismos valores en los tres atributos que representan la clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof MonitorizadorCombustible){
			MonitorizadorCombustible monitorizadorcombustible = (MonitorizadorCombustible) objeto ;
			return (monitorizadorcombustible.getValorAnterior() == getValorAnterior() &&
					monitorizadorcombustible.getGastoTotal() == getGastoTotal() && monitorizadorcombustible.getTiempo() == getTiempo()) ;
		}
		
		return false ;
	}
}
