package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method is used to generate random num
	 * @return
	 */
	public int random() {
		
		Random ran=new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	/**
	 * this method is used to get system Date
	 * 	 * @return
	 */
	
	public String getSystemDate() {
		
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	
	/**
	 * this method is used to change the formate of Date
	 * @return
	 *
	 */
	
	public String formateSystemDate() {
		
		SimpleDateFormat dateformate = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		Date dt = new Date();
		String getDateAndTime = dateformate.format(dt);
	//	getDateAndTime.replace(":", "-");
		return getDateAndTime;
	}
}
