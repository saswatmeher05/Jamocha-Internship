package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.model.CourseMybatis;

public class CourseMybatisDao {
	public List<CourseMybatis> getList() {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		try {
			List<CourseMybatis> list = session.selectList("CourseMybatis.selectStudentsJoin");
			return list;
		} finally {
			session.close();
		}
	}

	public List<CourseMybatis> selectCourseById(int id) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSqlSessionfactory();
		SqlSession session = factory.openSession();
		try {
			List<CourseMybatis> list = session.selectList("CourseMybatis.selectCourseById", id);
			return list;
		} finally {
			session.close();
		}
	}

}
