package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class TrayectoService {

	private static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static String user = "died";
	private static String pass = "died";
	
	public DefaultTableModel buscarTrayectos(DefaultTableModel modelo) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("SELECT id_trayecto FROM briani_ferreira_tardivo_died.trayecto");
			rs = pstm.executeQuery();
			while(rs.next()) { 
				Object aux[] = new Object[1];
				aux[0] = rs.getInt("id_trayecto");
				modelo.addRow(aux);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			if(rs != null) try { rs.close(); }
							catch (SQLException e) { e.printStackTrace(); }
			if(pstm != null) try { pstm.close(); }
							catch (SQLException e) { e.printStackTrace(); }
			if(conn != null) try { conn.close(); }
							catch (SQLException e) { e.printStackTrace(); }
		}
			
			return modelo;
	}
	
public List<Integer> trayectosId(){
		
		List<Integer> trayectos = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("SELECT id_trayecto FROM briani_ferreira_tardivo_died.trayecto");
			rs = pstm.executeQuery();
			while(rs.next()) { 
				trayectos.add(rs.getInt("id_trayecto"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			if(rs != null) try { rs.close(); }
							catch (SQLException e) { e.printStackTrace(); }
			if(pstm != null) try { pstm.close(); }
							catch (SQLException e) { e.printStackTrace(); }
			if(conn != null) try { conn.close(); }
							catch (SQLException e) { e.printStackTrace(); }
		}
			
		Collections.sort(trayectos);
			return trayectos;
	}
	}
