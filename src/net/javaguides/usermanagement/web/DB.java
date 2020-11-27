package net.javaguides.usermanagement.web;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	static String URL = "localhost:3306/";
	static String DATABASE_NAME = "document";
	static String USERNAME = "root";
	static String PASSWORD = "";
	
	
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://"+URL+DATABASE_NAME,USERNAME,PASSWORD);
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return cn;
	}
}
