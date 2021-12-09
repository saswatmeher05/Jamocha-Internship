package com.mybatis.service;

import java.util.List;

import com.mybatis.model.StudentMybatis;

public interface StudentMybatisService {
	public StudentMybatis selectById(int id);

	public List<StudentMybatis> getAll();

	public String insert(StudentMybatis batis);

	public String updateById(int id);

	public String deleteById(int id);
}
