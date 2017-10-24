package SubsistemaMonitorizacion;

// Clase reloj del subsistema de monitorización.

public class Reloj extends Thread{
	private ControladorMonitorizador controlador ;
	private final int INTERVALO = 50 ;
	
	// Constructor de la clase. Recibe como argumento la clase controladora del subsistema 
	// de monitorización
	
	public Reloj(ControladorMonitorizador elcontrolador){
		controlador = elcontrolador ;
	}
	
	// Devuelve el intervalo de tiempo que marca el reloj
	
	public int getIntervalo(){
		return INTERVALO ;
	}
	
	// Llama periódicamente al método 'accionesPeriodicas' de la clase controladora, en el cual
	// obtiene los diferentes valores medios y actualiza la clase de mantenimiento
	
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
