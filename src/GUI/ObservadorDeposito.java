package GUI;

import SubsistemaControl.Almacenador;

// Clase observadora del depósito del vehículo, concretamente, vigila los valores del nivel actual del
// depósito y el gasto medio de combustible.

public class ObservadorDeposito implements Observador{
	private Almacenador almacenador ;
	private int valordeposito ;
	private double valorcombustiblemedio ;
	
	// Constructor de la clase. Recibe como argumento la clase almacenadora que observará
	
	public ObservadorDeposito(Almacenador elalmacenador){
		almacenador = elalmacenador ;
		almacenador.incluirObservador(this) ;
		valordeposito = almacenador.getNivelDeposito() ;
		valorcombustiblemedio = almacenador.getGastoCombustibleMedio() ;
	}
	
	// Devuelve el almacenador que está observando
	
	public Almacenador getAlmacenador(){
		return almacenador ;
	}
	
	// Devuelve el nivel del depósito actual
	
	public int getNivelDeposito(){
		return valordeposito ;
	}
	
	// Devuelve el gasto medio de combustible
	
	public double getGastoMedio(){
		return valorcombustiblemedio ;
	}
	
	// Actualiza los dos valores del depósito observados cuando el observable se lo notifica
	
	public void manejarEvento(){
		valordeposito = almacenador.getNivelDeposito() ;
		valorcombustiblemedio = almacenador.getGastoCombustibleMedio() ;
	}
	
	// Compara el objeto actual con otro de la misma clase. Devuelve true cuando ambos observadores
	// vigilan almacenadores equivalentes y tienen el mismo valor en los dos campos que 
	// se encargan de observar
	
	public boolean equals(Object objeto){
		if (objeto instanceof ObservadorDeposito){
			ObservadorDeposito observadordeposito = (ObservadorDeposito) objeto ;
			return (observadordeposito.getAlmacenador().equals(getAlmacenador()) 
					&& observadordeposito.getNivelDeposito() == getNivelDeposito()
					&& observadordeposito.getGastoMedio() == getGastoMedio()) ; 
		}
		
		return false ;
	}
}
