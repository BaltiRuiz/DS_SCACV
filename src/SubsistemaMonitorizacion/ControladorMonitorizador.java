package SubsistemaMonitorizacion;

import SubsistemaControl.Almacenador;
import SubsistemaControl.PalancaEstado;

// Clase Singleton principal del subsistema de monitorización. Se encargará de instanciar 
// las diferentes clases monitorizadoras y de mantenimiento del sistema, las cuales usará para
// calcular los valores promedio de velocidad y gasto del depósito y avisar si se da el caso
// de la necesidad de realizar una tarea de mantenimiento.

public class ControladorMonitorizador {
	private static ControladorMonitorizador instance = null ;
	
	private Almacenador almacenador ;
	private AlmacenadorMonitorizador almacenadormonitorizador ;
	private Reloj reloj ;
	private MonitorizadorMotor monitorizadormotor ;
	private MonitorizadorCombustible monitorizadorcombustible ;
	private NotificadorMantenimiento notificadormantenimiento ;
	private Mantenimiento mantenimiento ;
	
	// Constructor de la clase. Recibe como argumento la clase almacenadora del subsistema de control
	// que necesitan sus clases monitorizadoras para hacer sus cálculos
	
	private ControladorMonitorizador(Almacenador elalmacenador){
		almacenador = elalmacenador ;
		almacenadormonitorizador = new AlmacenadorMonitorizador() ;
		
		reloj = new Reloj(this) ;
		monitorizadormotor = new MonitorizadorMotor(almacenador.getRadioEje()) ;
		monitorizadorcombustible = new MonitorizadorCombustible(almacenador.getNivelDeposito()) ;
		notificadormantenimiento = new NotificadorMantenimiento(almacenadormonitorizador) ;
		mantenimiento = new Mantenimiento(notificadormantenimiento) ;
	}
	
	// Instancia la clase Singleton controladora, llamando al constructor privado declarado antes
	
	public static ControladorMonitorizador getInstance(Almacenador elalmacenador){
		if (instance == null)
			instance = new ControladorMonitorizador(elalmacenador) ;
		
		return instance ;
	}
	
	// Inicia las acciones a realizar periódicamente. Es llamado en el constructor de la clase
	// JApplet principale del SCACV
	
	public void iniciarMonitorizacion(){
		reloj.start() ;
	}
	
	// Devuelve la clase almacenadora del subsistema de control
	
	public Almacenador getAlmacenador(){
		return almacenador ;
	}
	
	// Devuelve la clase almacenadora del propio subsistema de monitorización
	
	public AlmacenadorMonitorizador getAlmacenadorMonitorizador(){
		return almacenadormonitorizador ;
	}
	
	// Devuelve la clase monitorizadora del motor
	
	public MonitorizadorMotor getMonitorizadorMotor(){
		return monitorizadormotor ;
	}
	
	// Devuelve la clase monitorizadora del combustible
	
	public MonitorizadorCombustible getMonitorizadorCombustible(){
		return monitorizadorcombustible ;
	}
	
	// Devuelve la clase notificadora
	
	public NotificadorMantenimiento getNotificador(){
		return notificadormantenimiento ;
	}
	
	// Devuelve la clase monitorizadora de las tareas de mantenimiento
	
	public Mantenimiento getMantenimiento(){
		return mantenimiento ;
	}
	
	// Acciones periódicas a realizar por el subsistema de monitorización. Resetea los diferentes
	// atributos y contadores de las clases monitorizadoras en caso de estar el motor apagado. En
	// caso contrario, calcula en cada instante la velocidad y gasto de combustible promedio y
	// avisa (o no) a la clase notificadora de la necesidad de realizar una tarea de mantenimiento
	// en función de las revoluciones dadas por el eje del vehículo
	
	public synchronized void accionesPeriodicas(){
		if (almacenador.getEstadoPalanca() == PalancaEstado.MOTORAPAGADO)
		{
			almacenador.almacenarVelocidadMedia(0) ;
			almacenador.almacenarGastoCombustibleMedio(0) ;
			monitorizadormotor.reiniciarValores() ;
			monitorizadorcombustible.reiniciarValores(almacenador.getNivelDeposito()) ;
			mantenimiento.reiniciarValores() ;
		}
		
		else{
			double velocidadpromedio = monitorizadormotor.calcularVelocidadPromedio() ;
			monitorizadormotor.actualizarValores(almacenador.getRevolucionesEje(), almacenador.getTiempo()) ;
			almacenador.almacenarVelocidadMedia(velocidadpromedio) ;
		
			double gastocombustiblepromedio = monitorizadorcombustible.calcularGastoCombustiblePromedio() ;
			monitorizadorcombustible.actualizarValores(almacenador.getNivelDeposito(), almacenador.getTiempo()) ;
			almacenador.almacenarGastoCombustibleMedio(gastocombustiblepromedio) ;
		
			mantenimiento.actualizarValoresRevoluciones(almacenador.getRevolucionesEje()) ;		
		}
	}
	
	// Compara el objeto actual con otro de la misma clase. Devuelve true cuando todas y cada una de las
	// clases tienen el mismo estado, hecho que a priori debería darse siempre ya que esta clase es
	// Singleton y tiene una única instancia en todo momento, cumpliendo en principio la propiedad
	// de reflexividad
	
	public boolean equals(Object objeto){
		if (objeto instanceof ControladorMonitorizador){
			ControladorMonitorizador monitorizador = (ControladorMonitorizador) objeto ;
			return (monitorizador.getAlmacenador().equals(getAlmacenador())
					&& monitorizador.getMantenimiento().equals(getMantenimiento()) && monitorizador.getNotificador().equals(getNotificador())
					&& monitorizador.getMonitorizadorMotor().equals(getMonitorizadorMotor())
					&& monitorizador.getMonitorizadorCombustible().equals(getMonitorizadorCombustible())
					&& monitorizador.getAlmacenadorMonitorizador().equals(getAlmacenadorMonitorizador())) ;
		}
		
		return false ;
	}
}
