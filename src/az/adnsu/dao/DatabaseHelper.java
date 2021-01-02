package az.adnsu.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseHelper {

	private static HikariDataSource dataSource;

	public static Connection getConnection() throws Exception {
		Properties property = loadPropertyFile();

		String driver = property.getProperty("db.driver");
		String url = property.getProperty("db.url");
		String username = property.getProperty("db.user");
		String password = property.getProperty("db.password");

		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	public static Connection getHikariConnection() throws FileNotFoundException, IOException, SQLException {
		dataSource = new HikariDataSource(getHikariConfig());
		return dataSource.getConnection();
	}

	private static HikariConfig getHikariConfig() throws FileNotFoundException, IOException {
		Properties property = loadPropertyFile();

		String driver = property.getProperty("db.driver");
		String url = property.getProperty("db.url");
		String username = property.getProperty("db.user");
		String password = property.getProperty("db.password");

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driver);
		config.setAutoCommit(false);
		
		return config;
	}

	private static Properties loadPropertyFile() throws IOException, FileNotFoundException {
		Properties property = new Properties();
		property.load(new FileReader("database.properties"));
		return property;
	}

}
