package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTypesDemo {

	public static void main(String[] args) {
		Connection conn = DBUtil.getDBConnection();
		
		try {
			
			//scroll sensitive (updates to the DB will be reflected in results set in realtime?), concur updatable
			
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet results = stmt.executeQuery("select * from employee");
			
			//get a specific row from the table
			results.absolute(2);

			//get the results			
			System.out.println(results.getInt(1) + ", " + results.getString("name") + ", " + results.getDouble("salary"));
			
			Thread.sleep(5000);
			results.absolute(2);
			System.out.println(results.getInt(1) + ", " + results.getString("name") + ", " + results.getDouble("salary"));
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
