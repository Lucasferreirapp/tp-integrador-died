package Ventanas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.Vector;

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

import Dominio.Estacion;
import Logica.EstacionesService;
import Logica.MantenimientoService;


public class Estaciones extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbcEstaciones;
	EstacionesService es = new EstacionesService();
	MantenimientoService ms = new MantenimientoService();
	Integer valor = -1;
	String nom = null;
	String ap = null;
	String cie = null;
	String est = null;
	
	
	public Estaciones() {
		this.gbcEstaciones = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	
	public JButton armarBotonEstaciones(App app) {
		JButton estaciones = new JButton("Estaciones");
		JPanel panel = new JPanel(new GridBagLayout());
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 0;
		panel.add(estaciones, gbcEstaciones);
		
		estaciones.addActionListener(e -> {
		this.armarBusquedaEstaciones(app);
		this.revalidate();
		this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
		return estaciones;
	}
	 
	public void armarNuevaEstacion(App app) {
		
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
		JTextField estadotexto = new JTextField("Operativa");
		//estadocombo.addItem(EstadoEstacion.Operativa);
		//estadocombo.setSelectedIndex(0);
		JButton alta = new JButton("Dar de Alta");
		JButton atras = new JButton("Atras");
		
		Principal prin = new Principal();
		
		atras.addActionListener(e -> {
			this.armarBusquedaEstaciones(app);
			this.revalidate();
			this.repaint();
		});
		
		alta.addActionListener(e -> {
			if(!idtexto.getText().isEmpty() && !nombretexto.getText().isEmpty() 
			&& !apertura.getText().isEmpty() && !cierretexto.getText().isEmpty()){
				
				try {
					es.darDeAltaEstacion(Integer.parseInt(idtexto.getText()), nombretexto.getText(), aperturatexto.getText(), cierretexto.getText(), "Operativa");
					JOptionPane.showMessageDialog(null, "Estacion cargada correctamente");
					this.armarBusquedaEstaciones(app);
					this.revalidate();
					this.repaint();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
					this.armarNuevaEstacion(app);
					this.revalidate();
					this.repaint();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarNuevaEstacion(app);
				this.revalidate();
				this.repaint();
			}
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
		panel.add(estadotexto, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.WEST;
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 5;
		panel.add(atras, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.EAST;
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 5;
		panel.add(alta, gbcEstaciones);
		
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
	private JTable dibujarTablaEstaciones(App app) {
		
		DefaultTableModel modelo = new DefaultTableModel();	
		
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apertura");
		modelo.addColumn("Cierre");
		modelo.addColumn("Estado");
		
		JTable tablaEstaciones = new JTable(modelo);
		
		/*TableRowSorter<TableModel> ordenador=new TableRowSorter<TableModel>(modelo);
		tablaPlantas.setRowSorter(ordenador);*/
		
		TableColumnModel modeloColumna = tablaEstaciones.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(25);
		modeloColumna.getColumn(1).setPreferredWidth(240);
		modeloColumna.getColumn(2).setPreferredWidth(240);
		modeloColumna.getColumn(3).setPreferredWidth(240);
		modeloColumna.getColumn(4).setPreferredWidth(240);
		
		
		try {
			es.buscarEstaciones(modelo);
		} catch(NullPointerException e) {
			System.out.println(e);
		}

		
			ListSelectionModel seleccion = tablaEstaciones.getSelectionModel();
			seleccion.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent e) {
					
					if(e.getValueIsAdjusting()) return; 
					
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if(!lsm.isSelectionEmpty()) { 
							valor = ((Integer)modelo.getValueAt(lsm.getMaxSelectionIndex(), 0));
							nom = ((String)modelo.getValueAt(lsm.getMaxSelectionIndex(), 1));
							ap = ((String)modelo.getValueAt(lsm.getMaxSelectionIndex(), 2));
							cie = ((String)modelo.getValueAt(lsm.getMaxSelectionIndex(), 3));
							est = ((String)modelo.getValueAt(lsm.getMaxSelectionIndex(), 4));
						}
					}
			});
			
		return tablaEstaciones;
	}
	
	public void armarBusquedaEstaciones(App app) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollEstaciones=new JScrollPane();
		JButton atras = new JButton("Atras");
		JButton editar = new JButton("Editar");
		JButton eliminar = new JButton("Eliminar");
		JTable tablaEstaciones = this.dibujarTablaEstaciones(app);
		scrollEstaciones.setViewportView(tablaEstaciones);
		JButton alta = new JButton("Nueva estacion");
	
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 0;
		gbcEstaciones.gridwidth = 4;
		gbcEstaciones.gridheight = 1;
		gbcEstaciones.fill = GridBagConstraints.HORIZONTAL;
		gbcEstaciones.weightx = 1.0;
		panel.add(scrollEstaciones, gbcEstaciones);
		gbcEstaciones.weightx = 0.0;
		gbcEstaciones.gridwidth = 1;
		gbcEstaciones.fill = GridBagConstraints.NONE;
		
		gbcEstaciones.weightx = 1.0;
		gbcEstaciones.weighty = 1.0;
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 1;
		panel.add(atras, gbcEstaciones);

		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 1;
		panel.add(alta, gbcEstaciones);
		
		gbcEstaciones.gridx = 2;
		gbcEstaciones.gridy = 1;
		panel.add(eliminar, gbcEstaciones);
	
		gbcEstaciones.gridx = 3;
		gbcEstaciones.gridy = 1;
		panel.add(editar, gbcEstaciones);
		gbcEstaciones.weightx = 0.0;
		gbcEstaciones.weighty = 0.0;
		gbcEstaciones.anchor = GridBagConstraints.CENTER;
		
		Principal prin = new Principal();
		
		atras.addActionListener(e -> {
			prin.armarVentanaPrincipal(app);
			this.revalidate();
			this.repaint();
		});
		
		alta.addActionListener(e -> {
			this.armarNuevaEstacion(app);
			this.revalidate();
			this.repaint();
		});
		
		eliminar.addActionListener(f -> { 
			//aviso.showConfirmDialog(null, "Seguro que quiere eliminar la estacion seleccionada?");
			try {
				ms.eliminarMantenimiento(valor);
				es.eliminarEstacion(valor);
				this.armarBusquedaEstaciones(app);
				this.revalidate();
				this.repaint();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		editar.addActionListener(f -> {
			this.armarEdicionEstaciones(app, valor, nom, ap, cie, est);
			this.revalidate();
			this.repaint();
	});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
	public void armarEdicionEstaciones(App app, Integer iden, String nom, String ap, String cie, String est) {
		
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
		JComboBox<EstadoEstacion> estadocombo = new JComboBox<EstadoEstacion>();
		estadocombo.addItem(EstadoEstacion.Operativa);
		estadocombo.addItem(EstadoEstacion.Mantenimiento);
		JButton cancelar = new JButton("Cancelar");
		JButton aceptar = new JButton("Aceptar");
	
		idtexto.setText(iden.toString());
		idtexto.setEditable(false);
		nombretexto.setText(nom);
		aperturatexto.setText(ap);
		cierretexto.setText(cie);
		
		cancelar.addActionListener(e -> {
			this.armarBusquedaEstaciones(app);
			this.revalidate();
			this.repaint();
		});
		
		aceptar.addActionListener(e -> {
			if(!idtexto.getText().isEmpty() && !nombretexto.getText().isEmpty() 
			&& !apertura.getText().isEmpty() && !cierretexto.getText().isEmpty()){
				
				if(estadocombo.getSelectedItem().equals(EstadoEstacion.Mantenimiento)) {
					this.armarMantenimientoEstaciones(app, valor, nombretexto.getText(), aperturatexto.getText(), cierretexto.getText(), estadocombo.getSelectedItem().toString());
				}
				else {
				JOptionPane.showMessageDialog(null, "Estacion editada correctamente");
				try {
					es.editarEstacion(valor, nombretexto.getText(), aperturatexto.getText(), cierretexto.getText(), estadocombo.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.armarBusquedaEstaciones(app);
				this.revalidate();
				this.repaint();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarEdicionEstaciones(app, valor, nom, ap, cie, est);
				this.revalidate();
				this.repaint();
			}
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
		panel.add(cancelar, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.EAST;
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 5;
		panel.add(aceptar, gbcEstaciones);
		
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}

	public void armarMantenimientoEstaciones(App app, Integer iden, String nom, String ap, String cie, String est) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel nuevo = new JLabel("Nuevo Mantenimiento");
		JLabel id = new JLabel("Id");
		JLabel inicio = new JLabel("Inicio");
		JLabel fin = new JLabel("Fin");
		JLabel observaciones = new JLabel("Observaciones");
		JTextField idtexto = new JTextField(2);
		JTextField iniciotexto = new JTextField(10);
		JTextField fintexto = new JTextField(10);
		JEditorPane obstexto = new JEditorPane();
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		
		cancelar.addActionListener(e -> {
			this.armarEdicionEstaciones(app, valor, nom, ap, cie, est);
			this.revalidate();
			this.repaint();
		});
		
	
		aceptar.addActionListener(e -> {
			if(!idtexto.getText().isEmpty() && !iniciotexto.getText().isEmpty() 
			&& !fintexto.getText().isEmpty() && !obstexto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Estacion editada correctamente");
				try {
					es.editarEstacion(valor, nom, ap, cie, est);
					ms.darDeAltaMantenimiento(Integer.parseInt(idtexto.getText()), iniciotexto.getText(), fintexto.getText(), obstexto.getText(), valor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.armarBusquedaEstaciones(app);
				this.revalidate();
				this.repaint();
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarMantenimientoEstaciones(app, valor, nom, ap, cie, est);
				this.revalidate();
				this.repaint();
			}
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
		panel.add(inicio, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 1;
		panel.add(iniciotexto, gbcEstaciones);
		
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 2;
		gbcEstaciones.ipadx = 10;
		panel.add(fin, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 2;
		panel.add(fintexto, gbcEstaciones);
		
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 3;
		gbcEstaciones.ipadx = 10;
		panel.add(observaciones, gbcEstaciones);
		gbcEstaciones.ipadx = 0;
		
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 3;
		panel.add(obstexto, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.WEST;
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 4;
		panel.add(cancelar, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.EAST;
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 4;
		panel.add(aceptar, gbcEstaciones);
		

		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
}
