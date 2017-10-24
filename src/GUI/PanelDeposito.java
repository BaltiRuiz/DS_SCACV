package GUI;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

// Panel que contiene la informaci贸n asociada al dep贸sito del veh铆culo: Porcentaje del total de
// dep贸sito disponible, una barra de progreso que informa gr谩ficamente del valor anterior, y el
// gasto de combustible medio.

public class PanelDeposito extends JPanel {
	
	private ObservadorDeposito observadordeposito ;
	private final int TOPEDEPOSITO ;
	private JProgressBar niveldeposito ;
	private JLabel porcentajedeposito ;
	private JLabel gastomedio ;

	/**
	 * Create the panel.
	 */
	
	// Constructor del panel. Recibe como argumento el observador necesario para indicar el nivel
	// actual del dep贸sito como porcentaje y el gasto medio. Se encarga de crear la etiqueta de
	// t铆tulo, la etiqueta de porcentaje, la barra de progreso y la etiqueta de gasto medio
	
	public PanelDeposito(ObservadorDeposito elobservador) {
		setLayout(null) ;
		
		observadordeposito = elobservador ;
		TOPEDEPOSITO = observadordeposito.getNivelDeposito() ;
		
		JLabel titulonivel = new JLabel("NIVEL DEL DEP覵ITO:") ;
		titulonivel.setFont(new Font("Liberation Sans", Font.BOLD, 20)) ;
		titulonivel.setBounds(20, 12, 230, 25) ;
		add(titulonivel) ;
		
		porcentajedeposito = new JLabel() ;
		porcentajedeposito.setHorizontalAlignment(SwingConstants.CENTER);
		add(porcentajedeposito);
		porcentajedeposito.setFont(new Font("Liberation Sans", Font.BOLD, 20)) ;
		porcentajedeposito.setBounds(85, 44, 90, 25) ;
		
		niveldeposito = new JProgressBar(0, TOPEDEPOSITO) ;
		niveldeposito.setForeground(new Color(0, 0, 255)) ;
		niveldeposito.setOrientation(SwingConstants.VERTICAL) ;
		niveldeposito.setBounds(85, 81, 90, 110) ;
		add(niveldeposito) ;
		
		gastomedio = new JLabel("") ;
		gastomedio.setBorder(new LineBorder(new Color(0, 0, 0)));
		gastomedio.setFont(new Font("Liberation Sans", Font.BOLD, 15)) ;
		gastomedio.setBounds(12, 207, 238, 30) ;
		add(gastomedio) ;
	}
	
	// Realiza las tareas peri贸dicas asociadas a este panel, actualizando las etiquetas y variando 
	// progresivamente el color (de azul a rojo) de la barra de progreso 
	
	public synchronized void accionesPeriodicas(){
		double porcentaje = (double) observadordeposito.getNivelDeposito() / TOPEDEPOSITO ;
		porcentajedeposito.setText(String.format("%.2f", porcentaje * 100) + "%") ;
		
		niveldeposito.setValue(observadordeposito.getNivelDeposito()) ;
		niveldeposito.setForeground(new Color(255 - (int) (255 * porcentaje), 0, (int) (255 * porcentaje))) ;
		gastomedio.setText(" GASTO MEDIO:  " + String.format("%.5f", observadordeposito.getGastoMedio()) + " litros/h") ;
	}
}
