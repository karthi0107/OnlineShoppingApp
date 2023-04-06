package Practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws Throwable {
		int result = 0;
		try {
		
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emart","root","root");
		Statement state = con.createStatement();
		String query = "insert into mobile values('OnePlus',500000,'OP','black');";
		 result = state.executeUpdate(query);
		
		}
		catch(Exception e) {
			
		}
		finally {
		if(result==1) {
			System.out.println("data updated");
		}
		else {
			System.err.println("data is not updated");
		}
		
		}	
	}

}
