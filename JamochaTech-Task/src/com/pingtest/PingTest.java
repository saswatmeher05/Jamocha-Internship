package com.pingtest;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class PingTest {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String ip;
		System.out.println("Enter IP Address to ping:");
		ip=sc.nextLine();
		pingIPAddress(ip);
		
		sc.close();
	}
	public static void pingIPAddress(String ip) throws IOException {
		InetAddress address=InetAddress.getByName(ip);
		System.out.println("Pinging "+ip);
//		System.out.println(address.isReachable(4000));
		if(address.isReachable(3000)) {
			System.out.println("Pinging Successful...");
		}else {
			System.out.println("Pinging Failed/Host Unreachable!!!");
		}
	}

}
