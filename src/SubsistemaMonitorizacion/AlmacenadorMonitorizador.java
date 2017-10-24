package SubsistemaMonitorizacion;

import GUI.Observable;

// Clase encargada de almacenar los principales datos generados en las clases del subsistema de
// monitorización.

public class AlmacenadorMonitorizador extends Observable{
	private int cambioaceite ;
	private int revolucionesaceite ;
	private int cambiopastillas ;
	private int revolucionespastillas ;
	private int revisiongeneral ;
	private int revolucionesgeneral ;
	
	// Constructor de la clase
	
	public AlmacenadorMonitorizador(){
		cambioaceite = 0 ;
		revolucionesaceite = 0 ;
		cambiopastillas = 0 ;
		revolucionespastillas = 0 ;
		revisiongeneral = 0 ;
		revolucionesgeneral = 0 ;
	}
	
	// Almacena el indicador de cambio de aceite pasado como argumento

	public void almacenarCambioAceite(int elcambio){
		cambioaceite = elcambio ;
		notificarObservador() ;
	}
	
	// Almacena el número de revoluciones al cambiar el aceite pasado como argumento
	
	public void almacenarRevolucionesAceite(int lasrevoluciones){
		revolucionesaceite = lasrevoluciones ;
		notificarObservador() ;
	}
	
	// Almacena el indicador de cambio de pastillas pasado como argumento
	
	public void almacenarCambioPastillas(int elcambio){
		cambiopastillas = elcambio ;
		notificarObservador() ;
	}
	
	// Almacena el número de revoluciones al cambiar las pastillas pasado como argumento
	
	public void almacenarRevolucionesPastillas(int lasrevoluciones){
		revolucionespastillas = lasrevoluciones ;
		notificarObservador() ;
	}
	
	// Almacena el indicador de revisión general pasado como argumento
	
	public void almacenarRevisionGeneral(int larevision){
		revisiongeneral = larevision ;
		notificarObservador() ;
	}
	
	// Almacena el número de revoluciones al hacer la revisión general pasado como argumento
	
	public void almacenarRevolucionesGeneral(int lasrevoluciones){
		revolucionesgeneral = lasrevoluciones ;
		notificarObservador() ;
	}
	
	// Devuelve el indicador de cambio de aceite
	
	public int getCambioAceite(){
		return cambioaceite ;
	}
	
	// Devuelve el número de revoluciones al cambiar el aceite
	
	public int getRevolucionesAceite(){
		return revolucionesaceite ;
	}
	
	// Devuelve el indicador de cambio de pastillas
	
	public int getCambioPastillas(){
		return cambiopastillas ;
	}
	
	// Devuelve el número de revoluciones al cambiar las pastillas
	
	public int getRevolucionesPastillas(){
		return revolucionespastillas ;
	}
	
	// Devuelve el indicador de revisión general
	
	public int getRevisionGeneral(){
		return revisiongeneral ;
	}
	
	// Devuelve el número de revoluciones al hacer la revisión general
	
	public int getRevolucionesGeneral(){
		return revolucionesgeneral ;
	}
	
	// Compara el objeto actual con otro de su misma clase. Devuelve true cuando ambos
	// almacenan exactamente los mismos valores en sus distintos campos
	
	public boolean equals(Object objeto){
		if (objeto instanceof AlmacenadorMonitorizador){
			AlmacenadorMonitorizador almacenador = (AlmacenadorMonitorizador) objeto ;
			return (almacenador.getCambioAceite() == getCambioAceite() && almacenador.getRevolucionesAceite() == getRevolucionesAceite() 
					&& almacenador.getCambioPastillas() == getCambioPastillas() && almacenador.getRevolucionesPastillas() == getRevolucionesPastillas()
					&& almacenador.getRevisionGeneral() == getRevisionGeneral() && almacenador.getRevolucionesGeneral() == getRevolucionesGeneral()) ;
		}
		
		return false ;
	}
}
