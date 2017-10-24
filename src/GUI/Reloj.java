package GUI;

// Reloj asociado al panel principal de simulación.

public class Reloj extends Thread{
	private PanelSimulador simulador ;
	private final int INTERVALO = 50 ;
	
	// Constructor de la clase. Recibe como argumento el panel de simulación
	
	public Reloj(PanelSimulador elsimulador){
		simulador = elsimulador ;
	}
	
	// Devuelve el intervalo de tiempo marcado por el reloj
	
	public int getIntervalo(){
		return INTERVALO ;
	}
	
	// Llama al método 'accionesPeriodicas' del panel simulador, en un intervalo de tiempo marcado
	// por el campo 'INTERVALO' del reloj
	
	public void run(){
		while (true){
			simulador.accionesPeriodicas() ;
			try{
				sleep(INTERVALO) ;
			}
			catch(InterruptedException e){
				e.printStackTrace() ;
			}
		}
	}
}
