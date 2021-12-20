package com.mybatis.service;

import java.util.List;

import com.mybatis.dao.CourseMybatisDao;
import com.mybatis.model.CourseMybatis;

public class CourseMybatisServiceImpl implements CourseMybatisService {
	public CourseMybatisDao dao;

	public CourseMybatisServiceImpl() {
		dao = new CourseMybatisDao();
	}

	@Override
	public List<CourseMybatis> getList() {
		List<CourseMybatis> list = dao.getList();
		return list;
	}

	@Override
	public List<CourseMybatis> selectCourseById(int id) {
		List<CourseMybatis> list = dao.selectCourseById(id);
		return list;
	}
}
