package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatementDemo {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		//register
		try {
			
			//1. register
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//2. get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","avocado");
			
			//3. create a statement, use for static queries
			Statement stmt = conn.createStatement();
			
			String selectStr = "select * from employee";
			
			//4. Execute the statement
			//use execute update to insert, use executeQeury for a select statement			
			//update
			ResultSet results = stmt.executeQuery(selectStr);
			
			//can check to see how many columns are in the results by using results set meta data
			System.out.println("results set has " + results.getMetaData().getColumnCount() + " columns");
			
			while(results.next()) {
				System.out.println(results.getInt("id") + " " + results.getString("name") + " " + results.getDouble("salary"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL execption occured: " + e.getMessage());
			e.printStackTrace();
			
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Error occured while trying to close the connection");
					e.printStackTrace();
				}
			}
		}

	}

}
