package com.bookapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static Connection connection;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/springtraining";
		String username = "root";
		String password = "roo";
		// Class.forName("");
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"for dbutil");
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
