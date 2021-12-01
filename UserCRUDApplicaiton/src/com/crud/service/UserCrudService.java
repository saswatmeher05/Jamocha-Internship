package com.crud.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.crud.dao.UserCrudDao;
import com.crud.dto.UserDTO;
import com.crud.util.Subjects;
import com.crud.util.UserCrudException;

public class UserCrudService {

//	 Add User
	public String addUser() throws ParseException, ClassNotFoundException, SQLException, UserCrudException {
		Scanner sc = new Scanner(System.in);
		UserCrudDao dao = new UserCrudDao();
		UserDTO dto = new UserDTO();
		boolean isValid = true;
		String fname;
		String lname;
		int age = 0;
		String gender;
		String subject;
		String dob="";
		String address;

		// Fname
		do {
			System.out.println("Enter First Name");
			fname = sc.nextLine();
			if (fname == "" || fname.length() > 20) {
				System.out.println("Invalid First Name Try Again!!!");
				isValid = false;
			} else {
				isValid = true;
			}
		} while (!isValid);

//		Lname
		do {
			System.out.println("Enter Last Name");
			lname = sc.nextLine();
			if (lname == "" || lname.length() > 20) {
				System.out.println("Invalid Last Name Try Again!!!");
				isValid = false;
			} else {
				isValid = true;
			}
		} while (!isValid);

//		Age
		do {
			System.out.println("Enter Age");
			try {
				age = Integer.parseInt(sc.nextLine());
				if (age < 20 || age > 100) {
					System.out.println("Age should be greater than 20 and less than 100!");
					isValid = false;
				} else {
					isValid = true;
				}
			} catch (Exception e) {
				System.out.println("Characters and symbols not allowed!");
				isValid = false;
			}
		} while (!isValid);

//		Gender
		do {
			System.out.println("Enter Gender(Enter only male/female):");
			gender = sc.nextLine();
			if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
				System.out.println("Invalid Input Try again!!");
				isValid = false;
			} else {
				isValid = true;
			}
		} while (!isValid);

//		Subject
		do {
	            System.out.println("Enter Subject:");
	            subject = sc.nextLine().toLowerCase();
	            String subjects[] = subject.split(",");
	            // Subjects subs[] = Subjects.values();
	            if(subjects.length==1) {
	            	subject=subjects[0];
	            }
	            for(int i=0;i<subjects.length;i++) {
	                if(Subjects.contains(subjects[i])){
	                    isValid=true;
	                }else{
	                    isValid=false;
	                }
	                
	            }
	            if(!isValid)
	                    System.out.println("Invalid input Try Again!!");
			
		} while (!isValid);

//		DOB
		do {
			try {
			System.out.println("Enter DOB(DD/MM/YYYY):");
			dob = sc.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date = sdf.parse(dob);
			java.util.Date currentDate = new java.util.Date();
			currentDate = sdf.parse(sdf.format(currentDate));
			if (date.compareTo(currentDate) >= 0) {
				System.out.println("Invalid DOB! Try Again");
				isValid = false;
			} else {
				isValid = true;
			}
			
			} catch (Exception e) {
				System.out.println("Invalid format only DD/MM/YYYY allowed");
				isValid=false;
			}
		} while (!isValid);

//		Address
		System.out.println("Enter Address:");
		address = sc.nextLine();

		dto.setFname(fname);
		dto.setLname(lname);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setSubject(subject);
		dto.setDob(dob);
		dto.setAddress(address);

		int k = dao.addUser(dto);
		if (k > 0) {
			return "User Added Successfully...";
		} else {
			return "Adding User Failed Try Again!!!";
		}
	}

//	 Get User Details
	public void getUserDetails(int id) throws SQLException {
		Scanner sc = new Scanner(System.in);
		if (id <= 0) {
			System.out.println("enter id:");
			id = Integer.parseInt(sc.nextLine());
		}
		UserCrudDao dao = new UserCrudDao();
		dao.getUserDetails(id);
//		System.out.println("ID FirstName LastName Age Gender Subject     DOB       Address");
//		System.out.println();
//		System.out.println("FName:"+dto.getFname());
//		System.out.println("LName:"+dto.getLname());
//		System.out.println("Age:"+dto.getAge());
//		System.out.println("Gender:"+dto.getGender());
//		System.out.println("Subject:"+dto.getSubject());
//		System.out.println("DOB:"+dto.getDob());
//		System.out.println("Address:"+dto.getAddress());
	}

//	 Edit User Details
	public String editUserDetails() throws SQLException, ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID to Edit User:");
		int id = Integer.parseInt(sc.nextLine());
		getUserDetails(id);
		UserCrudDao dao = new UserCrudDao();
		int k = dao.editUserDetails(id);
		if (k > 0) {
			return "User Updated Successfully";
		} else {
			return "";
		}
	}

//	 Delete User
	public String deleteUser() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to delete user:");
		int id = Integer.parseInt(sc.nextLine());
		UserCrudDao dao = new UserCrudDao();
		int k = dao.deleteUser(id);
		if (k > 0) {
			return "User Deleted Successfully...";
		} else {
			return "User Not Found!!!!!!";
		}

	}

//	 Get All Users
	public void getAllUsers() throws SQLException {
		UserCrudDao dao = new UserCrudDao();
		dao.getAllUsers();
	}

}
