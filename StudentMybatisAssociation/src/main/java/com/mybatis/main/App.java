package com.mybatis.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mybatis.model.StudentMybatis;
import com.mybatis.service.StudentMyBatisServiceImpl;
import com.mybatis.service.StudentMybatisService;

public class App {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		StudentMybatisService service = new StudentMyBatisServiceImpl();
		boolean flag = true;
		do {
			System.out.println("Select One Option:\n" + "1.Insert Student:\n" + "2.Get Student By ID:\n"
					+ "3.Update Student Details:\n" + "4.Delete Student:\n" + "5.Get All Students:\n" + "6.Exit:");
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
				List<StudentMybatis> list = service.getAll();
				for (StudentMybatis batis : list) {
					System.out.println(batis);
				}
				break;
			case 6:
				flag = false;
				break;
			}
		} while (flag);
		sc.close();
	}
}
