package Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Estaciones extends JFrame{

	
	private GridBagConstraints gbcEstaciones;
	JButton editar = new JButton("Editar");
	JButton eliminar = new JButton("Eliminar");
	
	
	public Estaciones() {
		this.gbcEstaciones = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
	}
	
	
	public JButton armarBoton(App app) {
		JButton estaciones = new JButton("Estaciones");
		JPanel panel = new JPanel(new GridBagLayout());
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 0;
		panel.add(estaciones, gbcEstaciones);
		
		estaciones.addActionListener(e -> {
		this.armarVentanaEstaciones(app);
		this.revalidate();
		this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
		return estaciones;
	}
	
	 
	public void armarVentanaEstaciones(App app) {
		
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
			if(!idtexto.getText().isEmpty() && !nombretexto.getText().isEmpty() 
			&& !apertura.getText().isEmpty() && !cierretexto.getText().isEmpty()){
				
				aviso.showMessageDialog(null, "Estacion cargada correctamente");
				prin.armarVentanaPrincipal(app);
				this.revalidate();
				this.repaint();
			}
			else {
				aviso.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarVentanaEstaciones(app);
				this.revalidate();
				this.repaint();
			}
		});
		
		busqueda.addActionListener(e -> {
			this.armarBusqueda(app);
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
		panel.add(estadotexto, gbcEstaciones);
		
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
		
		for (int i=0 ; i<5; i++) {
			Object fila[] = new Object[5];
			fila[0]=(int)(Math.random()*10+1);
			fila[1]="Manuel Belgrano";
			fila[2]="6:00hs";
			fila[3]= "21:00hs";
			fila[4] = "Al azar";
			modelo.addRow(fila);
			};
		
			JOptionPane aviso = new JOptionPane();
			
			ListSelectionModel seleccion = tablaEstaciones.getSelectionModel();
			seleccion.addListSelectionListener(new ListSelectionListener() {
				
				public void valueChanged(ListSelectionEvent e) {
					
					if(e.getValueIsAdjusting()) return; 
					
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					if(!lsm.isSelectionEmpty()) { 
						eliminar.addActionListener(f -> { 
							//aviso.showConfirmDialog(null, "Seguro que quiere eliminar la estacion seleccionada?");
							modelo.removeRow(tablaEstaciones.getSelectedRow());
						});
						Estaciones est = new Estaciones();
						editar.addActionListener(g -> {
							est.armarEdicionEstaciones(app);
						});
					}
				}
			});
			
	
		return tablaEstaciones;
	}
	
	public void armarBusqueda(App app) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollEstaciones=new JScrollPane();
		JButton atras = new JButton("Atras");
		//JButton editar = new JButton("Editar");
		//JButton eliminar = new JButton("Eliminar");
		JTable tablaEstaciones = this.dibujarTablaEstaciones(app);
		scrollEstaciones.setViewportView(tablaEstaciones);

	
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 0;
		gbcEstaciones.gridwidth = 3;
		gbcEstaciones.gridheight = 1;
		gbcEstaciones.fill = GridBagConstraints.HORIZONTAL;
		gbcEstaciones.weightx = 1.0;
		panel.add(scrollEstaciones, gbcEstaciones);
		gbcEstaciones.weightx = 0.0;
		gbcEstaciones.gridwidth = 1;
		gbcEstaciones.fill = GridBagConstraints.NONE;
		
		gbcEstaciones.weightx = 1.0;
		gbcEstaciones.weighty = 1.0;
		gbcEstaciones.anchor = GridBagConstraints.WEST;
		gbcEstaciones.gridx = 0;
		gbcEstaciones.gridy = 1;
		panel.add(atras, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.EAST;
		gbcEstaciones.gridx = 1;
		gbcEstaciones.gridy = 1;
		panel.add(editar, gbcEstaciones);
		
		gbcEstaciones.anchor = GridBagConstraints.WEST;
		gbcEstaciones.gridx = 2;
		gbcEstaciones.gridy = 1;
		panel.add(eliminar, gbcEstaciones);
		gbcEstaciones.weightx = 0.0;
		gbcEstaciones.weighty = 0.0;
		gbcEstaciones.anchor = GridBagConstraints.NONE;
		
		
		atras.addActionListener(e -> {
			this.armarVentanaEstaciones(app);
			this.revalidate();
			this.repaint();
		});
		
		app.setContentPane(panel);
		app.revalidate();
		app.repaint();
		
	}
	
public void armarEdicionEstaciones(App app) {
		
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
		JComboBox<EstadoEstacion> estadocombo = new JComboBox();
		estadocombo.addItem(EstadoEstacion.Operativa);
		estadocombo.addItem(EstadoEstacion.Mantenimiento);
		JButton cancelar = new JButton("Cancelar");
		JButton aceptar = new JButton("Aceptar");
		JOptionPane aviso = new JOptionPane();
		
		cancelar.addActionListener(e -> {
			this.armarBusqueda(app);
			this.revalidate();
			this.repaint();
		});
		
		aceptar.addActionListener(e -> {
			if(!idtexto.getText().isEmpty() && !nombretexto.getText().isEmpty() 
			&& !apertura.getText().isEmpty() && !cierretexto.getText().isEmpty()){
				
				if(estadocombo.getSelectedItem().equals(EstadoEstacion.Mantenimiento)) {
					this.armarMantenimiento(app);
				}
				else {
				aviso.showMessageDialog(null, "Estacion editada correctamente");
				this.armarBusqueda(app);
				this.revalidate();
				this.repaint();
				}
			}
			else {
				aviso.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarEdicionEstaciones(app);
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
		
	public void armarMantenimiento(App app) {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.LIGHT_GRAY);
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
		
		JOptionPane aviso = new JOptionPane();
		
		cancelar.addActionListener(e -> {
			this.armarEdicionEstaciones(app);
			this.revalidate();
			this.repaint();
		});
		
		
		aceptar.addActionListener(e -> {
			if(!idtexto.getText().isEmpty() && !iniciotexto.getText().isEmpty() 
			&& !fintexto.getText().isEmpty() && !obstexto.getText().isEmpty()) {
				aviso.showMessageDialog(null, "Estacion editada correctamente");
				this.armarBusqueda(app);
				this.revalidate();
				this.repaint();
			}
			else {
				aviso.showMessageDialog(null, "Datos faltantes o fuera de rango");
				this.armarMantenimiento(app);
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
