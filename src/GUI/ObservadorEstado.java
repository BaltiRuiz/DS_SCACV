package GUI;

import SubsistemaControl.Almacenador;
import SubsistemaControl.PalancaEstado;

// Clase observadora del estado del vehículo, entendiéndolo en este caso como la posición actual de la
// palanca, el estado del acelerador y el freno y el total de revoluciones.

public class ObservadorEstado implements Observador{
	private Almacenador almacenador ;
	private PalancaEstado estadopalanca ;
	private int numrevoluciones ;
	private int estadoacelerador ;
	private int estadofreno ;
	
	// Constructor de la clase. Recibe como argumento la clase almacenadora observable
	
	public ObservadorEstado(Almacenador elalmacenador){
		almacenador = elalmacenador ;
		almacenador.incluirObservador(this) ;
		estadopalanca = almacenador.getEstadoPalanca() ;
		numrevoluciones = almacenador.getRevolucionesEje() ;
		estadoacelerador = almacenador.getEstadoAcelerador() ;
		estadofreno = almacenador.getEstadoFreno() ;
	}
	
	// Devuelve el almacenador observado
	
	public Almacenador getAlmacenador(){
		return almacenador ;
	}
	
	// Devuelve el estado actual de la palanca
	
	public PalancaEstado getEstadoPalanca(){
		return estadopalanca ;
	}
	
	// Devuelve el número de vueltas dadas por el eje
	
	public int getNumRevoluciones(){
		return numrevoluciones ;
	}
	
	// Devuelve el estado actual del pedal de aceleración
	
	public int getEstadoAcelerador(){
		return estadoacelerador ;
	}
	
	// Devuelve el estado actual del pedal de freno
	
	public int getEstadoFreno(){
		return estadofreno ;
	}
	
	// Actualiza los 4 valores de estado cuando la clase observable se lo notifica
	
	public void manejarEvento(){
		estadopalanca = almacenador.getEstadoPalanca() ;
		numrevoluciones = almacenador.getRevolucionesEje() ;
		estadoacelerador = almacenador.getEstadoAcelerador() ;
		estadofreno = almacenador.getEstadoFreno() ;
	}
	
	// Compara el objeto actual con otro de la misma clase. Devuelve true cuando ambos vigilan el
	// almacenadores equivalentes y coinciden en el resto de campos observados
	
	public boolean equals(Object objeto){
		if (objeto instanceof ObservadorEstado){
			ObservadorEstado observadorestado = (ObservadorEstado) objeto ;
			return (observadorestado.getAlmacenador().equals(getAlmacenador()) && observadorestado.getEstadoAcelerador() == getEstadoAcelerador()
					&& observadorestado.getEstadoFreno() == getEstadoFreno() && observadorestado.getEstadoPalanca() == getEstadoPalanca()
					&& observadorestado.getNumRevoluciones() == getNumRevoluciones()) ;
		}
		
		return false ;
	}
}
