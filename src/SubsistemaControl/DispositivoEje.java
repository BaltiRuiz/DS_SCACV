package SubsistemaControl;

// Clase que representa el eje del vehículo. Consta de un atributo indicando el número total de vueltas
// dadas por el eje, otro que indica el radio del mismo, y un último atributo indicando el incremento
// actual en el número de vueltas del eje en el momento actual.

public class DispositivoEje {
	private int vueltas ;
	private final double RADIO = 0.5 ;
	private int incremento ;
	
	// Constructor de la clase
	
	public DispositivoEje(){
		vueltas = 0 ;
		incremento = 0 ;
	}
	
	// Devuelve el número de revoluciones dadas hasta el momento por el eje
	
	public int getVueltasEje(){
		return vueltas ;
	}
	
	// Devuelve el radio del eje
	
	public double getRadioEje(){
		return RADIO ;
	}
	
	// Devuelve el incremento actual en el número de vueltas dadas por el eje
	
	public int getIncremento(){
		return incremento ;
	}
	
	// Aumenta el valor de la variable 'incremento', en función del modo indicado en el argumento:
	// 1 para indicar un aumento de velocidad (lineal) del vehículo y otro valor cualquiera (usualmente 0)
	// para indicar que el vehículo mantendrá la velocidad actual
	
	public void incrementarVueltas(int modo){
		if (modo == 1)
			incremento += 5 ;
		
		vueltas += incremento ;
	}
	
	// Decrementa el valor de la variable 'incremento', en función del modo indicado en el argumento:
	// 0 para indicar pérdida pequeña de velocidad (p. ej. por el rozamiento de la carretera) y otro valor
	// cualquiera (usualmente 1) para indicar pérdida alta de velocidad (p. ej. al pisar el freno)
	
	public void decrementarVueltas(int modo){
		if (modo == 0)
			incremento -= 1 ;
		else
			incremento -= 5 ;
		
		if (incremento < 0)
			incremento = 0 ;
		
		vueltas += incremento ;
	}
	
	// Pone a 0 el contador total de revoluciones y el incremento de las mismas devolviendo de esta
	// manera el dispositivo al estado inicial. Es llamado por el método 'apagarSistema' de la clase
	// controladora
	
	public void reiniciarVueltas(){
		vueltas = 0 ;
		incremento = 0 ;
	}
	
	// Compara el objeto actual con otro de su misma clase. Devuelve true cuando ambos presentan el mismo
	// valor en los tres campos que hacen de atributos de esta clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof DispositivoEje){
			DispositivoEje eje = (DispositivoEje) objeto ;
			return (eje.getVueltasEje() == getVueltasEje() 
					&& eje.getRadioEje() == getRadioEje() && eje.getIncremento() == getIncremento()) ;
		}
		
		return false ;
	}
}
