package Logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MantenimientoService {

	private static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static String user = "died";
	private static String pass = "died";
	
	public void darDeAltaMantenimiento(Integer id, String inicio, String fin, String obs, Integer estacion) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("INSERT INTO briani_ferreira_tardivo_died.mantenimiento (id_mantenimiento, inicio, fin, observaciones, id_estacion) VALUES (?, ?, ?, ?, ?)");
			pstm.setInt(1, id);
			pstm.setString(2, inicio);
			pstm.setString(3, fin);
			pstm.setString(4, obs);
			pstm.setInt(5, estacion);
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

	public void eliminarMantenimiento(Integer est) throws SQLException {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	try {
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(url, user, pass);
		pstm = conn.prepareStatement("DELETE FROM briani_ferreira_tardivo_died.mantenimiento WHERE id_estacion = ?");
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
}
