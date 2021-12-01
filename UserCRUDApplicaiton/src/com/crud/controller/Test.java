package com.crud.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
//		Date currentDate=new Date(System.currentTimeMillis());
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2021");
		
		Date currDate=new Date();
		currDate=formatter.parse(formatter.format(currDate));
		
		System.out.println(date);
		System.out.println(currDate);
		
		System.out.println(date.compareTo(currDate));
		
		String s="somu meher";
		System.out.printf("%-20s",s);
		System.out.println(s);
		System.out.printf("%-15s","FirstName");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Enter a number:");
		boolean flag=true;
		do {
			try {
				int k=Integer.parseInt(sc.nextLine());			
				System.out.println(k);
				flag=true;
				if(String.valueOf(k).matches("^[1-9]$")) {
					System.out.println("match");
				}else {
					System.out.println("no match");
				}
			}catch(Exception e) {
				System.out.println("Invalid number Try Again:");
				flag=false;
			}	
		}while(!flag);
		
//		System.out.println(date.getTime());
//		System.out.println(new java.sql.Date(date.getTime()));

		sc.close();
	}

}
