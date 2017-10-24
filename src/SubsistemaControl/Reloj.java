package SubsistemaControl;

// Clase reloj del subsistema de control

public class Reloj extends Thread{
	private Controlador controlador ;
	private final int INTERVALO = 50 ;
	
	// Constructor de la clase, indicando como argumento la clase controladora sobre la que se actuará
	
	public Reloj(Controlador elcontrolador){
		controlador = elcontrolador ;
	}
	
	// Devuelve el intervalo de tiempo del reloj
	
	public int getIntervalo(){
		return INTERVALO ;
	}
	
	// Llama periódicamente al método 'accionesPeriodicas' del controlador, en función del
	// intervalo de tiempo en milisegundos que marca el campo 'INTERVALO' de la clase
	
	public void run(){
		while (true){
			controlador.accionesPeriodicas() ;
			try{
				sleep(INTERVALO) ;
			}
			catch(InterruptedException e){
				e.printStackTrace() ;
			}
		}
	}
}
