package mavenexample;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB 
{
	public static void main(String[] args) throws SQLException 
	{  
		//Create a new ArrayList of type ArrayList
        ArrayList<String> myArrayList = new ArrayList();

		try
		{
			// "jdbc:oracle:thin@opl230:1521";
			// 1.  Get a connection to database
			//String dbUrl = "jdbc:oracle:thin:@opl230:1521";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";//tiger123

			Connection conn;
			conn = DriverManager.getConnection(dbUrl,user, password);
			
			String sqlStatement ="SELECT * FROM EMPLOYEE";
			// Creating PreparedStatement object to execute query
			// The PreparedStatement interface defines the methods and properties 
			// that enable us to send SQL or PL/SQL commands and receive data 
			// from our database
	        PreparedStatement preStatement = conn.prepareStatement(sqlStatement);
	    
	        // Use the executeQuery method from prepared statement
	        ResultSet result = preStatement.executeQuery(sqlStatement);
	      
	        // Iterate the result returned (the records)
	        while(result.next())
	        { 
	        	// Print field 1 from the record
	        	System.out.println("First Name : " + result.getString(1));
	        	// Print field 2  from the record
	        	System.out.println("Emp Mumber : " + result.getString(2)); 
	        	// Repeat this for all fields etc
	        	
	        	myArrayList.add(result.getString(1));
	            myArrayList.add(result.getString(2));
	        }
	        System.out.println("Completed the read and write process");
		}
		
		catch(Exception e)
		{
			System.out.println("There is a problem - possibly no database driver, check that the JDBC jar file has been added to your project");
		}
	
        for(Object object : myArrayList) 
        {
            String element = (String) object;
            System.out.println("Using the foreach iterator we get: " + element);
        }
}
}