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

public class Registracion extends JPanel{
	
	private JLabel labelUsuario;
	private JLabel labelContrase�a;
	private JLabel labelMostrar;
	private JTextField textUsuario;
	private JPasswordField textContrase�a;
	private JCheckBox habilitar;
	private GridBagConstraints gbc;
	private JLabel labelIngresar;
	private JButton ingresar;
	private JButton salir;
	
	public Registracion() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	public Registracion armarVentana() {
		this.setBackground(Color.LIGHT_GRAY);
		this.labelUsuario = new JLabel("Usuario"); 
		this.labelContrase�a = new JLabel("Contrase�a"); 
		this.labelMostrar = new JLabel("Mostrar contrase�a");
		this.textUsuario = new JTextField(20);
		this.textContrase�a = new JPasswordField(20);
		this.habilitar = new JCheckBox();
		this.labelIngresar = new JLabel("Iniciar sesi�n");
		this.ingresar = new JButton("Ingresar");
		this.salir = new JButton("Salir");
		
	
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipady = 20;
		this.add(labelIngresar, gbc);
		gbc.ipady = 0;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 10;
		this.add(labelUsuario, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(textUsuario, gbc);
		

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labelContrase�a, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(textContrase�a, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.ipadx = 0;
		this.add(habilitar, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		this.add(labelMostrar, gbc);
	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(salir, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 3;
		gbc.gridy = 3;
		this.add(ingresar, gbc);
		
		return this;
		
	}
}

