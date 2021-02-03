package pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {
	
	public static void main(String[] args) {
		
		String DRIVER = "com.mysql.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/relacioneshibernate?useSSL=false";
		String USER = "root";
		String PASS = "";
		
		try {
			
			System.out.println("INTENTANDO CONECTAR CON LA BD: " + jdbcURL);
			Class.forName(DRIVER);
			Connection conexion = DriverManager.getConnection(jdbcURL, USER, PASS);
			System.out.println("CONECTADO");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
