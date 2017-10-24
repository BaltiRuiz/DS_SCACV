package SubsistemaControl;

// Clase que representa el dispositivo de control automático del vehículo. Consta de un atributo estado
// (con valor 0 para indicar control automático inactivo, y 1 para indicar que se ha activado el control
// automático) y un campo donde guarda la velocidad memorizada por el sistema cuando se activó por
// última vez el control automático.

public class DispositivoAutomatico {
	private int estado ;
	private double velocidadautomatica ;
	
	// Constructor de la clase
	
	public DispositivoAutomatico(){
		estado = 0 ;
		velocidadautomatica = 0 ;
	}
	
	// Devuelve el estado del control automático
	
	public int getEstado(){
		return estado ;
	}
	
	// Devuelve la velocidad memorizada por el control automático
	
	public double getVelocidadAutomatica(){
		return velocidadautomatica ;
	}
	
	// Activa el control automático, cambiando el campo estado y guardando en el segundo atributo
	// la velocidad que llevara el vehículo en el momento en que se invocó este método
	
	public void activarControlAutomatico(double velocidad){
		estado = 1 ;
		velocidadautomatica = velocidad ;
	}
	
	// Desactiva el control automático
	
	public void desactivarControlAutomatico(){
		estado = 0 ;
	}
	
	// 'Olvida' la velocidad que debe mantener el vehículo al ponerla a 0. Es llamado por el método
	// 'apagarSistema' de la clase controladora
	
	public void olvidarVelocidadAutomatica(){
		velocidadautomatica = 0 ;
	}
	
	// Compara este objeto con otro de su misma clase. Devuelve true cuando ambos presentan el mismo
	// valor en los dos campos que hacen de atributos de esta clase
	
	public boolean equals(Object objeto){
		if (objeto instanceof DispositivoAutomatico){
			DispositivoAutomatico automatico = (DispositivoAutomatico) objeto ;
			return (automatico.getEstado() == getEstado() 
					&& automatico.getVelocidadAutomatica() == getVelocidadAutomatica()) ;
		}
		
		return false ;
	}
}
