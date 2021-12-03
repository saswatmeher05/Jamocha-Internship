package com.multithreading.test;

import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date date=new Date();
		date.setHours(13);
		date.setMinutes(40);
		date.setSeconds(0);
		System.out.println(date.getHours()+":"+date.getMinutes());
		System.out.println(new Date(System.currentTimeMillis()).getHours()+":"+new Date(System.currentTimeMillis()).getMinutes());

		System.out.println(System.currentTimeMillis());
		System.out.println(date.getTime()-System.currentTimeMillis());
	}

}
