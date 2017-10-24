package SubsistemaMonitorizacion;

// Clase encargada de avisar al sistema de la necesidad de realizar las tareas de mantenimiento,
// a través de una clase almacenadora que hará de enlace con el Panel Informativo

public class NotificadorMantenimiento {
	private AlmacenadorMonitorizador almacenadormonitorizador ;
	
	// Constructor de la clase. Recibe como argumento la clase almacenadora
	
	public NotificadorMantenimiento(AlmacenadorMonitorizador elalmacenador){
		almacenadormonitorizador = elalmacenador ;
	}
	
	// Devuelve la clase almacenadora
	
	public AlmacenadorMonitorizador getAlmacenadorMonitorizador(){
		return almacenadormonitorizador ;
	}
	
	// Guarda en la clase almacenadora el valor 1 en el campo 'cambioaceite' para indicar que es
	// necesario un cambio de aceite
	
	public void notificarCambioAceite(){
		almacenadormonitorizador.almacenarCambioAceite(1) ;
	}
	
	// Guarda en la clase almacenadora el valor 1 en el campo 'cambiopastillas' para indicar que es
	// necesario un cambio de pastillas
	
	public void notificarCambioPastillas(){
		almacenadormonitorizador.almacenarCambioPastillas(1) ;
	}
	
	// Guarda en la clase almacenadora el valor 1 en el campo 'revisiongeneral' para indicar que es
	// necesario hacer una revisión general del sistema
	
	public void notificarRevisionGeneral(){
		almacenadormonitorizador.almacenarRevisionGeneral(1) ;
	}
	
	// Guarda en la clase almacenadora el valor 0 en el campo indicado como primer argumento para
	// decir que ya se ha realizado la tarea de mantenimiento correspondiente. Almacena también el
	// número de revoluciones totales del coche (incluyendo apagados del motor) en el momento
	// en que se realizó la tarea
	
	public void notificarArregloVehiculo(int tipo, int numrevoluciones){
		switch(tipo){
			case 0: almacenadormonitorizador.almacenarCambioAceite(0) ;
					almacenadormonitorizador.almacenarRevolucionesAceite(numrevoluciones) ;
			break ;
			case 1: almacenadormonitorizador.almacenarCambioPastillas(0) ;
					almacenadormonitorizador.almacenarRevolucionesPastillas(numrevoluciones) ;
			break ;
			case 2: almacenadormonitorizador.almacenarRevisionGeneral(0) ;
					almacenadormonitorizador.almacenarRevolucionesGeneral(numrevoluciones) ;
		}
	}
	
	// Compara el objeto actual con otro de la misma clase. Devuelve true cuando ambos están asociados
	// a la misma clase almacenadora
	
	public boolean equals(Object objeto){
		if (objeto instanceof NotificadorMantenimiento){
			NotificadorMantenimiento notificador = (NotificadorMantenimiento) objeto ;
			return (notificador.getAlmacenadorMonitorizador().equals(getAlmacenadorMonitorizador())) ;
		}
		
		return false ;
	}
}
