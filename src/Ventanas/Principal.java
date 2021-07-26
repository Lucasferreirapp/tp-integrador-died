package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Principal extends JFrame{

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
		
		JButton estaciones = estacionesPantalla.armarBoton(app);
		JButton lineas = lineasPantalla.armarBoton(app);
		JButton boletos = boletosPantalla.armarBoton(app);
		
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
	
	/*public void armarVentana(App app) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		this.estaciones = new JButton("Estaciones");
		this.lineas = new JButton("Linea de transporte");
		this.boletos = new JButton("Boletos");
		Estaciones estacionesPantalla = new Estaciones();
		
		gbc1.weighty = 0.1;
		gbc1.anchor = GridBagConstraints.SOUTHWEST;
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		panel.add(estaciones, gbc1);
		
		gbc1.anchor = GridBagConstraints.WEST;
		gbc1.gridx = 0;
		gbc1.gridy = 1;
		panel.add(lineas, gbc1);
		
		gbc1.anchor = GridBagConstraints.NORTHWEST;
		gbc1.gridx = 0;
		gbc1.gridy = 2;
		panel.add(boletos, gbc1);
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	
		estaciones.addActionListener(e -> {
			estacionesPantalla.armarVentana(app);
			this.revalidate();
			this.repaint();
		});
	
	
	}*/	
	
}
