package connect;

import java.sql.*;



public class DBConnect {
	public static final String HOSTNAME = "localhost";
	public static final String PORT = "1433";
	public static final String DBNAME = "Slide6";
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "Password.1";
	
	public static DBConnect getConnection() {

	    // Create a variable for the connection string
	    String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
	            + "databaseName=" + DBNAME + ";encrypt=true;trustServerCertificate=true;";

	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
	    } // Handle any errors that may have occurred.
	    catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace(System.out);
	    }

	    return null;
	}
}
