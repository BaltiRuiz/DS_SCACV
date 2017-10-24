package GUI;

import java.util.ArrayList;

// Clase que representa un objeto observable del sistema. Posee un método para asociarle diferentes
// observadores y otro método para notificarles de un cambio, el cual procesarán de una u otra manera
// en función del tipo de observador. Esta clase será extendida por las dos clases almacenadoras.

public class Observable {
	private ArrayList<Observador> observadores = new ArrayList<Observador>() ;
	
	public void incluirObservador (Observador o){
		observadores.add(o) ;
	}
	
	public void notificarObservador(){
		for (int i = 0 ; i < observadores.size() ; i++)
			observadores.get(i).manejarEvento() ;
	}
}