package Logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoletosService {

	private static String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static String user = "died";
	private static String pass = "died";
	
public void nuevoBoleto(Integer nro, String fecha, String nombre, String correo, Integer origen, Integer destino, Integer trayecto, Double costo) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement("INSERT INTO briani_ferreira_tardivo_died.boleto (nroboleto, correocliente, nombrecliente, fecha, origen, destino, camino, costo ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			pstm.setInt(1, nro);
			pstm.setString(2, correo);
			pstm.setString(3, nombre);
			pstm.setString(4, fecha);
			pstm.setInt(5, origen);
			pstm.setInt(6, destino);
			pstm.setInt(7, trayecto);
			pstm.setDouble(8, costo);
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

