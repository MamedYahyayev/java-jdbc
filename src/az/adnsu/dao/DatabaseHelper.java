package az.adnsu.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseHelper {

	public static Connection getConnection() throws Exception {
		Properties property = new Properties();
		property.load(new FileReader("database.properties"));

		Class.forName(property.getProperty("db.driver"));

		String url = property.getProperty("db.url");
		String username = property.getProperty("db.user");
		String password = property.getProperty("db.password");

		Connection connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

}
