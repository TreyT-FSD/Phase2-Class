package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatementDemo {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		//register
		try {
			
			//1. register
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//2. get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","avocado");
			
			//3. create a statement
			Statement stmt = conn.createStatement();			
			//String insertStr = "insert into employee(name,salary) values ('tim',65000)";
			String insertStr2 = "insert into employee values (1,'tim',65000)";
			
			
			//4. Execute the statement
			//use execute update to insert, use executeQeury for a select statement			
			//update
			int count = stmt.executeUpdate(insertStr2);
			
			//check for results
			if(count > 0) {
				//some records were updated
				System.out.println(count + " records were udpated.");
			}
			else {
				//no records updated
				System.out.println("Nothing was updated");
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
		
		//

	}

}
