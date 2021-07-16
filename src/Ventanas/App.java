package Ventanas;

import javax.swing.JFrame;

public class App {
	
	public static void main(String[] args) {
	
		JFrame window = new JFrame();
		window.setContentPane(new Registracion().armarVentana());
		window.setTitle("Principal");
		window.setSize(800, 800);
		window.setVisible(true);
		
		
		
		
	}
}

