package com.mayuratech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Simplestmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con = DriverManager.getConnection("jdbc:mysql://10.0.2.134:3306/mmysqldemo", "tejeshd", "Tejesh@SQL_DB");
	         
//	     System.out.println("Connection Established successfully");
	     String query = "SELECT * FROM mmysqldemo.emptable limit 10";
	     
	     Statement st = con.createStatement();
	     ResultSet rs = st.executeQuery(query); 
	     
	     while(rs.next()) {
	    	   System.out.println("id:"+rs.getInt("empid")+","+"name:"+rs.getString("empname")+","+"sal="+rs.getInt("sal")+","+"dept:"+rs.getString("dept"));
	    	}
	     st.close(); 
	     con.close(); 
//	     System.out.println("Connection Closed....");	     
	}
}
