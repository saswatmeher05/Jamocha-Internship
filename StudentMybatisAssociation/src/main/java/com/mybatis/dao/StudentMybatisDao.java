package com.mybatis.dao;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.model.StudentMybatis;

public class StudentMybatisDao {
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

	public String insert(StudentMybatis batis) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Name:");
			batis.setSname(sc.nextLine());
			System.out.println("Enter Age");
			batis.setSage(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter Course ID\n"
					+ "Available Courses:( 1.Java , 2.Python , 3.HTML , 4.php , 5.C++ , 6.JavaScript");
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

}
