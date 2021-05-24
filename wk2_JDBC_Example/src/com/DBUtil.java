package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class DBUtil {
	
	public static Connection getDBConnection() {		
		
		Connection conn = null;

		try {
			
			//1. register
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//2. get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","avocado");
			
		} catch (SQLException e) {
			System.out.println("SQL execption occured while trying to create connection: " + e.getMessage());
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	//alternative way to get the JDBC driver
	public static Connection getDBConnection2() {		
			
		Connection conn = null;

		try {
			
			//TODO: see what this class.forName thing is all about
			
			//1. register
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. get connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","avocado");
			
		} catch (SQLException e) {
			System.out.println("SQL execption occured while trying to create connection: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	public static void printSelectStmtResults(ResultSet results) {
		
		try {
			
			//see if there are actually any results
			if(results.first()) {
				
				//print the culumn labels
				ResultSetMetaData metaData = results.getMetaData();
				
				//print top divider
				for(int i = 1; i <= metaData.getColumnCount(); i++) {
					System.out.print("+-");
					for(int j=0; i<metaData.getColumnName(j).length();j++) {
						System.out.print("-");
					}
					System.out.print("+");
				}
				
				//print column names
				for(int i = 1; i <= metaData.getColumnCount(); i++) {
					System.out.print("|");
					for(int j=0; i<metaData.getColumnName(j).length();j++) {
						System.out.print(" " + metaData.getCatalogName(i) + " ");
					}
					System.out.print("|");
				}
				
				//print divider
				for(int i = 1; i <= metaData.getColumnCount(); i++) {
					System.out.print("+-");
					for(int j=0; i<metaData.getColumnName(j).length();j++) {
						System.out.print("-");
					}
					System.out.print("+");
				}
				
				//print data
				results.beforeFirst();
				
				//loop over the results
				while(results.next()) {
					for(int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
						//insert spaces before data
						
						//print data
						System.out.print(results.getObject(i).toString());

						//insert spaces after data
						
					}
					System.out.println();
				}
				
				//print bottom divider
				for(int i = 1; i <= metaData.getColumnCount(); i++) {
					System.out.print("+-");
					for(int j=0; i<metaData.getColumnName(j).length();j++) {
						System.out.print("-");
					}
					System.out.print("+");
				}
			}
			else {
				System.out.println("No results");
			}
			
		} catch (SQLException e) {
			
		}
		
	}
	
	public static String getSpaces(int numSpaces) {
		String result ="";
		
		for(int i=0; i<numSpaces;i++) {
			result+=" ";
		}
		
		return result;
	}
	

}
