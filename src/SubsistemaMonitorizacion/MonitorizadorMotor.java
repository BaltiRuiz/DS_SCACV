package SubsistemaMonitorizacion;

// Clase encargada de monitorizar el motor del vehículo, calculando la velocidad media en cada
// momento.

public class MonitorizadorMotor {
	private int revolucionestotales ;
	private int tiempo ;
	private double radio ;
	
	// Constructor de la clase. Recibe como argumento el radio del eje, necesario para realizar
	// los cálculos
	
	public MonitorizadorMotor(double elradio){
		revolucionestotales = 0 ;
		tiempo = 0 ;
		radio = elradio ;
	}
	
	// Devuelve el número total de revoluciones del eje
	
	public int getRevolucionesTotales(){
		return revolucionestotales ;
	}
	
	// Devuelve el instante de tiempo actual (en milisegundos)
	
	public int getTiempo(){
		return tiempo ;
	}
	
	// Devuelve el radio del eje
	
	public double getRadio(){
		return radio ;
	}
	
	// Actualiza los diferentes atributos de la clase teniendo en cuenta el número de revoluciones
	// dadas por el eje hasta el instante de tiempo actual
	
	public void actualizarValores(int lasrevoluciones, int eltiempo){
		revolucionestotales = lasrevoluciones ;
		tiempo = eltiempo ;
	}
	
	// Usando el número total de revoluciones dadas en un total de tiempo dado, puede calcular la
	// velocidad media del vehículo 
	
	public double calcularVelocidadPromedio(){
		double resultado ;
		
		if (tiempo == 0)
			resultado = 0 ;	
		else{
			double distancia = revolucionestotales * 2 * Math.PI * radio ;
			resultado = distancia / (double) tiempo ;
		}
		
		return resultado ;
	}
	
	// Pone a 0 el contador total de revoluciones para reiniciar las cuentas sin problemas
	
	public void reiniciarValores(){
		revolucionestotales = 0 ;
	}
	
	// Compara el objeto actual con otro de la misma clase. Devuelve true cuando los tres campos que
	// representan a la clase son exactamente iguales
	
	public boolean equals(Object objeto){
		if (objeto instanceof MonitorizadorMotor){
			MonitorizadorMotor monitorizadormotor = (MonitorizadorMotor) objeto ;
			return (monitorizadormotor.getRevolucionesTotales() == getRevolucionesTotales()
					&& monitorizadormotor.getTiempo() == getTiempo() && monitorizadormotor.getRadio() == getRadio()) ;
		}
		
		return false ;
	}
}
