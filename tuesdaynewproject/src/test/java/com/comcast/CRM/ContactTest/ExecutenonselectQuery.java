package com.comcast.CRM.ContactTest;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.comcast.CRM.generic.Databaseutility.Databaseutility;
import com.mysql.jdbc.Driver;

public class ExecutenonselectQuery {
	public static void main(String[] args) throws Exception {
		//("jdbc:mysql://localhost:3306/qspiders", "root", "root");
		  Databaseutility dblib=new Databaseutility();
		  dblib.getconnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
		int res = dblib.executenonselectquery("insert into studentdata values('shub', '180');");
		System.out.println(res);
		  ResultSet result = dblib.executeselectQuery("Select* from studentdata");
		  while(result.next())
		  {
			System.out.println(  result.getString(1));
			 
		  }
		  dblib.closeconnection();
		  
		
		
		
		// step3: create Sql statement
		  // Statement state = connect.createStatement();
		// step 4: execute select query and get result 
		     //   int result = state.executeUpdate("insert into studentdata values('virat', '190');");
		     //   System.out.println(result);
		     
		    	// System.out.println(result.getString(1)+ "\t" +result.getString(2)+ "\t" + result.getString(3));
		    	// System.out.println(result.getString(2));
		        //step 5 close the connection
		       // connect.close();
		        
	}
	}
