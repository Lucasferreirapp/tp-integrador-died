package Ventanas;

import javax.swing.JFrame;

public class PruebaGrafico{

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Figuras");
		ventana.setBounds(0, 0, 1000, 800);
		ventana.setContentPane(new Grafico());
		ventana.setVisible(true);
	}
	
}
