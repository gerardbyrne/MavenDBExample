package mavenexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MsAccessDatabaseConnectionExample {

	public static void main(String[] args) {

		// variables
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// Step 1: Loading or registering Oracle JDBC driver class
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(ClassNotFoundException cnfex) {
			System.out.println("Problem in loading or registering MS Access JDBC driver");
			cnfex.printStackTrace();
		}

		// Step 2: Opening database connection
		try {

			//String msAccessDBName = "D:\\WORKSPACE\\TEST_WORKSPACE\\Java-JDBC\\SampleDatabse.";
			String msAccessDBName = "\\Users\\Gerard\\Desktop\\MavenExample\\mavendb\\MavenDataBase.accdb";
			String dbURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + msAccessDBName + ";DriverID=22;READONLY=true";

			// Step 2.A: Create and get connection using DriverManager class
			connection = DriverManager.getConnection(dbURL); 

			// Step 2.B: Creating JDBC Statement 
			statement = connection.createStatement();

			// Step 2.C: Executing SQL & retrieve data into ResultSet
			resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

			System.out.println("ID\tEmpno\t\t\tFirstNme\tLastname");
			System.out.println("==\t================\t===\t=======");

			// processing returned data and printing into console
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(2) + "\t" + 
						resultSet.getString(3) + "\t" + 
						resultSet.getString(4) + "\t" +
						resultSet.getString(5));
			}

		}
		catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
		finally {

			// Step 3: Closing database connection
			try {
				if(null != connection) {

					// cleanup resources, once after processing
					resultSet.close();
					statement.close();

					// and then finally close connection
					connection.close();
				}
			}
			catch (SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}
}