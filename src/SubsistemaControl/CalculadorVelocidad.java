package SubsistemaControl;

// Clase encargada de obtener la velocidad actual del vehículo. Para ello, calculará la diferencia
// entre el número de revoluciones actual y el número de revoluciones en el instante de reloj anterior
// para saber así cuántas vueltas ha dado el eje en el intervalo de tiempo marcado por el reloj y
// obtener la distancia recorrida, con la que seguidamente se obtendrá la velocidad.

public class CalculadorVelocidad {
	private int vueltasanteriores ;
	
	private int tiempo ;
	private DispositivoEje eje ;
	
	// Constructor de la clase. Se le pasa como argumentos el intervalo de tiempo que marca el reloj y
	// el eje del cual tomará la diferencia de revoluciones
	
	public CalculadorVelocidad(int elintervalo, DispositivoEje eleje){
		tiempo = elintervalo ;
		eje = eleje ;
		vueltasanteriores = 0 ;
	}
	
	// Devuelve el número total de vueltas dadas por el eje en el instante de tiempo anterior
	
	public int getVueltasAnteriores(){
		return vueltasanteriores ;
	}
	
	// Devuelve el intervalo de tiempo marcado por el reloj del subsistema de control
	
	public int getTiempo(){
		return tiempo ;
	}
	
	// Devuelve el dispositivo eje del cual toma los valores de revoluciones necesarios para
	// sus cálculos
	
	public DispositivoEje getEje(){
		return eje ;
	}
	
	// Calcula la velocidad actual del vehículo, siguiendo el proceso resumido en la introducción
	// de esta clase
	
	public double calcularVelocidad(){
		double distancia = (eje.getVueltasEje() - vueltasanteriores) 
				* 2 * Math.PI * eje.getRadioEje() ;
		
		double velocidad = distancia / (double) tiempo ;
		
		vueltasanteriores = eje.getVueltasEje() ;
		
		return velocidad ;
	}
	
	// Pone el contador de revoluciones en el instante de tiempo anterior a 0. Es usado por el método
	// 'apagarSistema' de la clase controladora
	
	public void reiniciarValores(){
		vueltasanteriores = 0 ;
	}
	
	// Compara el objeto actual con otro de su misma clase. Devuelve true si ambos presentan
	// exactamente los mismos valores y el mismo estado en sus atributos
	
	public boolean equals(Object objeto){
		if (objeto instanceof CalculadorVelocidad){
			CalculadorVelocidad calculador = (CalculadorVelocidad) objeto ;
			return (calculador.getVueltasAnteriores() == getVueltasAnteriores() 
					&& calculador.getTiempo() == getTiempo() && calculador.getEje().equals(getEje())) ;
		}
		
		return false ;
	}
}
