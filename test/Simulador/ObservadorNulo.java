package Simulador;

public class ObservadorNulo implements Observador {

	private int valoractualizar = 0 ;

	public void actualizar() {
		valoractualizar = 1 ;
	}
	
	public int getValorActualizar(){
		return valoractualizar ;
	}
}
