package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn=null;
	public void getDBConnection(String url,String username,String password) throws Throwable  {
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			DriverManager.getConnection(url, username, password);
			}
		
		catch(Exception e) {
			
		}
	}
	
	public void closeDBConection() {
		try {
			conn.close();
		}
		catch(Exception e) {
			
		}
		
	}
	
	public ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try {
			Statement stat=conn.createStatement();
			result=stat.executeQuery(query);
		}
		catch(Exception e) {
			
		}
		return result;
		
	}
	
	
	public int executeNonSelectQuery(String query) throws SQLException {
		int result=0;
		try {
		    Statement stat=conn.createStatement();
			result=stat.executeUpdate(query);
			}
		catch(Exception e) {
			
		}
		return result;
		
	}
	
	public void getDBConnection() {
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			
		}
		
		catch(Exception e) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
