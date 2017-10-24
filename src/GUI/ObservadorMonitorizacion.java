package GUI;

import SubsistemaMonitorizacion.AlmacenadorMonitorizador;

// Clase observadora de la parte de monitorización del sistema. Es decir, vigila los valores
// que indican la necesidad o no de realizar una tarea de mantenimiento y el número total de revoluciones
// del vehículo en el momento en que una de las tareas ha sido realizada.

public class ObservadorMonitorizacion implements Observador{
	private AlmacenadorMonitorizador almacenadormonitorizador ;
	private int cambioaceite ;
	private int cambiopastillas ;
	private int revisiongeneral ;
	private int revolucionesaceite ;
	private int revolucionespastillas ;
	private int revolucionesrevisiongeneral ;
	
	// Constructor de la clase. Recibe como argumento la clase almacenadora observable
	
	public ObservadorMonitorizacion(AlmacenadorMonitorizador elalmacenador){
		almacenadormonitorizador = elalmacenador ;
		almacenadormonitorizador.incluirObservador(this) ;
		cambioaceite = almacenadormonitorizador.getCambioAceite() ;
		cambiopastillas = almacenadormonitorizador.getCambioPastillas() ;
		revisiongeneral = almacenadormonitorizador.getRevisionGeneral() ;
		revolucionesaceite = almacenadormonitorizador.getRevolucionesAceite() ;
		revolucionespastillas = almacenadormonitorizador.getRevolucionesPastillas() ;
		revolucionesrevisiongeneral = almacenadormonitorizador.getRevolucionesGeneral() ;
	}
	
	// Devuelve el almacenador observado
	
	public AlmacenadorMonitorizador getAlmacenadorMonitorizador(){
		return almacenadormonitorizador ;
	}
	
	// Devuelve la necesidad o no de realizar un cambio de aceite
	
	public int getCambioAceite(){
		return cambioaceite ;
	}
	
	// Devuelve la necesidad o no de realizar un cambio de pastillas
	
	public int getCambioPastillas(){
		return cambiopastillas ;
	}
	
	// Devuelve la necesidad o no de realizar una revisión general
	
	public int getRevisionGeneral(){
		return revisiongeneral ;
	}
	
	// Devuelve el número total de revoluciones del vehículo cuando el aceite fue cambiado
	
	public int getRevolucionesAceite(){
		return revolucionesaceite ;
	}
	
	// Devuelve el número total de revoluciones del vehículo cuando las pastillas fueron cambiadas
	
	public int getRevolucionesPastillas(){
		return revolucionespastillas ;
	}
	
	// Devuelve el número total de revoluciones cuando fue realizada la revisión general
	
	public int getRevolucionesRevisionGeneral(){
		return revolucionesrevisiongeneral ;
	}
	
	// Actualiza los 6 valores de monitorización cuando la clase observable se lo indica
	
	public void manejarEvento(){
		cambioaceite = almacenadormonitorizador.getCambioAceite() ;
		cambiopastillas = almacenadormonitorizador.getCambioPastillas() ;
		revisiongeneral = almacenadormonitorizador.getRevisionGeneral() ;
		revolucionesaceite = almacenadormonitorizador.getRevolucionesAceite() ;
		revolucionespastillas = almacenadormonitorizador.getRevolucionesPastillas() ;
		revolucionesrevisiongeneral = almacenadormonitorizador.getRevolucionesGeneral() ;
	}
	
	// Compara este objeto con otro de la misma clase. Devuelve true cuando ambos observan almacenadores
	// equivalentes y coinciden en el resto de valores vigilados
	
	public boolean equals(Object objeto){
		if (objeto instanceof ObservadorMonitorizacion){
			ObservadorMonitorizacion observadormonitorizacion = (ObservadorMonitorizacion) objeto ;
			return (observadormonitorizacion.getAlmacenadorMonitorizador().equals(getAlmacenadorMonitorizador())
					&& observadormonitorizacion.getCambioAceite() == getCambioAceite() && observadormonitorizacion.getCambioPastillas() == getCambioPastillas()
					&& observadormonitorizacion.getRevisionGeneral() == getRevisionGeneral() && observadormonitorizacion.getRevolucionesAceite() == getRevolucionesAceite()
					&& observadormonitorizacion.getRevolucionesPastillas() == getRevolucionesPastillas()
					&& observadormonitorizacion.getRevolucionesRevisionGeneral() == getRevolucionesRevisionGeneral()) ;
		}
		
		return false ;
	}
}
