package SubsistemaControl;

import GUI.Observable;

// Clase que guardará los datos principales del subsistema de control y que servirá de
// enlace con el subsistema de monitorización.

public class Almacenador extends Observable{
	private PalancaEstado estadopalanca ;
	private double velocidad ;
	private double velocidadautomatica ;
	private double velocidadmedia ;
	private int niveldeposito ;
	private double gastocombustiblemedio ;
	private int revolucioneseje ;
	private double radioeje ;
	private int estadoacelerador ;
	private int estadofreno ;
	private int tiempo ;
	
	// Constructor de la clase
	
	public Almacenador(){
		estadopalanca = PalancaEstado.MOTORAPAGADO ;
		velocidad = 0 ;
		velocidadautomatica = 0 ;
		velocidadmedia = 0 ;
		niveldeposito = 0 ;
		gastocombustiblemedio = 0 ;
		revolucioneseje = 0 ;
		radioeje = 0 ;
		estadoacelerador = 0 ;
		estadofreno = 0 ;
		tiempo = 0 ;
	}
	
	// Almacena el nuevo estado de la palanca indicado como argumento
	
	public void almacenarEstadoPalanca(PalancaEstado elestado){
		estadopalanca = elestado ;
		notificarObservador() ;
	}
	
	// Almacena la velocidad actual del vehículo indicada como argumento
	
	public void almacenarVelocidad(double lavelocidad){
		velocidad = lavelocidad ;
		notificarObservador() ;
	}
	
	// Almacena la velocidad a mantener por el vehículo y a la cual se regresará en el estado de 
	// reinicio, indicada como argumento
	
	public void almacenarVelocidadAutomatica(double lavelocidad){
		velocidadautomatica = lavelocidad ;
		notificarObservador() ;
	}
	
	// Almacena la velocidad media del vehículo indicada como argumento
	
	public void almacenarVelocidadMedia(double lavelocidad){
		velocidadmedia = lavelocidad ;
		notificarObservador() ;
	}
	
	// Almacena el nivel del depósito actual indicado como argumento
	
	public void almacenarNivelDeposito(int elnivel){
		niveldeposito = elnivel ;
		notificarObservador() ;
	}
	
	// Almacena el gasto medio del depósito indicado como argumento
	
	public void almacenarGastoCombustibleMedio(double elgasto){
		gastocombustiblemedio = elgasto ;
		notificarObservador() ;
	}
	
	// Almacena las revoluciones acumuladas por el eje indicadas como argumento
	
	public void almacenarRevolucionesEje(int lasrevoluciones){
		revolucioneseje = lasrevoluciones ;
		notificarObservador() ;
	}
	
	// Almacena el radio del eje indicado como argumento
	
	public void almacenarRadioEje(double elradio){
		radioeje = elradio ;
	}
	
	// Almacena el estado del dispositivo de aceleración indicado como argumento
	
	public void almacenarEstadoAcelerador(int elestado){
		estadoacelerador = elestado ;
		notificarObservador() ;
	}
	
	// Almacena el estado del dispositivo de freno indicado como argumento
	
	public void almacenarEstadoFreno(int elestado){
		estadofreno = elestado ;
		notificarObservador() ;
	}
	
	// Almacena el instante actual en milisegundos indicado como argumento
	
	public void almacenarTiempo(int eltiempo){
		tiempo = eltiempo ;
		notificarObservador() ;
	}
	
	// Devuelve el estado de la palanca almacenado
	
	public PalancaEstado getEstadoPalanca(){
		return estadopalanca ;
	}
	
	// Devuelve la velocidad actual almacenada
	
	public double getVelocidad(){
		return velocidad ;
	}
	
	// Devuelve la velocidad a mantener almacenada
	
	public double getVelocidadAutomatica(){
		return velocidadautomatica ;
	}
	
	// Devuelve la velocidad media almacenada
	
	public double getVelocidadMedia(){
		return velocidadmedia ;
	}
	
	// Devuelve el nivel del depósito almacenado
	
	public int getNivelDeposito(){
		return niveldeposito ;
	}
	
	// Devuelve el gasto medio de combustible almacenado
	
	public double getGastoCombustibleMedio(){
		return gastocombustiblemedio ;
	}
	
	// Devuelve el número total de revoluciones del eje almacenado
	
	public int getRevolucionesEje(){
		return revolucioneseje ;
	}
	
	// Devuelve el radio del eje almacenado
	
	public double getRadioEje(){
		return radioeje ;
	}
	
	// Devuelve el estado del acelerador almacenado
	
	public int getEstadoAcelerador(){
		return estadoacelerador ;
	}
	
	// Devuelve el estado del freno almacenado
	
	public int getEstadoFreno(){
		return estadofreno ;
	}
	
	// Devuelve el instante actual en milisegundos almacenado
	
	public int getTiempo(){
		return tiempo ;
	}
	
	// Compara el objeto actual con otro de su misma clase. Devuelve true si todos los valores
	// almacenados son exactamente los mismos
	
	public boolean equals(Object objeto){
		if (objeto instanceof Almacenador){
			Almacenador almacenador = (Almacenador) objeto ;
			return (almacenador.getEstadoPalanca() == getEstadoPalanca() && almacenador.getVelocidad() == getVelocidad()
					&& almacenador.getVelocidadAutomatica() == getVelocidadAutomatica() && almacenador.getVelocidadMedia() == getVelocidadMedia()
					&& almacenador.getNivelDeposito() == getNivelDeposito() && almacenador.getGastoCombustibleMedio() == getGastoCombustibleMedio()
					&& almacenador.getRevolucionesEje() == getRevolucionesEje() && almacenador.getRadioEje() == getRadioEje()
					&& almacenador.getEstadoAcelerador() == getEstadoAcelerador() && almacenador.getEstadoFreno() == getEstadoFreno() 
					&& almacenador.getTiempo() == getTiempo()) ;
		}
		
		return false ;
	}
}
