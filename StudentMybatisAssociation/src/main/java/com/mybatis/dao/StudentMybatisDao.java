package com.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.model.StudentMybatis;

public class StudentMybatisDao {
	
	/*
	 * Get Student By ID
	 */
	public StudentMybatis selectById(int id) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		
		try {
			StudentMybatis sbt = session.selectOne("StudentMybatis.selectById", id);
			return sbt;
		} finally {
			session.close();
		}
	}

	/*
	 * Get All Students
	 */
	public List<StudentMybatis> getAll() {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		
		try {
			List<StudentMybatis> list = session.selectList("StudentMybatis.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	/*
	 * Insert Student
	 */
	public String insert(StudentMybatis batis) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Name:");
			batis.setSname(sc.nextLine());
			System.out.println("Enter Age");
			batis.setSage(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Course ID\n"
					+ "Available Courses:( 1.Java , 2.Python , 3.HTML , 4.php , 5.C++ , 6.JavaScript , 7.Oracle");
			batis.setCid(Integer.parseInt(sc.nextLine()));

			int k = session.insert("StudentMybatis.insert", batis);
			session.commit();
			if (k > 0)
				return "Student inserted successfully";
			else
				return "failed";
		} finally {
			session.close();
		}
	}
	
	/*
	 * Update Student By ID
	 */
	public void updateById(StudentMybatis batis) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		
		try {
			session.update("StudentMybatis.updateById", batis);
			session.commit();
		} finally {
			session.close();
		}
	}

	/*
	 * Delete Student By ID
	 */
	public void deleteById(StudentMybatis batis) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		
		try {
			session.delete("StudentMybatis.deleteById", batis);
			session.commit();
		} finally {
			session.close();
		}
	}

	/*
	 * Get Student and Course Details with Association(join)
	 */
	public List<StudentMybatis> getAllJoin() {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		
		try {
			List<StudentMybatis> list = session.selectList("StudentMybatis.getAllJoin");
			return list;
		} finally {

		}
	}

	/*
	 * Get Student Details By ID Using Dynamic Query
	 */
	public StudentMybatis selectDynamic(Map<String, String> dynamicQuery) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		
		try {
			StudentMybatis sbt = session.selectOne("StudentMybatis.selectDynamic",(HashMap<String, String>) dynamicQuery);
			return sbt;
		} finally {
			session.close();
		}
	}
	
	
	/*
	 * Get All Students With Specific Columns Using Dynamic Query
	 */
	public List<StudentMybatis> selectDynamicColumns(Map<String, String> dyanmicQuery) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		
		try {
			List<StudentMybatis> list = session.selectList("StudentMybatis.selectDynamicColumn",
					(HashMap<String, String>) dyanmicQuery);
			return list;
		} finally {
			session.close();
		}
	}

}
