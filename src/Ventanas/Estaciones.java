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

public class Estaciones extends JFrame{

	private JLabel id;
	private JLabel nombre;
	private JLabel apertura;
	private JLabel cierre;
	private JLabel estado;
	private JTextField idtext;
	private JTextField nombretext;
	private JTextField aperturatext;
	private JTextField cierretext;
	private JComboBox estadocombo;
	private JButton alta;
	private JButton busqueda;
	private JButton atras;
	private GridBagConstraints gbc2;
	
	
	public Estaciones() {
		this.gbc2 = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	
	public void armarBoton(App app) {
		JButton estaciones = new JButton("Estaciones");
		JPanel panel = new JPanel(new GridBagLayout());
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		panel.add(estaciones, gbc2);
		
		estaciones.addActionListener(e -> {
		this.armarVentana(app);
		this.revalidate();
		this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	}
	
	public void armarVentana(App app) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		this.id = new JLabel("Id");
		this.nombre = new JLabel("Nombre");
		this.apertura = new JLabel("Horario de Apertura");
		this.cierre = new JLabel("Horario de Cierre");
		this.estado = new JLabel("Estado");
		this.idtext = new JTextField(2);
		this.nombretext = new JTextField(20);
		this.aperturatext = new JTextField(10);
		this.cierretext = new JTextField(10);
		this.estadocombo = new JComboBox();
		this.estadocombo.addItem("Ativa");
		this.estadocombo.addItem("Mantenimiento");
		this.alta = new JButton("Dar de Alta");
		this.busqueda = new JButton("Buscar");
		this.atras = new JButton("Atras");
		
		
		atras.addActionListener(e -> {
			this.armarBoton(app);
			//this.revalidate();
			//this.repaint();
		});
		
		gbc2.anchor = GridBagConstraints.WEST;
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.ipadx = 10;
		panel.add(id, gbc2);
		gbc2.ipadx = 0;
		
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		panel.add(idtext, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.ipadx = 10;
		panel.add(nombre, gbc2);
		gbc2.ipadx = 0;
		
		gbc2.gridx = 1;
		gbc2.gridy = 1;
		panel.add(nombretext, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 2;
		gbc2.ipadx = 10;
		panel.add(apertura, gbc2);
		gbc2.ipadx = 0;
		
		gbc2.gridx = 1;
		gbc2.gridy = 2;
		panel.add(aperturatext, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 3;
		gbc2.ipadx = 10;
		panel.add(cierre, gbc2);
		gbc2.ipadx = 0;
		
		gbc2.gridx = 1;
		gbc2.gridy = 3;
		panel.add(cierretext, gbc2);
		

		gbc2.gridx = 0;
		gbc2.gridy = 4;
		gbc2.ipadx = 10;
		panel.add(estado, gbc2);
		gbc2.ipadx = 0;
		
		gbc2.gridx = 1;
		gbc2.gridy = 4;
		panel.add(estadocombo,gbc2);
		
		gbc2.anchor = GridBagConstraints.WEST;
		gbc2.gridx = 0;
		gbc2.gridy = 5;
		panel.add(atras, gbc2);
		
		gbc2.anchor = GridBagConstraints.EAST;
		gbc2.gridx = 1;
		gbc2.gridy = 5;
		panel.add(alta, gbc2);
		
		gbc2.gridx = 2;
		gbc2.gridy = 5;
		panel.add(busqueda, gbc2);
		
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
	
	
}
