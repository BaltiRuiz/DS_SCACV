package ControlVelocidad;

public class Reloj extends Thread {
	
	private final int INTERVALO ;
	private ControlVelocidad control ;
	
	public Reloj(int elintervalo, ControlVelocidad ControlVelocidad_c) {
		this.INTERVALO = elintervalo ;
		this.control = ControlVelocidad_c ;
	}
	
	public void run() {
		while(true){
			try{ 
				sleep(INTERVALO) ;
			}catch(java.lang.InterruptedException e){e.printStackTrace();}	
			control.controlarEstado() ;
		}
	}
}