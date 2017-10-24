package SubsistemaControl;

// Clase Singleton principal del subsistema de control. Se encargará principalmente de instanciar los 
// diferentes dispositivos del coche y analizar periódicamente sus estados para en función de ello
// actuar de una manera u otra sobre el eje del vehículo, aumentando, disminuyendo o manteniendo la
// velocidad, entre otras tareas.

public class Controlador {
	private static Controlador instance = null ;
	
	private Reloj reloj ;
	private DispositivoAcelerador acelerador ;
	private DispositivoAutomatico controlautomatico ;
	private DispositivoEje eje ;
	private DispositivoFreno freno ;
	private DispositivoMotor motor ;
	private DispositivoPalanca palanca ;
	private Deposito deposito ;
	private CalculadorVelocidad calculadorvelocidad ;
	private Almacenador almacenador ;
	
	// Constructor de la clase
	
	private Controlador(){
		reloj = new Reloj(this) ;
		acelerador = new DispositivoAcelerador() ;
		controlautomatico = new DispositivoAutomatico() ;
		eje = new DispositivoEje() ;
		freno = new DispositivoFreno() ;
		motor = new DispositivoMotor() ;
		palanca = new DispositivoPalanca(this) ;
		deposito = new Deposito() ;
		calculadorvelocidad = new CalculadorVelocidad(reloj.getIntervalo(), eje) ;
		almacenador = new Almacenador() ;
		
		almacenador.almacenarNivelDeposito(deposito.getNivelDeposito()) ;
		almacenador.almacenarRadioEje(eje.getRadioEje()) ;
	}
	
	// Instancia la clase Singleton, llamando al constructor privado declarado previamente
	
	public static Controlador getInstance(){
		if (instance == null)
			instance = new Controlador() ;
		
		return instance ;
	}
	
	// Inicia las acciones a realizar periódicamente. Es llamado en el constructor de la clase
	// JApplet principal del SCACV
	
	public void iniciarControl(){
		reloj.start() ;
	}
	
	// Devuelve el dispositivo acelerador del sistema
	
	public DispositivoAcelerador getAcelerador(){
		return acelerador ;
	}
	
	// Devuelve el dispositivo de control automático del sistema
	
	public DispositivoAutomatico getAutomatico(){
		return controlautomatico ;
	}
	
	// Devuelve la clase que representa el eje del sistema
	
	public DispositivoEje getEje(){
		return eje ;
	}
	
	// Devuelve el dispositivo de freno del sistema
	
	public DispositivoFreno getFreno(){
		return freno ;
	}
	
	// Devuelve la clase que representa el motor del vehículo
	
	public DispositivoMotor getMotor(){
		return motor ;
	}
	
	// Devuelve el dispositivo palanca del sistema
	
	public DispositivoPalanca getPalanca(){
		return palanca ;
	}
	
	// Devuelve la clase que representa el depósito del vehículo
	
	public Deposito getDeposito(){
		return deposito ;
	}
	
	// Devuelve la clase calculadora de la velocidad del vehículo
	
	public CalculadorVelocidad getCalculador(){
		return calculadorvelocidad ;
	}
	
	// Devuelve la clase almacenadora
	
	public Almacenador getAlmacenador(){
		return almacenador ;
	}
	
	// Acciones periódicas a realizar por el subsistema de control. Inicialmente comprueba el estado
	// del motor, el control automático, el freno y el dispositivo de aceleración. Si el motor está
	// encendido, en función del estado de dichos dispositivos y la palanca, aumentará o disminuirá 
	// la velocidad angular del eje, traduciéndose en un incremento, decremento o mantenimiento de la
	// velocidad del vehículo, obtenida a continuación por el calculador de velocidad, provocando a su vez
	// un decremento (en función de si se lleva más o menos velocidad) del depósito. En caso de llevar
	// una velocidad excesiva (más de 250 km/h) o vaciar por completo el depósito (casos que a priori
	// debería evitar el usuario de la aplicación), se lanza una excepción indicando la entrada 
	// en un estado no válido del sistema

	public synchronized void accionesPeriodicas(){
		int estadomotor = motor.getEstadoMotor() ;
		int estadocontrolautomatico = controlautomatico.getEstado() ;
		int estadoacelerador = acelerador.getEstadoAcelerador() ;
		int estadofreno = freno.getEstadoFreno() ;
		
		if (estadomotor == 1){
			almacenador.almacenarEstadoAcelerador(estadoacelerador) ;
			almacenador.almacenarEstadoFreno(estadofreno) ;
			almacenador.almacenarTiempo(almacenador.getTiempo() + reloj.getIntervalo()) ;
			
			if (palanca.getEstadoPalanca() == PalancaEstado.REINICIANDO)
				reiniciarVelocidad() ;
			
			if (estadocontrolautomatico == 1)
				eje.incrementarVueltas(0) ;
			
			else{
				if (estadoacelerador == 1)
					eje.incrementarVueltas(1) ;
				
				if (estadofreno == 1)
					eje.decrementarVueltas(1) ;
				
				if (estadoacelerador == 0 && estadofreno == 0)
					eje.decrementarVueltas(0) ;
			}
			
			double velocidadactual = calculadorvelocidad.calcularVelocidad() ;
			almacenador.almacenarVelocidad(velocidadactual) ;
				
			deposito.vaciarDeposito((int) velocidadactual) ;
			almacenador.almacenarNivelDeposito(deposito.getNivelDeposito()) ;
				
			almacenador.almacenarRevolucionesEje(eje.getVueltasEje()) ;
			
			if (velocidadactual > 250)
				throw new IllegalStateException("Velocidad excesiva") ;
						
			if (deposito.getNivelDeposito() == 0)
				throw new IllegalStateException("Depósito vacío") ;
			
			if (velocidadactual == 0)
				palanca.moverPalanca(PalancaEstado.ENCENDIDO) ;
		}
	}
	
	// Recibe la señal de la palanca indicando un cambio de estado. Este método es llamado por el
	// dispositivo palanca cuando se ha pasado correctamente a un nuevo estado. Considerando el nuevo
	// estado al que se ha llegado, actuará de una manera u otra sobre los dispositivos del sistema
	
	public void recibirSenial(PalancaEstado estado){
		switch (estado){
			case MOTORAPAGADO:
				if (motor.getEstadoMotor() == 1){
					motor.apagarMotor() ;
					apagarSistema() ;
				}
			break ;
			case ENCENDIDO:
				if (motor.getEstadoMotor() == 0)
					motor.encenderMotor() ;
				if (freno.getEstadoFreno() == 1)
					freno.soltarFreno() ;
			break ;
			case ACELERANDO: 
				acelerador.pisarAcelerador() ;
				if (controlautomatico.getEstado() == 1)
					controlautomatico.desactivarControlAutomatico() ;
			break ;
			case FRENANDO: 
				freno.pisarFreno() ;
				if (acelerador.getEstadoAcelerador() == 1)
					acelerador.soltarAcelerador() ;
				if (controlautomatico.getEstado() == 1)
					controlautomatico.desactivarControlAutomatico() ;
			break ;
			case AUTOMATICO: 
				controlautomatico.activarControlAutomatico(almacenador.getVelocidad()) ;
				almacenador.almacenarVelocidadAutomatica(almacenador.getVelocidad()) ;
				if (freno.getEstadoFreno() == 1){
					freno.soltarFreno() ;
					acelerador.pisarAcelerador() ;
				}
			break ;
			case APAGADO:
				if (controlautomatico.getEstado() == 1)
					controlautomatico.desactivarControlAutomatico() ;
				if (acelerador.getEstadoAcelerador() == 1)
					acelerador.soltarAcelerador() ;
				if (freno.getEstadoFreno() == 1)
					freno.soltarFreno() ;
			break ;
			default:
			break ;
		}
		
		almacenador.almacenarEstadoPalanca(estado) ;
	}
	
	// Rellena por completo el depósito del vehículo, pero solamente si el estado actual del sistema
	// es con el motor apagado
	
	public void rellenarDeposito(){
		if(palanca.getEstadoPalanca() == PalancaEstado.MOTORAPAGADO)
		{
			deposito.rellenarDeposito() ;
			almacenador.almacenarNivelDeposito(deposito.getNivelDeposito()) ;
		}
	}
	
	// Lleva al vehículo a tener la velocidad que memorizó en última instancia el dispositivo de control
	// automático, pisando el acelerador o el freno en función de la velocidad que llevara el vehículo
	// en el momento de la invocación de este método
	
	public void reiniciarVelocidad(){
		int velocidadactual = (int) almacenador.getVelocidad() ;
		int velocidadautomatica = (int) almacenador.getVelocidadAutomatica() ;
		if (velocidadactual > velocidadautomatica){
			freno.pisarFreno() ;
		}
		
		else if (velocidadactual < velocidadautomatica){
			acelerador.pisarAcelerador() ;
		}
		
		else if (velocidadactual == velocidadautomatica){
			palanca.moverPalanca(PalancaEstado.AUTOMATICO) ;
		}
	}
	
	// Usado privadamente por el controlador al mover la palanca al estado de motor apagado, 
	// para llevar todos los dispositivos del subsistema al estado que tenían inicialmente, 
	// cuando el controlador fue instanciado
	
	private void apagarSistema(){
		almacenador.almacenarVelocidadAutomatica(0) ;
		almacenador.almacenarRevolucionesEje(0) ;
		almacenador.almacenarTiempo(0) ;
		controlautomatico.olvidarVelocidadAutomatica() ;
		eje.reiniciarVueltas() ;
		calculadorvelocidad.reiniciarValores() ;
	}
	
	// Compara el objeto actual con otro de su misma clase. Devuelve true cuando todos y cada uno
	// de los diferentes dispositivos que presentan como atributos coinciden en su estado.
	// Debería de devolver siempre true ya que siempre hay una única instancia de la clase controladora,
	// la cual debería cumplir la propiedad de reflexividad
	
	public boolean equals(Object objeto){
		if (objeto instanceof Controlador){
			Controlador controlador = (Controlador) objeto ;
			return (controlador.getAcelerador().equals(getAcelerador())
					&& controlador.getAutomatico().equals(getAutomatico()) && controlador.getAlmacenador().equals(getAlmacenador())
					&& controlador.getCalculador().equals(getCalculador()) && controlador.getDeposito().equals(getDeposito()) 
					&& controlador.getEje().equals(getEje()) && controlador.getFreno().equals(getFreno())
					&& controlador.getMotor().equals(getMotor()) && controlador.getPalanca().equals(getPalanca())) ;
		}
		
		return false ;
	}
}
