package ControlVelocidad;

public class ControlVelocidad {
	
	public Acelerador acelera ;
	public Almacenamiento almacena ;
	public Eje eje ;
	public Freno freno ;
	public Motor motor ;
	public Palanca estadoPalanca ;
	private Reloj reloj ;
	private Automatico automatico ;
	
	private int camino ;	// AÑADIDO
	
	public ControlVelocidad(int elintervalo) {
		acelera = new Acelerador() ;
		almacena = new Almacenamiento() ;
		automatico = new Automatico() ;
		eje = new Eje() ;
		freno = new Freno() ;
		motor = new Motor() ;
		estadoPalanca = new Palanca() ;
		reloj = new Reloj(elintervalo, this) ;
		
		camino = 0 ;
	}
	
	public void start(){
		reloj.start() ;
	}
	
	public void controlarEstado() {		
		int incremento = 0, decremento = 0 ;

		if(motor.leerEstado()){
			if(estadoPalanca.leerEstado() == Palanca.APAGADO){
				if(acelera.leerEstado()){
					acelera.guardarVelocidadAnterior(eje.getVelAnterior()) ;
					incremento = (int) acelera.actualizar() ;
					acelera.incrementar(incremento, eje) ;
					calcularVelcidad() ;
					
					camino = 1 ;
				}
				
				if(freno.leerEstado()){
					decremento = (int) freno.actualizar() ;
					freno.decremento(decremento, eje) ;
					calcularVelcidad() ;
					
					camino = 2 ;
				}
				
				if(!acelera.leerEstado() && !freno.leerEstado()){
					freno.decremento(Freno.ROZAMIENTO, eje) ;
					calcularVelcidad() ;
					
					camino = 3 ;
				}
			}
			
			if(estadoPalanca.leerEstado() == Palanca.MANTENIENDO){
				almacena.almacenarVelSeleccionada() ;
				automatico.mantenerVelocidad(acelera, freno,almacena, eje) ;
				calcularVelcidad() ;
				
				camino = 4 ;
			}
			
			if(estadoPalanca.leerEstado() == Palanca.REINICIANDO){
				automatico.mantenerVelocidad(acelera, freno, almacena, eje) ;
				calcularVelcidad() ;
				
				camino = 5 ;
			}
		}
		
		else{
			if(freno.leerEstado()){
				decremento = (int) freno.actualizar() ;
				freno.decremento(decremento, eje) ;
				calcularVelcidad() ;
				
				camino = 6 ;
			}
			
			freno.decremento(Freno.ROZAMIENTO, eje) ;
			calcularVelcidad() ;
		}	
	}
	
	public void cambiarPalanca(int aInt_estado) {
		estadoPalanca.cambiarEstado(aInt_estado) ;
	}
	
	public int obtenerVel(){
		return almacena.leerVelocidad() ;
	}
	
	public double obtenerDist(){
		return almacena.leerDistancia() ;
	}
	
	public int obtenerRev(){
		return eje.leerRevoluciones() ;	
	}
	
	public long obtenerRevtotal(){
		return eje.leerRevolucionesTotales() ;	
	}
	
	// AÑADIDO
	
	public Acelerador getAcelerador(){
		return acelera ;
	}
	
	// AÑADIDO
	
	public Freno getFreno(){
		return freno ;
	}
	
	// AÑADIDO
	
	public Motor getMotor(){
		return motor ;
	}
	
	// AÑADIDO
	
	public Palanca getPalanca(){
		return estadoPalanca ;
	}
	
	// AÑADIDO
	
	public Reloj getReloj(){
		return reloj ;
	}
	
	// AÑADIDO
	
	public int getCamino(){
		return camino ;
	}
	
	protected void calcularVelcidad(){
		eje.calcularVelocidad(almacena) ;
	}
	
	public int leerVelSeleccionada() {
		return almacena.leerVelSeleccionada() ;
	}
}