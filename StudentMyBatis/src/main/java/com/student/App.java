package com.student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.student.service.StudentService;
import com.student.util.StudentUtil;
import com.student.vo.StudentVO;

public class App {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		StudentService service = new StudentService();
		StudentVO vo = new StudentVO();
		int id = 0;
		boolean flag = true;
		do {
			System.out.println("Chose one option:");
			System.out.println("1.Insert Student");
			System.out.println("2.Get Student By Id");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println("5.Get All Students");
			System.out.println("6.Exit");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				System.out.println("Enter Name:");
				String name = sc.nextLine();
				System.out.println("Enter age:");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Gender(male/female):");
				String gender = sc.nextLine();
				System.out.println("Enter Subject:");
				String subject = sc.nextLine();
				System.out.println("Enter dob:");
				String dob = sc.nextLine();
				System.out.println("Enter Email:");
				String email = sc.nextLine();
				vo = new StudentVO();
				vo.setName(name);
				vo.setAge(age);
				vo.setGender(gender);
				vo.setSubject(subject);
				vo.setDob(dob);
				vo.setEmail(email);
				service.insert(vo);
				System.out.println("Student Inserted Successfully");
				System.out.println("------------------------------------------------------------------------------");
				break;
			case 2:
				System.out.println("Enter id:");
				id = Integer.parseInt(sc.nextLine());
				vo = service.getById(id);
				if (vo == null || vo.getId() != id) {
					System.out.println("Cant find Student with ID=" + id);
				} else {
					StudentUtil.printTableHeader();
					StudentUtil.printTableData(vo);
					System.out
							.println("------------------------------------------------------------------------------");
				}
				break;
			case 3:
				System.out.println("Enter id:");
				id = Integer.parseInt(sc.nextLine());
				vo = service.getById(id);
				if (vo == null || id != vo.getId()) {
					System.out.println("Cant find Student with ID=" + id);
				} else {
					System.out.println("Enter Name:");
					name = sc.nextLine();
					System.out.println("Enter age:");
					age = Integer.parseInt(sc.nextLine());
					System.out.println("Enter Gender(male/female):");
					gender = sc.nextLine();
					System.out.println("Enter Subject:");
					subject = sc.nextLine();
					System.out.println("Enter dob:");
					dob = sc.nextLine();
					System.out.println("Enter Email:");
					email = sc.nextLine();
					vo.setName(name);
					vo.setAge(age);
					vo.setGender(gender);
					vo.setSubject(subject);
					vo.setDob(dob);
					vo.setEmail(email);
					service.updateById(vo);
					System.out.println("Student Updated Successfully..");
					System.out
							.println("------------------------------------------------------------------------------");
				}
				break;
			case 4:
				System.out.println("Enter ID to Delete Student:");
				id = Integer.parseInt(sc.nextLine());
				vo = service.getById(id);
				if (vo == null || vo.getId() != id) {
					System.out.println("Student with ID=" + id + " not found!!");
					System.out
							.println("------------------------------------------------------------------------------");
				} else {
					service.deleteById(id);
					System.out.println("Student deleted Successfully..");
					System.out
							.println("------------------------------------------------------------------------------");
				}
				break;
			case 5:
				List<StudentVO> list = service.getAllStudents();
				StudentUtil.printTableHeader();
				for (StudentVO vos : list) {
					StudentUtil.printTableData(vos);
				}
				System.out.println("------------------------------------------------------------------------------");
				break;
			case 6:
				flag = false;
				break;
			}
		} while (flag);

		/*
		 * insert() System.out.println("Enter Name:"); String name = sc.nextLine();
		 * System.out.println("Enter age:"); int age = Integer.parseInt(sc.nextLine());
		 * System.out.println("Enter Gender(male/female):"); String gender =
		 * sc.nextLine(); System.out.println("Enter Subject:"); String subject =
		 * sc.nextLine(); System.out.println("Enter dob:"); String dob = sc.nextLine();
		 * System.out.println("Enter Email:"); String email = sc.nextLine();
		 * 
		 * StudentService service = new StudentService(); StudentVO vo = new
		 * StudentVO(); vo.setName(name); vo.setAge(age); vo.setGender(gender);
		 * vo.setSubject(subject); vo.setDob(dob); vo.setEmail(email);
		 * service.insert(vo);
		 * 
		 * getAllStudents() StudentService service=new StudentService(); List<StudentVO>
		 * list=service.getAllStudents(); for(StudentVO vo:list) {
		 * System.out.println(vo.getId()); System.out.println(vo.getName());
		 * System.out.println(vo.getAge()); System.out.println(vo.getGender());
		 * System.out.println(vo.getSubject()); System.out.println(vo.getDob());
		 * System.out.println(vo.getEmail());
		 * System.out.println("----------------------------------------"); }
		 * 
		 * getById(int id) System.out.println("Enter id:"); StudentService service=new
		 * StudentService(); int id=Integer.parseInt(sc.nextLine()); StudentVO
		 * vo=service.getById(id); if(vo==null) {
		 * System.out.println("Cant find Student with ID="+id); }else {
		 * System.out.println(vo.getId()); System.out.println(vo.getName());
		 * System.out.println(vo.getAge()); System.out.println(vo.getGender());
		 * System.out.println(vo.getSubject()); System.out.println(vo.getDob());
		 * System.out.println(vo.getEmail()); }
		 * 
		 * updateById() System.out.println("Enter id:"); StudentService service = new
		 * StudentService(); int id = Integer.parseInt(sc.nextLine()); StudentVO vo =
		 * service.getById(id); if (vo == null) {
		 * System.out.println("Cant find Student with ID=" + id); } else {
		 * System.out.println("Enter Name:"); String name = sc.nextLine();
		 * System.out.println("Enter age:"); int age = Integer.parseInt(sc.nextLine());
		 * System.out.println("Enter Gender(male/female):"); String gender =
		 * sc.nextLine(); System.out.println("Enter Subject:"); String subject =
		 * sc.nextLine(); System.out.println("Enter dob:"); String dob = sc.nextLine();
		 * System.out.println("Enter Email:"); String email = sc.nextLine();
		 * vo.setName(name); vo.setAge(age); vo.setGender(gender);
		 * vo.setSubject(subject); vo.setDob(dob); vo.setEmail(email);
		 * service.updateById(vo); }
		 * 
		 * deleteById StudentService service=new StudentService();
		 * System.out.println("Enter ID to Delete Student:"); int
		 * id=Integer.parseInt(sc.nextLine()); StudentVO vo=service.getById(id);
		 * if(vo==null || vo.getId()!=id) {
		 * System.out.println("Student with ID="+id+" not found!!"); }else {
		 * service.deleteById(id); }
		 */
		sc.close();
	}
}
