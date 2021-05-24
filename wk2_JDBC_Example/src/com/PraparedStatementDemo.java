package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PraparedStatementDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("enter the employee name: ");
		String employeeName = scanner.next();
		
		System.out.print("enter the employee salary: ");
		double employeeSalary = scanner.nextDouble();
				
		
		
		
		Connection conn = DBUtil.getDBConnection();
		
		String insertQuery = "insert into employee(name,salary) values (?,?)"; //positional parameters to be supplied at runtime
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			
			//have to set the values
			pStmt.setString(1,employeeName);
			pStmt.setDouble(2, employeeSalary);
			
			//execute the update
			int count = pStmt.executeUpdate();
			
			if(count > 0) {
				//a row was inserted
				System.out.println(count + " rows inserted. Data used was: " + employeeName + " " + employeeSalary);
			}
			else {
				System.out.println("No data was inserted.");
			}
			
			conn.close();
			scanner.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
