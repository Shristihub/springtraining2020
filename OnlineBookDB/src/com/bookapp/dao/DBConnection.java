package com.bookapp.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

	static Connection connection;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/training";
		String password = "root";
		String username = "root";
		try {
			connection = 
	DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
/*
 * Properties properties = new Properties(); try { properties.load(new
 * FileReader("jdbc.properties")); } catch (FileNotFoundException e1) {
 * e1.printStackTrace(); } catch (IOException e1) { e1.printStackTrace(); }
 * String driverName = (String)properties.get("oracle.driver"); String url =
 * (String)properties.get("oracle.url"); String username =
 * (String)properties.get("oracle.username"); //String password =
 * (String)properties.get("oracle.password");
 */