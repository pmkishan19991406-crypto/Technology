package com.abc.kishan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement =null;
		ResultSet resultSet =null;
	
		String url="jdbc:mysql://localhost:3306/abc";
		String username="root";
		String password="root123";
				
		try {
			 connection = DriverManager.getConnection(url,username,password);
			if (connection!=null) {
				System.out.println("Connection established with :"+url);
				statement = connection.createStatement();
			if (statement!=null) {
				String SQL_SELECT_QUERY="select eid,ename,eage,eaddress from employee";
				 resultSet = statement.executeQuery(SQL_SELECT_QUERY);
				 System.out.println("EMPLOYEE DATABASE DATA");
				 System.out.println("EID\tENAME\tEAGE\tEADDRESS");
				 while (resultSet.next()) {
					 System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"
							 			+ resultSet.getInt(3)+"\t"+resultSet.getString(4));
					
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
