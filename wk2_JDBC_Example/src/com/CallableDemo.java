package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableDemo {

	public static void main(String[] args) {
		Connection conn = DBUtil.getDBConnection();
		
		try {
			//sample creation of stored proc
			
			
//			DELIMITER //
//
//			CREATE PROCEDURE getAllEmployees()
//			BEGIN
//			SELECT * FROM employee;
//			END//
			
			//some stored proc on the DB that we can call
			String callableQuery = "{call getAllEmployees()}";
			
			//prepare the callable statement
			CallableStatement stmt = conn.prepareCall(callableQuery);
			
			//execute and get the results
			ResultSet results = stmt.executeQuery();
			
			//do something with the results
//			while(results.next()) {
//				System.out.println(results.getInt(1) + ", " + results.getString(2) + ", " + results.getDouble(3));
//			}
			
			
			
			while(results.next()) {
				for(int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
					System.out.print(results.getMetaData().getColumnName(i) + "=" + results.getObject(i).toString() + ", ");
				}
				System.out.println();
			}
			
			//close connection
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
