package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con=null;
	/**
	 * 
	 * @throws Throwable
	 */
	public void connectToDb() throws Throwable {

		Driver drive=new Driver();
		DriverManager.registerDriver(drive);
		con = DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DBUSERNAME, IpathConstants.DBPASSWORD);
	}

	/**
	 * 
	 * @param query
	 * @param expData
	 * @param columnIndex
	 * @return
	 * @throws Throwable
	 */

	public String executeQueryAndGetData(String query, String expData, int columnIndex) throws Throwable  {

		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data = result.getString(columnIndex);

			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("data is verified");
			return expData;
		}
		else {
			System.out.println("data is not updated");
			return "";
		}
	}


	/**
	 * 
	 * @throws Throwable
	 */

	public void closeDB() throws Throwable {

		con.close();
		System.out.println("Database connection closed");
	}
}
