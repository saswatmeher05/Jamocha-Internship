package com.pingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PingUsingCMD {

	public static void runSystemCommand(String command) {

		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String s = "";
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ip or address to ping:");
		String ip = sc.nextLine();
		runSystemCommand("ping " + ip);
	}
}
