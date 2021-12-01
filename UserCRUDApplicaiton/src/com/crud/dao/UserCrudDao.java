package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.crud.dto.UserDTO;
import com.crud.util.UserCrudUtil;

public class UserCrudDao {
	public Connection con;
	
	//Add User
	public int addUser(UserDTO dto) throws SQLException,ClassNotFoundException, ParseException{
		con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into usercrud values(?,?,?,?,?,?,?,user_seq.NEXTVAL)");
		ps.setString(1, dto.getFname());
		ps.setString(2, dto.getLname());
		ps.setInt(3, dto.getAge());
		ps.setString(4, dto.getGender());
		ps.setString(5, dto.getSubject());
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDob());
		long dob=date.getTime();

		ps.setDate(6, new java.sql.Date(dob));
		ps.setString(7, dto.getAddress());
		
		int k=ps.executeUpdate();
		return k;
	}
	
	//Get user details
	public void getUserDetails(int id) throws SQLException {
		UserDTO dto=new UserDTO();
		con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from usercrud where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			UserCrudUtil.printTableHeader();
//			System.out.println("ID FirstName LastName Age Gender Subject     DOB       Address");	
//			System.out.println(rs.getInt(8)+"   "+rs.getString(1)+"      "+rs.getString(2)+"   "+rs.getInt(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"    "+rs.getDate(6)+"   "+rs.getString(7));
			UserCrudUtil.printTableRows(rs);
		}else {
			System.out.println("User Not found!!!");
		}
	}
	
	//Edit User Details
	public int editUserDetails(int id) throws SQLException, ParseException {
		con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from usercrud where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Scanner sc=new Scanner(System.in);
			boolean isValid = true;
			String fname;
			String lname;
			int age=0;
			String gender;
			String subject;
			String dob;
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

//			Lname
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

///		Age
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
					isValid=false;
				}
			} while (!isValid);


//			Gender
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

//			Subject
			do {
				System.out.println("Enter Subject:");
				subject = sc.nextLine();
				
					if(subject.equalsIgnoreCase("java") || subject.equalsIgnoreCase("python") || subject.equalsIgnoreCase("dotnet") || subject.equalsIgnoreCase("javascript") || subject.equalsIgnoreCase("html") || subject.equalsIgnoreCase("oracle") || subject.equalsIgnoreCase("mysql")) {
						isValid=true;
					}else {
						isValid=false;
						System.out.println("Invalid Input Try Again!!!");
					}
			}while(!isValid);

//			DOB
			do {
				System.out.println("Enter DOB(DD/MM/YYYY):");
				dob = sc.nextLine();
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date = sdf.parse(dob);
				java.util.Date currentDate=new java.util.Date();
				currentDate=sdf.parse(sdf.format(currentDate));
				if (date.compareTo(currentDate)>=0) {
					System.out.println("Wrong Date Input Try Again!!!");
					isValid = false;
				} else {
					isValid = true;
				}
			} while (!isValid);

//			Address
			System.out.println("Enter Address:");
			address = sc.nextLine();

			
			con=DBConnection.getConnection();
			ps=con.prepareStatement("update usercrud set fname=?,lname=?,age=?,gender=?,subject=?,dob=?,address=? where id=?");
			ps.setInt(8, id);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setString(5, subject);
			Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
			long dob1=date.getTime();
			ps.setDate(6, new java.sql.Date(dob1));
			ps.setString(7, address);
			
			int k=ps.executeUpdate();
			return k;
		}else {
			return 0;
		}
		
		
	}
	
	//Delete User
	public int deleteUser(int id) throws SQLException {
		con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from usercrud where id=?");
		ps.setInt(1, id);
		int k=ps.executeUpdate();
		return k;
	}
	
	//Get All USers
	public void getAllUsers() throws SQLException {
		con=DBConnection.getConnection();
		Statement ps=con.createStatement();
		ResultSet rs=ps.executeQuery("select * from usercrud");
//		System.out.println("ID FirstName LastName Age Gender Subject     DOB       Address");
//		System.out.printf("%-5s","ID");
//		System.out.printf("%-15s","FirstName");
//		System.out.printf("%-15s","LastName");
//		System.out.printf("%-5s","Age");
//		System.out.printf("%-10s","Gender");
//		System.out.printf("%-12s","Subject");
//		System.out.printf("%-12s","DOB");
//		System.out.printf("%-40s","Address");
//		System.out.println();
		UserCrudUtil.printTableHeader();
		
		while(rs.next()) {
//			System.out.printf("%-5s",rs.getInt(8));
//			System.out.printf("%-15s",rs.getString(1));
//			System.out.printf("%-15s",rs.getString(2));
//			System.out.printf("%-5s",rs.getInt(3));
//			System.out.printf("%-10s",rs.getString(4));
//			System.out.printf("%-12s",rs.getString(5));
//			System.out.printf("%-12s",rs.getDate(6));
//			System.out.printf("%-40s",rs.getString(7));
//			System.out.println();
//			System.out.println(rs.getInt(8)+"   "+rs.getString(1)+"      "+rs.getString(2)+"   "+rs.getInt(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"    "+rs.getDate(6)+"   "+rs.getString(7));
			UserCrudUtil.printTableRows(rs);
		}
		
	}

}
