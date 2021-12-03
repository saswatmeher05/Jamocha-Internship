package com.multithreading.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		Date date=format.parse("02-12-2021 18:26:15");
		Date date1=new Date();
		System.out.println(date);
		System.out.println(date1);
		System.out.println(date.getTime()-date1.getTime());
	}

}
