package SubsistemaMonitorizacion;

// Clase mantenimiento del subsistema de monitorización. Es la que se encarga de actualizar los
// diferentes contadores de revoluciones necesarios para avisar al notificador de la necesidad de una
// tarea de mantenimiento del vehículo.

public class Mantenimiento {
	private int revolucionesaceite ;
	private int revolucionespastillas ;
	private int revolucionesrevisiongeneral ;
	private int revolucionesanteriores ;
	private int contadorrevoluciones ;
	private boolean cambiaraceite ;
	private boolean cambiarpastillas ;
	private boolean hacerrevision ;
	
	private NotificadorMantenimiento notificadormantenimiento ;
	
	// Constructor de la clase. Se pasa la clase notificadora como argumento
	
	public Mantenimiento(NotificadorMantenimiento elnotificador){
		revolucionesaceite = 0 ;
		revolucionespastillas = 0 ;
		revolucionesrevisiongeneral = 0 ;
		revolucionesanteriores = 0 ;
		contadorrevoluciones = 0 ;
		cambiaraceite = false ;
		cambiarpastillas = false ;
		hacerrevision = false ;
		
		notificadormantenimiento = elnotificador ;
	}
	
	// Devuelve el contador de revoluciones para el cambio de aceite
	
	public int getRevolucionesAceite(){
		return revolucionesaceite ;
	}
	
	// Devuelve el contador de revoluciones para el cambio de pastillas
	
	public int getRevolucionesPastillas(){
		return revolucionespastillas ;
	}
	
	// Devuelve el contador de revoluciones para la revisión general
	
	public int getRevolucionesRevisionGeneral(){
		return revolucionesrevisiongeneral ;
	}
	
	// Devuelve el número de revoluciones recibido en el instante de tiempo anterior
	
	public int getRevolucionesAnteriores(){
		return revolucionesanteriores ;
	}
	
	// Devuelve el total de revoluciones realizadas por el vehículo
	
	public int getContadorRevoluciones(){
		return contadorrevoluciones ;
	}
	
	// Devuelve la necesidad o no de hacer un cambio de aceite
	
	public boolean getCambiarAceite(){
		return cambiaraceite ;
	}
	
	// Devuelve la necesidad o no de hacer un cambio de pastillas
	
	public boolean getCambiarPastillas(){
		return cambiarpastillas ;
	}
	
	// Devuelve la necesidad o no de hacer una revisión general del sistema
	
	public boolean getHacerRevision(){
		return hacerrevision ;
	}
	
	// Actualiza los valores de sus diferentes atributos en función del número de revoluciones actuales
	// del eje. Teniendo en cuenta el número de revoluciones del instante anterior 
	// ('revolucionesanteriores'), calcula la diferencia entre ambos valores para añadirla así al
	// contador total y a los contadores de mantenimiento. Cuando uno de estos contadores llega al valor
	// crítico, deja de actualizarse y avisa al notificador de la necesidad de realizar la tarea de
	// mantenimiento que tenía asociado
	
	public void actualizarValoresRevoluciones(int lasrevoluciones){
		int diferencia = lasrevoluciones - revolucionesanteriores ;
		contadorrevoluciones += diferencia ;
		revolucionesanteriores = lasrevoluciones ;
		
		if (!cambiaraceite){
			revolucionesaceite += diferencia ;
			if (revolucionesaceite >= 5000000){
				notificadormantenimiento.notificarCambioAceite() ;
				cambiaraceite = true ;
			}	
		}
		
		if (!cambiarpastillas){
			revolucionespastillas += diferencia ;
			if (revolucionespastillas >= 100000000){
				notificadormantenimiento.notificarCambioPastillas() ;
				cambiarpastillas = true ;
			}
		}
		
		if (!hacerrevision){
			revolucionesrevisiongeneral += diferencia ;
			if (revolucionesrevisiongeneral >= 1000000000){
				notificadormantenimiento.notificarRevisionGeneral() ;
				hacerrevision = true ;
			}
		}
	}
	
	// Coloca el número de revoluciones del instante anterior a 0 para reiniciar sin problemas la cuenta
	// de revoluciones (el contador total se mantiene, sin embargo)
	
	public void reiniciarValores(){
		revolucionesanteriores = 0 ;
	}
	
	// Avisa al notificador de la resolución correcta de una de las tres tareas de mantenimiento del
	// vehículo, indicada en el argumento de la función
	
	public void arreglarVehiculo(int tipo){
		switch(tipo){
			case 0: revolucionesaceite = 0 ;
					cambiaraceite = false ;
			break ;
			case 1: revolucionespastillas = 0 ;
					cambiarpastillas = false ;
			break ;
			case 2: revolucionesrevisiongeneral = 0 ;
					hacerrevision = false ;
			break ;
		}
		
		notificadormantenimiento.notificarArregloVehiculo(tipo, contadorrevoluciones) ;
	}
	
	// Compara el objeto actual con otro de la misma clase. Devuelve true cuando ambos tienen
	// exactamente los mismos valores en los diferentes campos que hacen de atributos de la clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof Mantenimiento){
			Mantenimiento mantenimiento = (Mantenimiento) objeto ;
			return (mantenimiento.getRevolucionesAceite() == getRevolucionesAceite() && mantenimiento.getRevolucionesPastillas() == getRevolucionesPastillas()
					&& mantenimiento.getRevolucionesRevisionGeneral() == getRevolucionesRevisionGeneral() 
					&& mantenimiento.getRevolucionesAnteriores() == getRevolucionesAnteriores() && mantenimiento.getContadorRevoluciones() == getContadorRevoluciones() 
					&& mantenimiento.getCambiarAceite() == getCambiarAceite() && mantenimiento.getCambiarPastillas() == getCambiarPastillas()
					&& mantenimiento.getHacerRevision() == getHacerRevision()) ;
		}
		
		return false ;
	}
}
