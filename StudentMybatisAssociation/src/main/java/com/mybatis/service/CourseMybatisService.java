package com.mybatis.service;

import java.util.List;

import com.mybatis.model.CourseMybatis;

public interface CourseMybatisService {
	public List<CourseMybatis> getList();
	public List<CourseMybatis> selectCourseById(int id);
}
