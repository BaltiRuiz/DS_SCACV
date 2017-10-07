package Simulador;

public class Simulacion extends Thread {
	
	private final int INTERVALO = 100 ;
	private ListaObservadoresObservables listaobservadoresobservables ;
	
	public Simulacion(){
		listaobservadoresobservables = new ListaObservadoresObservables() ;
	}
	
	public void addObservador(Observador elobservador){
		listaobservadoresobservables.agregarObservador(elobservador) ;
	}
	
	public void run() {
		while(true){
			try{ 
				sleep(INTERVALO) ;
			}catch(java.lang.InterruptedException e){e.printStackTrace();}
			listaobservadoresobservables.notificarObservador() ;
		}
	}
}