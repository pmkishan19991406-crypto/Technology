package com.abc.kishan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApp {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement =null;
	
		String url="jdbc:mysql://localhost:3306/abc";
		String username="root";
		String password="root123";
				
		try {
			 connection = DriverManager.getConnection(url,username,password);
			if (connection!=null) {
				System.out.println("Connection established with :"+url);
				statement = connection.createStatement();
			if (statement!=null) {
				String SQL_UPDATE_QUERY="update employee set ename='PMK' where eid=20";
				int rowCount = statement.executeUpdate(SQL_UPDATE_QUERY);
				if (rowCount>0) {
					System.out.println("Record Updated successfully");
				} else {
					System.out.println("Record updated failed");
				}
			}
				
				
			}
		} catch (SQLException se) {
			if(se.getErrorCode()==1406)
				System.out.println("Data is too long for the column");
			else if(se.getErrorCode()==1062)
				System.out.println("Duplication of primary key");
			else if(se.getErrorCode()==1136)
				System.out.println("Insufficient values supplied by the user");
			else if(se.getErrorCode()==1064)
				System.out.println("Syntax error in SQL ");
			else
				System.out.println("Some SQL Exception occured");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			

			try {
				 if (statement!=null) {
					 statement.close();
				}
				
			} catch (SQLException se) {
				se.printStackTrace();
			}

			try {
			 if (connection!=null) {
				 connection.close();
			}
			
			} catch (SQLException se) {
			se.printStackTrace();
		}
		}

	}

}
