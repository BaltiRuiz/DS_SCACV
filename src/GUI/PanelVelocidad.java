package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

// Panel que contiene la información asociada a la velocidad del vehículo: Velocidad actual,
// velocidad automática y velocidad media.

public class PanelVelocidad extends JPanel {
	
	private ObservadorVelocidad observadorvelocidad ;
	private JLabel velocidadactual ;
	private JLabel velocidadautomatica ;
	private JLabel velocidadmedia ;

	/**
	 * Create the panel.
	 */
	
	// Constructor de la clase. Recibe como argumento la clase observadora necesaria para indicar
	// los 3 valores de velocidad. Se encarga de crear la etiqueta de título y las 3 etiquetas
	// asociadas a los 3 valores mencionados justo antes
	
	public PanelVelocidad(ObservadorVelocidad elobservador) {
		setLayout(null) ;
		
		observadorvelocidad = elobservador ;
		
		JLabel titulovelocidad = new JLabel("VELOCIDAD:") ;
		titulovelocidad.setFont(new Font("Liberation Sans", Font.BOLD, 20)) ;
		titulovelocidad.setBounds(100, 12, 140, 15) ;
		add(titulovelocidad) ;
		
		velocidadactual = new JLabel("") ;
		velocidadactual.setBorder(new LineBorder(new Color(0, 0, 0))) ;
		velocidadactual.setHorizontalAlignment(SwingConstants.CENTER) ;
		velocidadactual.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 40)) ;
		velocidadactual.setBounds(50, 40, 220, 100) ;
		add(velocidadactual) ;
		
		velocidadautomatica = new JLabel() ;
		velocidadautomatica.setBorder(new LineBorder(new Color(0, 0, 0)));
		velocidadautomatica.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		velocidadautomatica.setBounds(12, 152, 301, 30) ;
		add(velocidadautomatica) ; 
		
		velocidadmedia = new JLabel() ;
		velocidadmedia.setBorder(new LineBorder(new Color(0, 0, 0)));
		velocidadmedia.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		velocidadmedia.setBounds(12, 205, 301, 30) ;
		add(velocidadmedia) ;
	}
	
	// Realiza las tareas periódicas asociadas a este panel. Actualiza las etiquetas con los valores de
	// velocidad que tiene su observador
	
	public synchronized void accionesPeriodicas(){
		velocidadactual.setText(String.valueOf((int) observadorvelocidad.getVelocidadActual()) + " km/h") ;
		velocidadautomatica.setText(" VELOCIDAD AUTOM�TICA:  " + String.valueOf((int) observadorvelocidad.getVelocidadAutomatica()) + " km/h") ;
		velocidadmedia.setText(String.format(" VELOCIDAD MEDIA:  " + "%.5f", observadorvelocidad.getVelocidadMedia()) + " km/h") ;
	}
}
