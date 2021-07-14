package TpIntegradorDied;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ventanas extends JFrame{
	
	private JPanel panel = new JPanel();
	
	public ventanas () {
	
	JFrame ventana = new JFrame();
	panel = new JPanel();
	ventana.setTitle("Registracion");
	ventana.setSize(1280, 720);
	JLabel labelUsuario = new JLabel("Usuario"); 
	JLabel labelContraseña = new JLabel("Contraseña"); 
	JTextField textUsuario = new JTextField();
	JTextField textContraseña = new JTextField();

	panel.add(labelUsuario);
	panel.add(labelContraseña);
	panel.add(textUsuario);
	panel.add(textContraseña);
	
	ventana.getContentPane().setLayout(new GridBagLayout());
	
	GridBagConstraints constraints = new GridBagConstraints ();
	
	constraints.gridx = 3 ; 
	constraints.gridy = 3 ; 
	
	ventana.getContentPane().add(panel,constraints);
	
	

	//ventana.add(labelContraseña);
	
	/*
	
	*/
	
	//ventana.setContentPane(panel);
	ventana.setVisible(true);
	}
}
