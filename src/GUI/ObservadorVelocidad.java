package GUI;

import SubsistemaControl.Almacenador;

// Clase observadora de los valores de velocidad del vehículo: velocidad actual, velocidad media,
// y velocidad automática a mantener.

public class ObservadorVelocidad implements Observador{
	private Almacenador almacenador ;
	private double velocidadactual ;
	private double velocidadautomatica ;
	private double velocidadmedia ;
	
	// Constructor de la clase. Recibe como argumento la clase almacenadora observable
	
	public ObservadorVelocidad(Almacenador elalmacenador){
		almacenador = elalmacenador ;
		almacenador.incluirObservador(this) ;
		velocidadactual = almacenador.getVelocidad() ;
		velocidadautomatica = almacenador.getVelocidadAutomatica() ;
		velocidadmedia = almacenador.getVelocidadMedia() ;
	}
	
	// Devuelve el almacenador observado
	
	public Almacenador getAlmacenador(){
		return almacenador ;
	}
	
	// Devuelve la velocidad actual del vehículo
	
	public double getVelocidadActual(){
		return velocidadactual ;
	}
	
	// Devuelve la velocidad automática a mantener por el sistema de control
	
	public double getVelocidadAutomatica(){
		return velocidadautomatica ;
	}
	
	// Devuelve la velocidad media del vehículo
	
	public double getVelocidadMedia(){
		return velocidadmedia ;
	}
	
	// Actualiza los 3 valores de velocidad observados cuando el observable se lo indica
	
	public void manejarEvento(){
		velocidadactual = almacenador.getVelocidad() ;
		velocidadautomatica = almacenador.getVelocidadAutomatica() ;
		velocidadmedia = almacenador.getVelocidadMedia() ;
	}
	
	// Compara este objeto con otro de la misma clase. Devuelve true cuando ambos observan almacenadores
	// equivalentes y coinciden en el valor de los campos observados
	
	public boolean equals(Object objeto){
		if (objeto instanceof ObservadorVelocidad){
			ObservadorVelocidad observadorvelocidad = (ObservadorVelocidad) objeto ;
			return (observadorvelocidad.getAlmacenador().equals(getAlmacenador()) 
					&& observadorvelocidad.getVelocidadActual() == getVelocidadActual() 
					&& observadorvelocidad.getVelocidadAutomatica() == getVelocidadAutomatica()
					&& observadorvelocidad.getVelocidadMedia() == getVelocidadMedia()) ;
		}
		
		return false ;
	}
}
