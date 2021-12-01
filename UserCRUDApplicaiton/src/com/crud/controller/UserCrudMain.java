package com.crud.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import com.crud.service.UserCrudService;
import com.crud.util.UserCrudException;

public class UserCrudMain {

	public static void main(String[] args)
			throws ClassNotFoundException, ParseException, SQLException, UserCrudException {
		UserCrudService service = new UserCrudService();
		Scanner sc = new Scanner(System.in);
		boolean needsInput=false;
		System.out.println("Select one operation:");
		System.out.println("1.Add User:");
		System.out.println("2.Get User Details:");
		System.out.println("3.Edit User Details:");
		System.out.println("4.Delete User:");
		System.out.println("5.Get All Users:");
		int input = Integer.parseInt(sc.nextLine());
		do {
			switch (input) {
			case 1:
				try {
					String message1 = service.addUser();
					System.out.println(message1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("---------------------------------------------------------------------------");
				service.getAllUsers();
				break;
			case 2:
				service.getUserDetails(0);
//			service.getAllUsers();
				break;
			case 3:
				System.out.println("---------------------------------------------------------------------------");
				service.getAllUsers();
				System.out.println("---------------------------------------------------------------------------");
				String message2 = service.editUserDetails();
				System.out.println("---------------------------------------------------------------------------");
				System.out.println(message2);
				System.out.println("---------------------------------------------------------------------------");
				service.getAllUsers();
				
				break;
			case 4:
				System.out.println("---------------------------------------------------------------------------");
				service.getAllUsers();
				System.out.println("---------------------------------------------------------------------------");
				String message3 = service.deleteUser();
				System.out.println(message3);
				System.out.println("---------------------------------------------------------------------------");
				service.getAllUsers();
				break;
			case 5:
				service.getAllUsers();
				break;
			default:
				break;
			}
		} while (needsInput);
		sc.close();
	}

}
