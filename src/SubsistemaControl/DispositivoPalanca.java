package SubsistemaControl;

// Clase que representa la palanca con la cual se viaja entre los distintos estados que puede tomar
// el SCACV. Consta de un campo en el que se indica el estado actual de la palanca y una referencia
// a la clase controladora para poder enviarle la señal de cambio de estado.

public class DispositivoPalanca {
	private PalancaEstado estadopalanca ;
	
	private Controlador controlador ;
	
	// Constructor de la clase, indicando como argumento la clase controladora del sistema
	
	public DispositivoPalanca(Controlador elcontrolador){
		estadopalanca = PalancaEstado.MOTORAPAGADO ;
		controlador = elcontrolador ;
	}
	
	// Devuelve el estado actual de la palanca
	
	public PalancaEstado getEstadoPalanca(){
		return estadopalanca ;
	}
	
	// Devuelve el controlador asociado a la palanca
	
	public Controlador getControlador(){
		return controlador ;
	}
	
	// Mueve la palanca al estado indicado como argumento. Internamente se encarga de realizar las
	// comprobaciones necesarias para saber si, teniendo en cuenta el estado actual de la palanca, se
	// puede pasar o no al estado que se pasa como argumento. Si la transición es válida, actualiza el
	// estado y envía una señal de cambio a la clase controladora
	
	public void moverPalanca(PalancaEstado estado){
		boolean aceptar = false ;
		
		if (estado == PalancaEstado.MOTORAPAGADO){
			if (estadopalanca == PalancaEstado.ENCENDIDO)
				aceptar = true ;
		}
		
		else if (estado == PalancaEstado.ENCENDIDO){
			if (estadopalanca == PalancaEstado.MOTORAPAGADO || 
					(estadopalanca == PalancaEstado.FRENANDO && controlador.getAlmacenador().getVelocidad() == 0))
				aceptar = true ;
		}
		
		else if (estado == PalancaEstado.ACELERANDO){
			if (estadopalanca == PalancaEstado.ENCENDIDO || estadopalanca == PalancaEstado.APAGADO 
					|| estadopalanca == PalancaEstado.REINICIANDO || estadopalanca == PalancaEstado.AUTOMATICO)
				aceptar = true ;
		}
		
		else if (estado == PalancaEstado.FRENANDO){
			if (estadopalanca == PalancaEstado.AUTOMATICO || estadopalanca == PalancaEstado.REINICIANDO 
					|| estadopalanca == PalancaEstado.APAGADO)
				aceptar = true ;
		}
		
		else if (estado == PalancaEstado.REINICIANDO){
			if (estadopalanca == PalancaEstado.APAGADO)
				aceptar = true ;
		}
		
		else if (estado == PalancaEstado.AUTOMATICO){
			if (estadopalanca == PalancaEstado.ACELERANDO || estadopalanca == PalancaEstado.REINICIANDO)
				aceptar = true ;
		}
		
		else if (estado == PalancaEstado.APAGADO){
			if (estadopalanca == PalancaEstado.AUTOMATICO || estadopalanca == PalancaEstado.ACELERANDO
					|| estadopalanca == PalancaEstado.FRENANDO)
				aceptar = true ;
		}
		
		if (aceptar){
			estadopalanca = estado ;
			controlador.recibirSenial(estado) ;
		}
	}
	
	// Compara este objeto con otro de su misma clase. Devuelve true cuando ambos presentan el mismo
	// estado y están asociados a la misma clase controladora
	
	public boolean equals(Object objeto){
		if (objeto instanceof DispositivoPalanca){
			DispositivoPalanca palanca = (DispositivoPalanca) objeto ;
			return (palanca.getEstadoPalanca() == getEstadoPalanca() 
					&& palanca.getControlador() == getControlador()) ;
		}
		
		return false ;
	}
}
