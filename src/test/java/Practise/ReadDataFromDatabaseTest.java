package Practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {

Driver driver=new Driver(); 
		
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emart","root","root");
		Statement state = con.createStatement();
		 String query = "select * from mobile;";
		 ResultSet result = state.executeQuery(query);
		 
		 while(result.next()) {
		 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		 }
		 
		 con.close();
	}

}
