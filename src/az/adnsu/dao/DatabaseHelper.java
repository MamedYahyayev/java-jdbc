package az.adnsu.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseHelper {

	private static HikariDataSource dataSource;
	private static MysqlDataSource mySqlDataSource = new MysqlDataSource();
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	public static Connection getConnection() throws Exception {
		loadPropertyFile();
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	public static Connection getHikariConnection() throws FileNotFoundException, IOException, SQLException {
		dataSource = new HikariDataSource(getHikariConfig());
		return dataSource.getConnection();
	}

	public static Connection getMySqlConnection()
			throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		loadPropertyFile();
		Class.forName(driver);
		mySqlDataSource.setUser(username);
		mySqlDataSource.setPassword(password);
		mySqlDataSource.setUrl(url);
		mySqlDataSource.setCachePrepStmts(true);
		mySqlDataSource.setUseServerPrepStmts(true);
		mySqlDataSource.setPrepStmtCacheSize(400);
		mySqlDataSource.setPrepStmtCacheSqlLimit(1000);
		return mySqlDataSource.getConnection();
	}

	private static HikariConfig getHikariConfig() throws FileNotFoundException, IOException {
		loadPropertyFile();
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
		driver = property.getProperty("db.driver");
		url = property.getProperty("db.url");
		username = property.getProperty("db.user");
		password = property.getProperty("db.password");
		return property;
	}

}
