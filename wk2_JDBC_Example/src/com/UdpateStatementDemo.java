package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UdpateStatementDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the employee id to update: ");
		int employeeId = scanner.nextInt();
		
		System.out.print("enter the employee name: ");
		String employeeName = scanner.next();
		
		System.out.print("enter the employee salary: ");
		double employeeSalary = scanner.nextDouble();
		
		Connection conn = DBUtil.getDBConnection();
		
		//String insertQuery = "insert into employee(name,salary) values (?,?)"; //positional parameters to be supplied at runtime
		
		String updateQuery = "update employee set name = ?, salary = ? where id = ?";
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(updateQuery);
			
			//have to set the values that will be updated
			pStmt.setString(1,employeeName);
			pStmt.setDouble(2, employeeSalary);
			
			//have to set the id of the employee we are updating
			pStmt.setInt(3, employeeId);
			
			//execute the update
			int count = pStmt.executeUpdate();
			
			if(count > 0) {
				//a row was updated
				System.out.println(count + " rows updated.");
			}
			else {
				System.out.println("No data was updated.");
			}
			
			conn.close();
			scanner.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
