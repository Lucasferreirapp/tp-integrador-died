package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Principal extends JPanel {

	private JButton estaciones;
	private JButton lineas;
	private JButton boletos;
	private GridBagConstraints gbc;
	
	public Principal() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	public Principal armarVentana() {
		this.setBackground(Color.LIGHT_GRAY);
		estaciones = new JButton("Estaciones");
		lineas = new JButton("Linea de transporte");
		boletos = new JButton("Boletos");
		
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(estaciones, gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(lineas, gbc);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(boletos, gbc);
		
		return this;
	}
	
	
	
}
