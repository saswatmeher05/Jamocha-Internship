package com.stdetails.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Enter Date:");
			Date date = formatter.parse(sc.nextLine());
			Date currentDate = new Date();
			currentDate = formatter.parse(formatter.format(currentDate));
			System.out.println(date);
			System.out.println(currentDate);
			String s="JAVA,PYTHON,PHP,HTML,CSS,JAVASCRIPT,ORACLE,DOTNET";
			System.out.println(s.toLowerCase());
			
			
		} catch (Exception e) {
			System.out.println("Invalid date format..Use DD/MM/YYYY");
		}

	}

}
