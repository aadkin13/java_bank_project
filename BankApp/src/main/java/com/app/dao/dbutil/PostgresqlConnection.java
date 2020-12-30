package com.app.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnection {
	private static Connection conn;
	
	private PostgresqlConnection() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/bank_db";
		String username = "postgres";
		String password = "buckey3s";
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
