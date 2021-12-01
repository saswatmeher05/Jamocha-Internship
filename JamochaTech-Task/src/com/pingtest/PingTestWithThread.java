package com.pingtest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PingTestWithThread {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter IP to ping:");
		String ip = sc.nextLine();
		InetAddress address=InetAddress.getByName(ip);
		int i = 0;
		while (i < 5) {
			if (address.isReachable(1000)) {
				System.out.println("Ping Successful..");
			} else {
				System.out.println("ping failed!");
			}
			i++;
			Thread.sleep(5000);
		}


	}

}
