package com.mayuratech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Callablestmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		 Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con = DriverManager.getConnection("jdbc:mysql://10.0.2.134:3306/mmysqldemo", "tejeshd", "Tejesh@SQL_DB");
	         
	     
	     CallableStatement st = con.prepareCall("{call insertR(?,?,?,?)}");
	     
	     st.setInt(1, 120);
	     st.setString(2, "dk");
	     st.setInt(3, 25000);
	     st.setString(4, "dept");
	     
	     st.setInt(1, 115);
	     st.setString(2, "raj");
	     st.setInt(3, 25000);
	     st.setString(4, "hr");
	     
	     st.execute();
	     
//	     while(st.next()){
//	    	 System.out.println("id:"+rs.getInt("empid")+","+"name:"+rs.getString("empname")+","+"sal="+rs.getInt("sal")
//	    	   +","+"dept:"+rs.getString("dept"));
//	    	}
	     
	     System.out.println("success");
	   
	     st.close(); 
	     con.close(); 
	}

}
