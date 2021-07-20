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

public class Boletos extends JFrame{

	private GridBagConstraints gbcBoletos;
	
	
	public Boletos() {
		this.gbcBoletos = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	
	public void armarBoton(App app) {
		JButton boletos = new JButton("Boletos");
		JPanel panel = new JPanel(new GridBagLayout());
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 0;
		panel.add(boletos, gbcBoletos);
		
		/*boletos.addActionListener(e -> {
		this.armarVentanaBoletos(app);
		this.revalidate();
		this.repaint();
		});*/
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	}
	
	/*public void armarVentanaEstaciones(App app) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel id = new JLabel("Id");
		JLabel nombre = new JLabel("Nombre");
		JLabel apertura = new JLabel("Horario de Apertura");
		JLabel cierre = new JLabel("Horario de Cierre");
		JLabel estado = new JLabel("Estado");
		JTextField idtexto = new JTextField(2);
		JTextField nombretexto = new JTextField(20);
		JTextField aperturatexto = new JTextField(10);
		JTextField cierretexto = new JTextField(10);
		JComboBox estadocombo = new JComboBox();
		estadocombo.addItem("Activa");
		estadocombo.addItem("Mantenimiento");
		JButton alta = new JButton("Dar de Alta");
		JButton busqueda = new JButton("Buscar");
		JButton atras = new JButton("Atras");
		
		
		atras.addActionListener(e -> {
			this.armarBoton(app);
			this.revalidate();
			this.repaint();
		});
		
		gbcEstaciones.anchor = GridBagConstraints.WEST;
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 0;
		gbcEstaciones.ipadx = 10;
		panel.add(id, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 0;
		panel.add(idtexto, gbcEstaciones);
		
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 1;
		gbcEstaciones.ipadx = 10;
		panel.add(nombre, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 1;
		panel.add(nombretexto, gbcEstaciones);
		
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 2;
		gbcEstaciones.ipadx = 10;
		panel.add(apertura, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 2;
		panel.add(aperturatexto, gbcEstaciones);
		
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 3;
		gbcEstaciones.ipadx = 10;
		panel.add(cierre, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 3;
		panel.add(cierretexto, gbcEstaciones);
		

		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 4;
		gbcEstaciones.ipadx = 10;
		panel.add(estado, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 4;
		panel.add(estadocombo, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.WEST;
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 5;
		panel.add(atras, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.EAST;
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 5;
		panel.add(alta, gbcEstaciones);
		
		gbcEstaciones.gridx = 2;
		gbcEstaciones.gridy = 5;
		panel.add(busqueda, gbcEstaciones);
		
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}*/
}
