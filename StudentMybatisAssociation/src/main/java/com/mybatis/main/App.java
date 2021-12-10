package com.mybatis.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mybatis.model.CourseMybatis;
import com.mybatis.model.StudentMybatis;
import com.mybatis.service.CourseMybatisService;
import com.mybatis.service.CourseMybatisServiceImpl;
import com.mybatis.service.StudentMyBatisServiceImpl;
import com.mybatis.service.StudentMybatisService;
import com.mybatis.util.CourseBatisUtils;
import com.mybatis.util.StudentBatisUtil;

public class App {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		StudentMybatisService service = new StudentMyBatisServiceImpl();
		CourseMybatisService cservice=new CourseMybatisServiceImpl();
		boolean flag = true;
		do {
			System.out.println("Select One Option:\n" + "1.Insert Student:\n" + "2.Get Student By ID:\n"
					+ "3.Update Student Details:\n" + "4.Delete Student:\n" + "5.Get All Students:\n"
					+ "6.Get All Data(Students):\n" + "7.Get All Data(Courses-Student):\n"
							+ "8.Get Students with Course ID:\n"
							+ "9.Exit");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				System.out.println(service.insert(new StudentMybatis()));
				break;
			case 2:
				System.out.println("Enter id:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println(service.selectById(id));
				break;
			case 3:
				System.out.println("Enter id:");
				int id1 = Integer.parseInt(sc.nextLine());
				System.out.println(service.updateById(id1));
				break;
			case 4:
				System.out.println("Enter id:");
				int id2 = Integer.parseInt(sc.nextLine());
				System.out.println(service.deleteById(id2));
				break;
			case 5:
				StudentBatisUtil.printTableHeaderStudentOnly();
				List<StudentMybatis> list = service.getAll();
				for (StudentMybatis batis : list) {
					StudentBatisUtil.printTableDataStudentOnly(batis);
				}
				break;
			case 6:
				StudentBatisUtil.printTableHeaderAllData();
				List<StudentMybatis> list1=service.getAllJoin();
				for (StudentMybatis batis : list1) {
					StudentBatisUtil.printTableDataAll(batis);
				}
				break;
			case 7:
				List<CourseMybatis> cList=cservice.getList();
				for(CourseMybatis cbatis:cList) {
					CourseBatisUtils.printTableHeaderCourseOnly();
					CourseBatisUtils.printTableData(cbatis);
					System.out.println("-----------------------");
				}
				break;
			case 8:
				System.out.println("Enter Course ID to Fetch Student Details\n"
						+ "Available Courses:( 1.Java , 2.Python , 3.HTML , 4.php , 5.C++ , 6.JavaScript");
				int id3=Integer.parseInt(sc.nextLine());
				List<CourseMybatis> cList1=cservice.selectCourseById(id3);
				CourseBatisUtils.printTableHeaderCourseOnly();
				for(CourseMybatis utils:cList1) {
					CourseBatisUtils.printTableData(utils);
					}
				break;
			case 9:
				flag = false;
				break;
			}
		} while (flag);
		sc.close();
		
//		CourseMybatisService service=new CourseMybatisServiceImpl();
//		List<CourseMybatis> list=service.selectCourseById(2);
//		CourseBatisUtils.printTableHeaderCourseOnly();
//		for(CourseMybatis utils:list) {
//		CourseBatisUtils.printTableData(utils);
//		}

		
	}
}
