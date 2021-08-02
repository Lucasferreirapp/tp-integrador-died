package Ventanas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.Ellipse2D;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.BoletosService;
import Logica.EstacionesService;
import Logica.TrayectoService;

public class Boletos extends JFrame{

	private GridBagConstraints gbcBoletos;
	EstacionesService es = new EstacionesService();
	BoletosService bs = new BoletosService();
	TrayectoService ty = new TrayectoService();
	
	
	public Boletos() {
		this.gbcBoletos = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	public JButton armarBotonBoletos(App app) {
		JButton boletos = new JButton("Boletos");
		JPanel panel = new JPanel(new GridBagLayout());
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 0;
		panel.add(boletos, gbcBoletos);
		
		boletos.addActionListener(e -> {
		this.armarVentanaBoletos(app);
		this.revalidate();
		this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
		return boletos;
	}
	
	public void armarVentanaBoletos(App app) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel origen = new JLabel("Estacion Origen");
		JLabel destino = new JLabel("Estacion Destino");
		JLabel camino = new JLabel("Elegir Camino");
		JComboBox origencombo = new JComboBox();
		JComboBox destinocombo = new JComboBox();
		JComboBox caminocombo = new JComboBox();
		
		
		for(int i=0; i<es.estacionesId().size(); i++) {
			origencombo.addItem(es.estacionesId().get(i));
		}
		for(int i=0; i<es.estacionesId().size(); i++) {
			destinocombo.addItem(es.estacionesId().get(i));
		}
		caminocombo.addItem(CaminoTipo.CaminoMasRapido);
		caminocombo.addItem(CaminoTipo.CaminoMasBarato);
		caminocombo.addItem(CaminoTipo.CaminoDeMenorDistancia);
		
		JButton siguiente = new JButton("Siguiente");
		JButton atras = new JButton("Atras");
		//JButton grafico = new JButton("Mostrar trayectos");
		
		Principal prin = new Principal();
		
		atras.addActionListener(e -> {
			prin.armarVentanaPrincipal(app);
			this.revalidate();
			this.repaint();
		});
		
		siguiente.addActionListener(e -> {
			this.datos(app, Integer.parseInt(origencombo.getSelectedItem().toString()), Integer.parseInt(destinocombo.getSelectedItem().toString()));
			this.revalidate();
			this.repaint();
		});
		
		/*grafico.addActionListener(e -> {
			this.dibujar(app);
			this.revalidate();
			this.repaint();
		});*/
		
		
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 0;
		gbcBoletos.ipadx = 10;
		panel.add(origen, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 0;
		panel.add(origencombo, gbcBoletos);
		
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 1;
		gbcBoletos.ipadx = 10;
		panel.add(destino, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 1;
		panel.add(destinocombo, gbcBoletos);
		
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 2;
		gbcBoletos.ipadx = 10;
		panel.add(camino, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 2;
		panel.add(caminocombo, gbcBoletos);
		
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 3;
		panel.add(atras, gbcBoletos);
		
		/*gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 3;
		panel.add(grafico, gbcBoletos);*/
		
		gbcBoletos.gridx = 2;
		gbcBoletos.gridy = 3;
		panel.add(siguiente, gbcBoletos);
		gbcBoletos.weightx = 1.0;
		
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
	public void datos(App app, Integer ori, Integer des) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel nroBoleto = new JLabel("Número de Boleto");
		JLabel fecha = new JLabel("Fecha");
		JLabel nombre = new JLabel("Nombre");
		JLabel correo = new JLabel("Correo");
		JLabel origen = new JLabel("Origen");
		JLabel destino = new JLabel("Destino");
		JLabel trayecto = new JLabel("Trayecto");
		JLabel costo = new JLabel("Costo");
		JTextField boletotexto = new JTextField(5);
		JTextField fechatexto = new JTextField(20);
		JTextField nombretexto = new JTextField(20);
		JTextField correotexto = new JTextField(20);
		JTextField origentexto = new JTextField(5);
		JTextField destinotexto = new JTextField(5);
		JComboBox<Integer> trayectocombo = new JComboBox<Integer>();
		
		for(int i=0; i<ty.trayectosId().size(); i++) {
			if(ty.trayectosId().get(i) != 0) trayectocombo.addItem(ty.trayectosId().get(i));
		}
		
		JTextField costotexto = new JTextField(20);
		JButton atras = new JButton("Atras");
		JButton aceptar = new JButton("Aceptar");
		
	
		origentexto.setText(ori.toString());
		origentexto.setEnabled(false);
		destinotexto.setText(des.toString());
		destinotexto.setEnabled(false);
		
		atras.addActionListener(e -> {
			this.armarVentanaBoletos(app);
			this.revalidate();
			this.repaint();
		});
		
		Principal prin = new Principal();
		
		aceptar.addActionListener(e -> {
			if(!boletotexto.getText().isEmpty() && !fechatexto.getText().isEmpty() && !nombretexto.getText().isEmpty() && !correotexto.getText().isEmpty()
					&& !trayectocombo.getSelectedItem().toString().isEmpty() && !costotexto.getText().isEmpty()) {
				
					try {
						bs.nuevoBoleto(Integer.parseInt(boletotexto.getText()), fechatexto.getText(), nombretexto.getText(), correotexto.getText(), ori, des, Integer.parseInt(trayectocombo.getSelectedItem().toString()), Double.parseDouble(costotexto.getText()));
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Se ha generado un nuevo boleto");
					prin.armarVentanaPrincipal(app);
					this.revalidate();
					this.repaint();
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.datos(app, ori, des);
				this.revalidate();
				this.repaint();
			}
		});
		
		gbcBoletos.weightx = 1.0;
		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 0;
		gbcBoletos.ipadx = 10;
		panel.add(nroBoleto, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 0;
		panel.add(boletotexto, gbcBoletos);

		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 2;
		gbcBoletos.gridy = 0;
		gbcBoletos.ipadx = 10;
		panel.add(fecha, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 3;
		gbcBoletos.gridy = 0;
		panel.add(fechatexto, gbcBoletos);
		
		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 1;
		gbcBoletos.ipadx = 10;
		panel.add(nombre, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 1;
		panel.add(nombretexto, gbcBoletos);
		
		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 2;
		gbcBoletos.gridy = 1;
		gbcBoletos.ipadx = 10;
		panel.add(correo, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 3;
		gbcBoletos.gridy = 1;
		panel.add(correotexto, gbcBoletos);
		
		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 2;
		gbcBoletos.ipadx = 10;
		panel.add(origen, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 2;
		panel.add(origentexto, gbcBoletos);
		
		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 2;
		gbcBoletos.gridy = 2;
		gbcBoletos.ipadx = 10;
		panel.add(destino, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 3;
		gbcBoletos.gridy = 2;
		panel.add(destinotexto, gbcBoletos);
	
		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 0;
		gbcBoletos.gridy = 3;
		gbcBoletos.ipadx = 10;
		panel.add(trayecto, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 3;
		panel.add(trayectocombo, gbcBoletos);
		
		gbcBoletos.anchor = GridBagConstraints.EAST;
		gbcBoletos.gridx = 2;
		gbcBoletos.gridy = 3;
		gbcBoletos.ipadx = 10;
		panel.add(costo, gbcBoletos);
		gbcBoletos.ipadx = 0;
		
		gbcBoletos.anchor = GridBagConstraints.WEST;
		gbcBoletos.gridx = 3;
		gbcBoletos.gridy = 3;
		panel.add(costotexto, gbcBoletos);
		
		//gbcBoletos.weighty = 1.0;
		gbcBoletos.gridx = 1;
		gbcBoletos.gridy = 4;
		panel.add(atras, gbcBoletos);
		
		gbcBoletos.gridx = 3;
		gbcBoletos.gridy = 4;
		panel.add(aceptar, gbcBoletos);
		gbcBoletos.weightx = 0.0;
		//gbcBoletos.weighty = 0.0;

		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	}

	public void dibujar(App app) {
		JFrame ventana = new JFrame("Figuras");
		ventana.setBounds(0, 0, 1000, 800);
		ventana.setDefaultCloseOperation(HIDE_ON_CLOSE);
		ventana.setContentPane(new Grafico());
		ventana.setVisible(true);
	}
}
