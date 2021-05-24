package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAndDeleteDemo {

	public static void main(String[] args) {
		
		Connection conn = DBUtil.getDBConnection();
		
		try {
			
			//DELETE example
			String deleteQuery = "delete from employee where id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			stmt.setInt(1, 5);
			
			boolean isDeleted = stmt.execute();
			
			//System.out.println("Deleted Status: " + !isDeleted);
			
			if(isDeleted == false) {
				System.out.println("Deleted " + stmt.getUpdateCount() + " rows.");
			}
			
			
			//SELECT example
			String selectQuery = "select * from employee";
			
			PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
			
			ResultSet results = selectStmt.executeQuery();
			
			System.out.println("Current Table data:");
			
			while(results.next()) {
				for(int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
					System.out.print(results.getMetaData().getColumnName(i) + " " + results.getObject(i).toString() + ", ");
				}
				System.out.println();
			}
			
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
