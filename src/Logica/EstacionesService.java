package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.table.DefaultTableModel;

public class EstacionesService {
	

	private static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static String user = "died";
	private static String pass = "died";
	
	public DefaultTableModel buscarEstaciones(DefaultTableModel modelo) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("SELECT id_estacion, nombre_estacion, apertura, cierre, estado FROM briani_ferreira_tardivo_died.estacion");
			rs = pstm.executeQuery();
			while(rs.next()) { 
				Object aux[] = new Object[5];
				aux[0] = rs.getInt("id_estacion");
				aux[1] = rs.getString("nombre_estacion");
				aux[2] = rs.getString("apertura");
				aux[3] = rs.getString("cierre");
				aux[4] = rs.getString("estado");
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
	
	public void darDeAltaEstacion(Integer id, String nombre, String apertura, String cierre, String estado) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("INSERT INTO briani_ferreira_tardivo_died.estacion (id_estacion, nombre_estacion, apertura, cierre, estado) VALUES (?, ?, ?, ?, ?)");
			pstm.setInt(1, id);
			pstm.setString(2, nombre);
			pstm.setString(3, apertura);
			pstm.setString(4, cierre);
			pstm.setString(5, estado);
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
	
	public void eliminarEstacion(Integer est) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("DELETE FROM briani_ferreira_tardivo_died.estacion WHERE id_estacion = ?");
			pstm.setInt(1, est);
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
	
	public void editarEstacion(Integer id, String nombre, String apertura, String cierre, String estado) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("UPDATE briani_ferreira_tardivo_died.estacion SET nombre_estacion = ?, apertura = ?, cierre = ?, estado = ? WHERE id_estacion = ?");
			pstm.setString(1, nombre);
			pstm.setString(2, apertura);
			pstm.setString(3, cierre);
			pstm.setString(4, estado);
			pstm.setInt(5, id);
			pstm.executeUpdate();
			System.out.println("hola");
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
