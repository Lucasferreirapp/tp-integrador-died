package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lineas extends JFrame{
	
	private GridBagConstraints gbcLineas;
	
	public Lineas() {
		this.gbcLineas = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	public void armarBoton(App app) {
		JButton lineas = new JButton("Lineas");
		JPanel panel = new JPanel(new GridBagLayout());
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 0;
		panel.add(lineas, gbcLineas);
		
		lineas.addActionListener(e -> {
		this.armarVentanaLineas(app);
		this.revalidate();
		this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	}
	
public void armarVentanaLineas(App app) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel nombre = new JLabel("Nombre");
		JLabel color = new JLabel("Color");
		JLabel estado = new JLabel("Estado");
		JTextField nombretexto = new JTextField(20);
		JTextField colortexto = new JTextField(10);
		JComboBox estadocombo = new JComboBox();
		estadocombo.addItem("Activa");
		estadocombo.addItem("No Activa");
		JButton alta = new JButton("Dar de Alta");
		JButton busqueda = new JButton("Buscar");
		JButton atras = new JButton("Atras");
		
		
		atras.addActionListener(e -> {
			this.armarBoton(app);
			this.revalidate();
			this.repaint();
		});
		
		gbcLineas.anchor = GridBagConstraints.WEST;
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 0;
		gbcLineas.ipadx = 10;
		panel.add(nombre, gbcLineas);
		gbcLineas.ipadx = 0;
		
		gbcLineas.gridx = 1;
		gbcLineas.gridy = 0;
		panel.add(nombretexto, gbcLineas);
		
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 1;
		gbcLineas.ipadx = 10;
		panel.add(color, gbcLineas);
		gbcLineas.ipadx = 0;
		
		gbcLineas.gridx = 1;
		gbcLineas.gridy = 1;
		panel.add(colortexto, gbcLineas);
		
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 2;
		gbcLineas.ipadx = 10;
		panel.add(estado, gbcLineas);
		gbcLineas.ipadx = 0;
		
		gbcLineas.gridx = 1;
		gbcLineas.gridy = 2;
		panel.add(estadocombo, gbcLineas);
		
		gbcLineas.anchor = GridBagConstraints.WEST;
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 3;
		gbcLineas.ipadx = 10;
		panel.add(atras, gbcLineas);
		gbcLineas.ipadx = 0;
		
		gbcLineas.anchor = GridBagConstraints.EAST;
		gbcLineas.gridx = 1;
		gbcLineas.gridy = 3;
		panel.add(alta, gbcLineas);
		

		gbcLineas.gridx = 2;
		gbcLineas.gridy = 3;
		panel.add(busqueda, gbcLineas);
		
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}

}
