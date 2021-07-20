package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Principal extends JFrame{

	private GridBagConstraints gbc1;
	
	private JButton estaciones;
	private JButton lineas;
	private JButton boletos;
	private Estaciones estacionesPantalla;
	
	public Principal() {
		this.gbc1 = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	public void armarVentana(App app) {
		Estaciones estacionesPantalla = new Estaciones();
		
		estacionesPantalla.armarBoton(app);
		this.revalidate();
		this.repaint();
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
