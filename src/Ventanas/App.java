package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App extends JFrame{
	
	private GridBagConstraints gbc;	
		
	private JLabel labelUsuario;
	private JLabel labelContrase�a;
	private JLabel labelMostrar;
	private JTextField textoUsuario;
	private JPasswordField textoContrase�a;
	private JCheckBox habilitar;	
	private JLabel labelIngresar;
	private JButton ingresar;
	public Principal prin;
		
		public App() {
			this.gbc = new GridBagConstraints();
			this.setLayout(new GridBagLayout());
		}
		
		public void correrApp() {
			this.setBackground(Color.LIGHT_GRAY);
			this.labelUsuario = new JLabel("Usuario"); 
			this.labelContrase�a = new JLabel("Contrase�a"); 
			this.labelMostrar = new JLabel("Mostrar contrase�a");
			this.textoUsuario = new JTextField(20);
			this.textoContrase�a = new JPasswordField(20);
			this.habilitar = new JCheckBox();
			this.labelIngresar = new JLabel("Iniciar sesi�n");
			this.ingresar = new JButton("Ingresar");
			Principal prin = new Principal();
			
		
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
			this.add(textoUsuario, gbc);
			

			gbc.gridx = 0;
			gbc.gridy = 2;
			this.add(labelContrase�a, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.add(textoContrase�a, gbc);
			
			gbc.gridx = 2;
			gbc.gridy = 2;
			gbc.ipadx = 0;
			this.add(habilitar, gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 2;
			this.add(labelMostrar, gbc);
			
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridwidth = 2;
			gbc.gridx = 0;
			gbc.gridy = 3;
			this.add(ingresar, gbc);
			
			ingresar.addActionListener(e -> {
				prin.armarVentanaPrincipal(this);
				this.revalidate();
				this.repaint();
			});
			
		
		}
		
		
	public static void main(String[] args) {
			App app = new App();
			app.correrApp();
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setTitle("Nombre app");
			app.setSize(800,800);
			app.setVisible(true);
		}
	
}
		
		
	

