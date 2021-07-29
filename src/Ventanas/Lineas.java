package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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

public class Lineas extends JFrame{

	
	private GridBagConstraints gbcLineas;
	JButton editar = new JButton("Editar");
	JButton eliminar = new JButton("Eliminar");
	JButton atras = new JButton("Atras");
	JButton aceptar = new JButton("Aceptar");
	Integer fila =-1;
	
	
	public Lineas() {
		this.gbcLineas = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	
	public JButton armarBoton(App app) {
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
		
		return lineas;
	}
	
	 
	public void armarVentanaLineas(App app) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel nombre = new JLabel("Nombre");
		JLabel color = new JLabel("Color");
		JLabel estado = new JLabel("Estado");
		JTextField nombretexto = new JTextField(20);
		JTextField colortexto = new JTextField(10);
		JTextField estadotexto = new JTextField("Activa");
		//estadocombo.addItem(EstadoEstacion.Operativa);
		//estadocombo.setSelectedIndex(0);
		JButton alta = new JButton("Dar de Alta");
		JButton busqueda = new JButton("Buscar");
		JButton atras = new JButton("Atras");
		JOptionPane aviso = new JOptionPane();
		
		Principal prin = new Principal();
		
		atras.addActionListener(e -> {
			prin.armarVentanaPrincipal(app);
			this.revalidate();
			this.repaint();
		});
		
		alta.addActionListener(e -> {
			if(!nombretexto.getText().isEmpty() && !colortexto.getText().isEmpty()){
				
				aviso.showMessageDialog(null, "Linea cargada correctamente");
				prin.armarVentanaPrincipal(app);
				this.revalidate();
				this.repaint();
			}
			else {
				aviso.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarVentanaLineas(app);
				this.revalidate();
				this.repaint();
			}
		});
		
		busqueda.addActionListener(e -> {
			this.armarBusqueda(app);
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
		panel.add(estadotexto, gbcLineas);
		
		gbcLineas.anchor = GridBagConstraints.WEST;
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 3;
		panel.add(atras, gbcLineas);
		
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
	
	private JTable dibujarTablaLineas(App app) {
		DefaultTableModel modelo = new DefaultTableModel();	
		
		modelo.addColumn("Nombre");
		modelo.addColumn("Color");
		modelo.addColumn("Estado");
		
		JTable tablaLineas = new JTable(modelo);
		
		/*TableRowSorter<TableModel> ordenador=new TableRowSorter<TableModel>(modelo);
		tablaPlantas.setRowSorter(ordenador);*/
		
		TableColumnModel modeloColumna = tablaLineas.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(240);
		modeloColumna.getColumn(1).setPreferredWidth(240);
		modeloColumna.getColumn(2).setPreferredWidth(240);
		
		for (int i=0 ; i<3; i++) {
			Object fila[] = new Object[5];
			fila[0]="C Verde";
			fila[1]="Verde";
			fila[2]= "Activa";
			modelo.addRow(fila);
			};
		
			JOptionPane aviso = new JOptionPane();
			
			ListSelectionModel seleccion = tablaLineas.getSelectionModel();
			seleccion.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent e) {
					
					if(e.getValueIsAdjusting()) return; 
					
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if(!lsm.isSelectionEmpty()) { 
						eliminar.addActionListener(f -> { 
							//aviso.showConfirmDialog(null, "Seguro que quiere eliminar la estacion seleccionada?");
							modelo.removeRow(tablaLineas.getSelectedRow());
						});
						Lineas lin = new Lineas();
						editar.addActionListener(g -> {
							lin.armarEdicionLineas(app);
						});
					}
				}
			});
			
	
		return tablaLineas;
	}
	
	public void armarBusqueda(App app) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollLineas=new JScrollPane();
		JButton atras = new JButton("Atras");
		//JButton editar = new JButton("Editar");
		//JButton eliminar = new JButton("Eliminar");
		JTable tablaLineas = this.dibujarTablaLineas(app);
		scrollLineas.setViewportView(tablaLineas);

	
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 0;
		gbcLineas.gridwidth = 3;
		gbcLineas.gridheight = 1;
		gbcLineas.fill = GridBagConstraints.HORIZONTAL;
		gbcLineas.weightx = 1.0;
		panel.add(scrollLineas, gbcLineas);
		gbcLineas.weightx = 0.0;
		gbcLineas.gridwidth = 1;
		gbcLineas.fill = GridBagConstraints.NONE;
		
		gbcLineas.weightx = 1.0;
		gbcLineas.weighty = 1.0;
		gbcLineas.anchor = GridBagConstraints.WEST;
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 1;
		panel.add(atras, gbcLineas);
		
		gbcLineas.anchor = GridBagConstraints.EAST;
		gbcLineas.gridx = 1;
		gbcLineas.gridy = 1;
		panel.add(editar, gbcLineas);
		
		gbcLineas.anchor = GridBagConstraints.WEST;
		gbcLineas.gridx = 2;
		gbcLineas.gridy = 1;
		panel.add(eliminar, gbcLineas);
		gbcLineas.weightx = 0.0;
		gbcLineas.weighty = 0.0;
		gbcLineas.anchor = GridBagConstraints.NONE;
		
		
		atras.addActionListener(e -> {
			this.armarVentanaLineas(app);
			this.revalidate();
			this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
	public void armarEdicionLineas(App app) {
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel nombre = new JLabel("Nombre");
		JLabel color = new JLabel("Color");
		JLabel estado = new JLabel("Estado");
		JTextField nombretexto = new JTextField(20);
		JTextField colortexto = new JTextField(10);
		JComboBox estadocombo = new JComboBox();
		estadocombo.addItem(EstadoLinea.Activa);
		estadocombo.addItem(EstadoLinea.NoActiva);
		JButton cancelar = new JButton("Cancelar");
		JButton aceptar = new JButton("Aceptar");
		JButton trayecto = new JButton("Definir trayecto");
		JOptionPane aviso = new JOptionPane();
		
		Principal prin = new Principal();
		
		cancelar.addActionListener(e -> {
			this.armarBusqueda(app);
			this.revalidate();
			this.repaint();
		});
		
		aceptar.addActionListener(e -> {
			if(!nombretexto.getText().isEmpty() && !colortexto.getText().isEmpty()){
				
				aviso.showMessageDialog(null, "Linea cargada correctamente");
				prin.armarVentanaPrincipal(app);
				this.revalidate();
				this.repaint();
			}
			else {
				aviso.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarEdicionLineas(app);
				this.revalidate();
				this.repaint();
			}
		});
		
		trayecto.addActionListener(e -> {
			this.definirTrayecto(app);
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
		panel.add(cancelar, gbcLineas);
		
		gbcLineas.anchor = GridBagConstraints.CENTER;
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

	public void definirTrayecto(App app) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollTrayecto=new JScrollPane();
		JTable tablaTrayecto = this.dibujarTablaTrayectos(app);
		scrollTrayecto.setViewportView(tablaTrayecto);
		
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 0;
		gbcLineas.gridwidth = 3;
		gbcLineas.gridheight = 1;
		gbcLineas.weightx = 1.0;
		panel.add(scrollTrayecto, gbcLineas);
		gbcLineas.weightx = 0.0;
		gbcLineas.gridwidth = 1;
		gbcLineas.fill = GridBagConstraints.NONE;
		
		gbcLineas.weightx = 1.0;
		gbcLineas.weighty = 1.0;
		gbcLineas.anchor = GridBagConstraints.WEST;
		gbcLineas.gridx = 0;
		gbcLineas.gridy = 1;
		panel.add(atras, gbcLineas);
		
		gbcLineas.anchor = GridBagConstraints.EAST;
		gbcLineas.gridx = 2;
		gbcLineas.gridy = 1;
		panel.add(aceptar, gbcLineas);
		gbcLineas.weightx = 0.0;
		gbcLineas.weighty = 0.0;
		gbcLineas.anchor = GridBagConstraints.NONE;
		
		
		atras.addActionListener(e -> {
			this.armarEdicionLineas(app);
			this.revalidate();
			this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
	}

	private JTable dibujarTablaTrayectos(App app) {
		DefaultTableModel modelo = new DefaultTableModel();	
	
		modelo.addColumn("Id");
	
		JTable tablaTrayecto = new JTable(modelo);
	
		/*TableRowSorter<TableModel> ordenador=new TableRowSorter<TableModel>(modelo);
		tablaPlantas.setRowSorter(ordenador);*/
		
		TableColumnModel modeloColumna = tablaTrayecto.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(40);
	
		for (int i=0 ; i<5; i++) {
			Object fila[] = new Object[1];
			fila[0]=(int)(Math.random()*10+1);;
			modelo.addRow(fila);
			};
		
			aceptar.addActionListener(f -> { 
				JOptionPane.showConfirmDialog(null, "Seguro que quiere cargar el trayecto seleccionado?");
				System.out.println("hola" +fila);
			});
			
			
			ListSelectionModel seleccion = tablaTrayecto.getSelectionModel();
			seleccion.addListSelectionListener(new ListSelectionListener() {
			
				public void valueChanged(ListSelectionEvent e) {
				
					//reiniciar cantidad de clics
					if(e.getValueIsAdjusting()) return; 
				
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if(!lsm.isSelectionEmpty()) { 
							fila = lsm.getSelectedIndices()[0];
						}
					}
			});
			
				atras.addActionListener(e -> {
				this.armarEdicionLineas(app);
				this.revalidate();
				this.repaint();
				});
		

			return tablaTrayecto;
	}
	
}