package com.student.dao;

import org.apache.ibatis.annotations.AutomapConstructor;

import com.student.service.StudentService;

public class StudentDAO {
	public StudentService service;

	public StudentDAO() {
		this.service = new StudentService();
	}
	
	

}
