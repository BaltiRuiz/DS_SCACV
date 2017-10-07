package ControlVelocidad;

// Clase a�adida para facilitar las pruebas unitarias de 'Acelerador' y 'Freno', ya que ambas tienen m�todos de
// funcionalidad similar

public interface Pedal {
	public boolean leerEstado() ;
	public void pisar() ;
	public void soltar() ;
	public double actualizar() ;
}
