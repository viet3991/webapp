package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
	private final String serverName = "localhost";
	private final String dbName = "ShoppingDB";
	private final String port = "1433";
	private final String instance = "";
	private final String user = "sa";
	private final String password = "1234";
	
	
	public Connection getJDBCConnection() {
		try {
			String url = "jdbc:sqlserver://" + serverName +":" + port + "\\" + instance +
					";databaseName=" + dbName +
					";encrypt=true;trustServerCertificate=true";
			
			if (instance == null || instance.trim().isEmpty()) {
				url = "jdbc:sqlserver://" + serverName +":" + port + 
						";databaseName=" + dbName +
						";encrypt=true;trustServerCertificate=true";
			}
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			try {
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("Can't connect to database");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load driver");
		}
		return null;
	}
	

}
