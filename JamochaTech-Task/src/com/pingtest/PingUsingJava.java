package com.pingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PingUsingJava {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter IP to Ping:");
		String ip="ping "+sc.nextLine();
		try {
			Process p=Runtime.getRuntime().exec(ip);
			BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String temp="";
			while((temp=reader.readLine())!=null) {
				System.out.println(temp);
			}
		}catch(Exception e) {e.printStackTrace();}

		sc.close();
	}
}
