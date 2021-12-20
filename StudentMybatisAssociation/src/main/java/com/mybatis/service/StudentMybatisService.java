package com.mybatis.service;

import java.util.List;

import com.mybatis.model.StudentMybatis;

public interface StudentMybatisService {
//	Get Student By ID
	public StudentMybatis selectById(int id);

//	Get All Students
	public List<StudentMybatis> getAll();

//	Insert Students
	public String insert(StudentMybatis batis);

//	Update Student By ID
	public String updateById(int id);

//	Delete Student By ID
	public String deleteById(int id);

//	Get Student and Course Details with Association(join)
	public List<StudentMybatis> getAllJoin();

//	Get Student Details by ID Using Dynamic Query
	public StudentMybatis selectDynamic(StudentMybatis batis);

//	Get All Students With Specific Columns Using Dynamic Query
	public List<StudentMybatis> selectDynamicColumns();
}
