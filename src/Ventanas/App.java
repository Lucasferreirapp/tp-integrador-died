package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App extends JFrame{
	
	private GridBagConstraints gbc;	
		
	private JLabel labelUsuario;
	private JLabel labelContraseña;
	private JTextField textoUsuario;
	private JPasswordField textoContraseña;	
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
			this.labelContraseña = new JLabel("Contraseña"); 
			this.textoUsuario = new JTextField(20);
			this.textoContraseña = new JPasswordField(20);
			this.labelIngresar = new JLabel("Iniciar sesión");
			this.ingresar = new JButton("Ingresar");
			Principal prin = new Principal();
			JLabel aviso = new JLabel("Usuario: Admin, Contraseña:admin");
		
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			//gbc.anchor = GridBagConstraints.CENTER;
			this.add(aviso, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.ipady = 20;
			this.add(labelIngresar, gbc);
			gbc.ipady = 0;
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.ipadx = 10;
			this.add(labelUsuario, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			this.add(textoUsuario, gbc);
			

			gbc.gridx = 0;
			gbc.gridy = 3;
			this.add(labelContraseña, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 3;
			this.add(textoContraseña, gbc);
				
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridwidth = 2;
			gbc.gridx = 0;
			gbc.gridy = 4;
			this.add(ingresar, gbc);
			
			
			ingresar.addActionListener(e -> {
				if(textoUsuario.getText().contentEquals("Admin") && 
				textoContraseña.getText().contains("admin")) {
				prin.armarVentanaPrincipal(this);
				this.revalidate();
				this.repaint();
				}
				else JOptionPane.showMessageDialog(null, "Datos incorrectos");
			});
			
		
		}
			
		
	public static void main(String[] args) {
			App app = new App();
			app.correrApp();
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setTitle("Tp-Died");
			app.setSize(1280,720);
			app.setVisible(true);
		}
	
}
		
	
	

