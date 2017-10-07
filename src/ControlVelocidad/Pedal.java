package ControlVelocidad;

// Clase añadida para facilitar las pruebas unitarias de 'Acelerador' y 'Freno', ya que ambas tienen métodos de
// funcionalidad similar

public interface Pedal {
	public boolean leerEstado() ;
	public void pisar() ;
	public void soltar() ;
	public double actualizar() ;
}
