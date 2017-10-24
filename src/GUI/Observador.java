package GUI;

// Interfaz que representa la clase encargada de observar a la clase observable y realizar una tarea
// cuando dicho observable le notifica de un cambio. Habrá 4 observadores distintos en el sistema,
// encargados de vigilar un conjunto particular de campos relacionados entre sí, 
// de las clases almacenadoras.

public interface Observador {
	public void manejarEvento() ;
}
