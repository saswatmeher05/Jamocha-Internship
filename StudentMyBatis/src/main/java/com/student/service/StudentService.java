package com.student.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.student.dao.MyBatisUtils;
import com.student.dao.Student_Mapper;
import com.student.vo.StudentVO;

public class StudentService {
	public List<StudentVO> getAllStudents() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		try {
			Student_Mapper mapper = sqlSession.getMapper(Student_Mapper.class);
			return mapper.getAll();
		}finally {
			sqlSession.close();
		}
	}
	
	public void insert(StudentVO vo) {
		SqlSession sqlSession=MyBatisUtils.getSqlSessionFactory().openSession();
		try {
			Student_Mapper mapper = sqlSession.getMapper(Student_Mapper.class);
			mapper.insert(vo);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	public StudentVO getById(int id) {
		SqlSession sqlSession=MyBatisUtils.getSqlSessionFactory().openSession();
		try {
			Student_Mapper mapper = sqlSession.getMapper(Student_Mapper.class);
			StudentVO vo=mapper.getById(id);
			sqlSession.commit();
			return vo;
		}finally {
			sqlSession.close();
		}
	}
	
	public void updateById(StudentVO vo) {
		SqlSession session=MyBatisUtils.getSqlSessionFactory().openSession();
		try{
			Student_Mapper mapper=session.getMapper(Student_Mapper.class);
			mapper.updateById(vo);
			session.commit();
		}
		finally {
			session.close();
		}
	}
	
	public void deleteById(int id) {
		SqlSession session=MyBatisUtils.getSqlSessionFactory().openSession();
		try {
			Student_Mapper mapper=session.getMapper(Student_Mapper.class);
			mapper.deleteById(id);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
