package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Logica.EstacionesService;
import Logica.LineasService;
import Logica.TrayectoService;

public class Lineas extends JFrame{

	
	private GridBagConstraints gbcLineas;
	LineasService ls = new LineasService();
	TrayectoService ts = new TrayectoService();
	String nom = null;
	String col = null;
	String est = null;
	Integer tray = 0;
	
	
	public Lineas() {
		this.gbcLineas = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	
	public JButton armarBotonLineas(App app) {
		JButton lineas = new JButton("Lineas");
		JPanel panel = new JPanel(new GridBagLayout());
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 0;
		panel.add(lineas, gbcLineas);
		
		lineas.addActionListener(e -> {
		this.armarBusquedaLineas(app);
		this.revalidate();
		this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
		return lineas;
	}
		 
	public void armarNuevaLinea(App app) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel nombre = new JLabel("Nombre");
		JLabel color = new JLabel("Color");
		JLabel estado = new JLabel("Estado");
		JTextField nombretexto = new JTextField(20);
		JTextField colortexto = new JTextField(10);
		JTextField estadotexto = new JTextField("Activa");
		JButton alta = new JButton("Dar de Alta");
		JButton atras = new JButton("Atras");
	
		
		atras.addActionListener(e -> {
			this.armarBusquedaLineas(app);
			this.revalidate();
			this.repaint();
		});
		
		alta.addActionListener(e -> {
			if(!nombretexto.getText().isEmpty() && !colortexto.getText().isEmpty() && !estadotexto.getText().isEmpty()){
				
				try {
					ls.darDeAltaLinea(nombretexto.getText(), colortexto.getText(), estadotexto.getText(), 0);
					JOptionPane.showMessageDialog(null, "Linea cargada correctamente");
					this.armarBusquedaLineas(app);
					this.revalidate();
					this.repaint();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
					this.armarNuevaLinea(app);
					this.revalidate();
					this.repaint();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarNuevaLinea(app);
				this.revalidate();
				this.repaint();
			}
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
		panel.add(estadotexto, gbcLineas);
		
		
		gbcLineas.anchor = GridBagConstraints.WEST;
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 5;
		panel.add(atras, gbcLineas);
		
		gbcLineas.anchor = GridBagConstraints.EAST;
		gbcLineas.gridx = 1;
		gbcLineas.gridy = 5;
		panel.add(alta, gbcLineas);
		
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
	private JTable dibujarTablaLineas(App app) {
	
	DefaultTableModel modelo = new DefaultTableModel();	
	
	modelo.addColumn("Nombre");
	modelo.addColumn("Color");
	modelo.addColumn("Estado");
	modelo.addColumn("Trayecto");
	
	JTable tablaLineas = new JTable(modelo);
	
	/*TableRowSorter<TableModel> ordenador=new TableRowSorter<TableModel>(modelo);
	tablaPlantas.setRowSorter(ordenador);*/
	
	TableColumnModel modeloColumna = tablaLineas.getColumnModel();
	modeloColumna.getColumn(0).setPreferredWidth(240);
	modeloColumna.getColumn(1).setPreferredWidth(240);
	modeloColumna.getColumn(2).setPreferredWidth(240);
	modeloColumna.getColumn(3).setPreferredWidth(45);
	
	
	try {
		ls.buscarLineas(modelo);
	} catch(NullPointerException e) {
		System.out.println(e);
	}

	
		ListSelectionModel seleccion = tablaLineas.getSelectionModel();
		seleccion.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				
				if(e.getValueIsAdjusting()) return; 
				
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if(!lsm.isSelectionEmpty()) { 
						nom = ((String)modelo.getValueAt(lsm.getMaxSelectionIndex(), 0));
						col = ((String)modelo.getValueAt(lsm.getMaxSelectionIndex(), 1));
						est = ((String)modelo.getValueAt(lsm.getMaxSelectionIndex(), 2));
						tray = ((Integer)modelo.getValueAt(lsm.getMaxSelectionIndex(), 3));
					}
				}
		});
		
	return tablaLineas;
}

	public void armarBusquedaLineas(App app) {
	JPanel panel = new JPanel(new GridBagLayout());
	panel.setBackground(Color.LIGHT_GRAY);
	JScrollPane scrollEstaciones=new JScrollPane();
	JButton atras = new JButton("Atras");
	JButton editar = new JButton("Editar");
	JButton eliminar = new JButton("Eliminar");
	JTable tablaEstaciones = this.dibujarTablaLineas(app);
	scrollEstaciones.setViewportView(tablaEstaciones);
	JButton alta = new JButton("Nueva linea");

	gbcLineas.gridx = 0;
	gbcLineas.gridy = 0;
	gbcLineas.gridwidth = 4;
	gbcLineas.gridheight = 1;
	gbcLineas.fill = GridBagConstraints.HORIZONTAL;
	gbcLineas.weightx = 1.0;
	panel.add(scrollEstaciones, gbcLineas);
	gbcLineas.weightx = 0.0;
	gbcLineas.gridwidth = 1;
	gbcLineas.fill = GridBagConstraints.NONE;
	
	gbcLineas.weightx = 1.0;
	gbcLineas.weighty = 1.0;
	gbcLineas.gridx = 0;
	gbcLineas.gridy = 1;
	panel.add(atras, gbcLineas);

	gbcLineas.gridx = 1;
	gbcLineas.gridy = 1;
	panel.add(alta, gbcLineas);
	
	gbcLineas.gridx = 2;
	gbcLineas.gridy = 1;
	panel.add(eliminar, gbcLineas);

	gbcLineas.gridx = 3;
	gbcLineas.gridy = 1;
	panel.add(editar, gbcLineas);
	gbcLineas.weightx = 0.0;
	gbcLineas.weighty = 0.0;
	gbcLineas.anchor = GridBagConstraints.CENTER;
	
	Principal prin = new Principal();
	
	atras.addActionListener(e -> {
		prin.armarVentanaPrincipal(app);
		this.revalidate();
		this.repaint();
	});
	
	alta.addActionListener(e -> {
		this.armarNuevaLinea(app);
		this.revalidate();
		this.repaint();
	});
	
	eliminar.addActionListener(f -> { 
		//aviso.showConfirmDialog(null, "Seguro que quiere eliminar la estacion seleccionada?");
		try {
			ls.eliminarLinea(nom);
			this.armarBusquedaLineas(app);
			this.revalidate();
			this.repaint();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	editar.addActionListener(f -> {
		this.armarEdicionLineas(app, nom, col, est, tray);
		this.revalidate();
		this.repaint();
});
	
	app.setContentPane(panel);
	app.revalidate();
	app.repaint();
	
}

	public void armarEdicionLineas(App app, String nom, String col, String est, Integer tray) {
	
	JPanel panel = new JPanel(new GridBagLayout());
	panel.setBackground(Color.LIGHT_GRAY);
	JLabel nombre = new JLabel("Nombre");
	JLabel color = new JLabel("Color");
	JLabel estado = new JLabel("Estado");
	JTextField nombretexto = new JTextField(20);
	JTextField colortexto = new JTextField(10);
	JComboBox<EstadoLinea> estadocombo = new JComboBox<EstadoLinea>();
	estadocombo.addItem(EstadoLinea.Activa);
	estadocombo.addItem(EstadoLinea.NoActiva);
	JButton cancelar = new JButton("Cancelar");
	JButton aceptar = new JButton("Aceptar");
	JButton trayecto = new JButton("Definir trayecto");

	nombretexto.setText(nom);
	nombretexto.setEditable(false);
	colortexto.setText(col);
	
	cancelar.addActionListener(e -> {
		this.armarBusquedaLineas(app);
		this.revalidate();
		this.repaint();
	});
	
	trayecto.addActionListener(e -> {
		this.definirTrayecto(app, nombretexto.getText(), colortexto.getText(), estadocombo.getSelectedItem().toString(), tray);
		this.revalidate();
		this.repaint();
	});
	
	aceptar.addActionListener(e -> {
		if(!nombretexto.getText().isEmpty() && !color.getText().isEmpty()){
			
			JOptionPane.showMessageDialog(null, "Linea editada correctamente");
			try {
				ls.editarLinea(nombretexto.getText(), colortexto.getText(), estadocombo.getSelectedItem().toString(), tray);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.armarBusquedaLineas(app);
			this.revalidate();
			this.repaint();
			}
		
		else {
			JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
			this.armarEdicionLineas(app, nom, col, est, tray);
			this.revalidate();
			this.repaint();
		}
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

	gbcLineas.anchor = GridBagConstraints.CENTER;
	gbcLineas.gridx = 0;
	gbcLineas.gridy = 3;
	panel.add(cancelar, gbcLineas);
	
	gbcLineas.gridx = 1;
	gbcLineas.gridy = 3;
	panel.add(trayecto, gbcLineas);
	
	gbcLineas.gridx = 2;
	gbcLineas.gridy = 3;
	panel.add(aceptar, gbcLineas);
	
	
	app.setContentPane(panel);
	app.revalidate();
	app.repaint();
	
}

	public void definirTrayecto(App app, String nom, String col, String est, Integer trayecto) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollTrayectos=new JScrollPane();
		JTable tablaTrayectos = this.dibujarTablaTrayectos(app);
		scrollTrayectos.setViewportView(tablaTrayectos);
		JButton cancelar = new JButton("Cancelar");
		JButton aceptar = new JButton("Aceptar");
		
		cancelar.addActionListener(e -> {
			this.armarEdicionLineas(app, nom, col, est, trayecto);
			this.revalidate();
			this.repaint();
		});
		
		aceptar.addActionListener(e -> {
			try {
				ls.editarLinea(nom, col, est, tray);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			this.armarBusquedaLineas(app);
			this.revalidate();
			this.repaint();
		});
		
		
		gbcLineas.weightx = 1.0;
		gbcLineas.weighty = 1.0;
		gbcLineas.gridwidth = 2;
		gbcLineas.gridheight = 1;
		gbcLineas.fill = GridBagConstraints.HORIZONTAL;
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 0;
		panel.add(scrollTrayectos, gbcLineas);
		gbcLineas.fill = GridBagConstraints.NONE;
		gbcLineas.gridwidth = 1;
		
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 1;
		panel.add(cancelar, gbcLineas);
		
		gbcLineas.gridx = 1;
		gbcLineas.gridy = 1;
		panel.add(aceptar, gbcLineas);
		gbcLineas.weightx = 0.0;
		gbcLineas.weighty = 0.0;
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	}
	
	private JTable dibujarTablaTrayectos(App app) {
		
		DefaultTableModel modelo = new DefaultTableModel();	
		
		modelo.addColumn("Id Trayecto");
		
		JTable tablaTrayectos = new JTable(modelo);
		
		/*TableRowSorter<TableModel> ordenador=new TableRowSorter<TableModel>(modelo);
		tablaPlantas.setRowSorter(ordenador);*/
		
		TableColumnModel modeloColumna = tablaTrayectos.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(50);
		
		
		
		try {
			ts.buscarTrayectos(modelo);
		} catch(NullPointerException e) {
			System.out.println(e);
		}

		
			ListSelectionModel seleccion = tablaTrayectos.getSelectionModel();
			seleccion.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent e) {
					
					if(e.getValueIsAdjusting()) return; 
					
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if(!lsm.isSelectionEmpty()) { 
							tray = ((Integer)modelo.getValueAt(lsm.getMaxSelectionIndex(), 0));
							System.out.println(tray);
						}
					}
			});
			
		return tablaTrayectos;
	}
}
