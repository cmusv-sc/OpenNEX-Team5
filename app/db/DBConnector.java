/**
 * @author Bin Lan (blan)
 */
package db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnector {
	private final static String USER = "root";
	private final static String PASS = "";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/";
	public static Connection connection;

	public static boolean getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
