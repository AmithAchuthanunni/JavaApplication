package com.cts.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	private static Connection conn=null;
	
	private DBUtil() {
		
	}
	
	public static Connection getDBConnection(){
		if(conn == null){

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String cs="jdbc:mysql://localhost:3306/studentproject";
		
		try {
conn=DriverManager.getConnection(cs,"root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
		return conn;
	}
	
}
