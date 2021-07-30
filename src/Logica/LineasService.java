package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class LineasService {
	

	private static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static String user = "died";
	private static String pass = "died";
	
	public DefaultTableModel buscarLineas(DefaultTableModel modelo) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("SELECT nombre_linea, color, estado, id_trayecto FROM briani_ferreira_tardivo_died.linea");
			rs = pstm.executeQuery();
			while(rs.next()) { 
				Object aux[] = new Object[4];
				aux[0] = rs.getString("nombre_linea");
				aux[1] = rs.getString("color");
				aux[2] = rs.getString("estado");
				aux[3] = rs.getInt("id_trayecto");
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
	
	public void darDeAltaLinea(String nombre, String color, String estado, Integer trayecto) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("INSERT INTO briani_ferreira_tardivo_died.linea (nombre_linea, color, estado, id_trayecto) VALUES (?, ?, ?, ?)");
			pstm.setString(1, nombre);
			pstm.setString(2, color);
			pstm.setString(3, estado);
			pstm.setInt(4, trayecto);
			pstm.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstm != null) try { pstm.close(); }
							catch (SQLException e) { e.printStackTrace(); }
			if(conn != null) try { conn.close(); }
			catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public void eliminarLinea(String lin) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("DELETE FROM briani_ferreira_tardivo_died.linea WHERE nombre_linea = ?");
			pstm.setString(1, lin);
			pstm.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstm != null) try { pstm.close(); }
							catch (SQLException e) { e.printStackTrace(); }
			if(conn != null) try { conn.close(); }
			catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public void editarLinea(String nombre, String color, String estado, Integer trayecto) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("UPDATE briani_ferreira_tardivo_died.linea SET color = ?, estado = ?, id_trayecto = ? WHERE nombre_linea = ?");
			pstm.setString(1, color);
			pstm.setString(2, estado);
			pstm.setInt(3, trayecto);
			pstm.setString(4, nombre);
			pstm.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstm != null) try { pstm.close(); }
							catch (SQLException e) { e.printStackTrace(); }
			if(conn != null) try { conn.close(); }
			catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
}