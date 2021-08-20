package com.customerCRUD.model.dao.factories;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionFactory {
	private static Connection connection;

	private JDBCConnectionFactory() {
	}

	public static Connection getConnection() {
		InputStream is = JDBCConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		@SuppressWarnings("unused")
		String driver = properties.getProperty("jdbc.driverName");
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return connection;
	}

}
