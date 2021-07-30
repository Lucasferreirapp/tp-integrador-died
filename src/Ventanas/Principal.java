package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Principal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbcPrincipal;
	
	public Principal() {
		this.gbcPrincipal = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	public void armarVentanaPrincipal(App app) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		Estaciones estacionesPantalla = new Estaciones();
		Lineas lineasPantalla = new Lineas();
		Boletos boletosPantalla = new Boletos();
		
		JButton estaciones = estacionesPantalla.armarBotonEstaciones(app);
		JButton lineas = lineasPantalla.armarBotonLineas(app);
		JButton boletos = boletosPantalla.armarBotonBoletos(app);
		
		gbcPrincipal.anchor = GridBagConstraints.SOUTHWEST;
		gbcPrincipal.gridx = 0;
		gbcPrincipal.gridy = 0;
		gbcPrincipal.weighty = 1.0;
		panel.add(estaciones, gbcPrincipal);
		
		gbcPrincipal.anchor = GridBagConstraints.WEST;
		gbcPrincipal.gridx = 0;
		gbcPrincipal.gridy = 1;
		gbcPrincipal.weighty = 1.0;
		panel.add(lineas, gbcPrincipal);
		
		gbcPrincipal.anchor = GridBagConstraints.NORTHWEST;
		gbcPrincipal.gridx = 0;
		gbcPrincipal.gridy = 2;
		gbcPrincipal.weighty = 1.0;
		panel.add(boletos, gbcPrincipal);
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	}
	
}
