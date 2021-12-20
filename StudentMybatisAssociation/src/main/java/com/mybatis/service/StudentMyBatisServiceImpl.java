package com.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mybatis.dao.StudentMybatisDao;
import com.mybatis.model.StudentMybatis;

public class StudentMyBatisServiceImpl implements StudentMybatisService {
	public StudentMybatisDao dao;
	public Map<String, String> dyanmicQuery = new HashMap<String, String>();
	public StringBuilder dynamicSelectStudent = new StringBuilder("select * from studentmybatis");
	public StringBuilder dynamicSelectColumn = new StringBuilder();

	public StudentMyBatisServiceImpl() {
		dao = new StudentMybatisDao();
	}

	@Override
	public StudentMybatis selectById(int id) {
		StudentMybatis batis = dao.selectById(id);
		return batis;
	}

	@Override
	public List<StudentMybatis> getAll() {
		List<StudentMybatis> list = dao.getAll();
		return list;
	}

	@Override
	public String insert(StudentMybatis batis) {
		String message = dao.insert(batis);
		return message;
	}

	@Override
	public String updateById(int id) {
		StudentMybatis batis = dao.selectById(id);
		if (batis != null) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name:");
			batis.setSname(sc.nextLine());
			System.out.println("Enter Age:");
			batis.setSage(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Course ID\n"
					+ "Available Courses:( 1.Java , 2.Python , 3.HTML , 4.php , 5.C++ , 6.JavaScript");
			batis.setCid(Integer.parseInt(sc.nextLine()));
			dao.updateById(batis);
			return "update successful";
		} else {
			return "User with id=" + id + " not found";
		}
	}

	@Override
	public String deleteById(int id) {
		StudentMybatis batis = dao.selectById(id);
		if (batis != null) {
			dao.deleteById(batis);
			return "Delete Successful";
		} else {
			return "User with id=" + id + " not found";
		}
	}

	@Override
	public List<StudentMybatis> getAllJoin() {
		List<StudentMybatis> list = dao.getAllJoin();
		return list;
	}

	@Override
	public StudentMybatis selectDynamic(StudentMybatis batis) {
		if (batis.getSid() != 0) {
			dynamicSelectStudent.append(" where sid=" + batis.getSid());
		} else if (batis.getSname() != null) {
			dynamicSelectStudent.append(" where sname=" + batis.getSname());
		}
		dyanmicQuery.put("key1", dynamicSelectStudent.toString());
		StudentMybatis batis1 = dao.selectDynamic(dyanmicQuery);
		return batis1;
	}

	@Override
	public List<StudentMybatis> selectDynamicColumns() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("Enter Column Name(sid,sname,sage,cid):");
			String s = sc.nextLine().toLowerCase();
			dynamicSelectColumn.append(s).append(",");
			System.out.println("select more(y/n):");
			s = sc.nextLine();
			if (s.equals("y"))
				flag = true;
			else
				flag = false;
		} while (flag);

		dynamicSelectColumn.deleteCharAt(dynamicSelectColumn.length() - 1);

		dyanmicQuery.put("cols", dynamicSelectColumn.toString());

		List<StudentMybatis> list = dao.selectDynamicColumns(dyanmicQuery);

		return list;
	}
}
