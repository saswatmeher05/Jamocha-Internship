package com.pingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingUsingCMD {

	public static void runSystemCommand(String command) {

		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String s = "";
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String ip = "10.10.10.10"; 
		runSystemCommand("ping " + ip);
	}
}
