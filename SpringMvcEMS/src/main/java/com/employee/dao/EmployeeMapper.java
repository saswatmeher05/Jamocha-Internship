package com.employee.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeDTO;
import com.employee.util.MybatisConnectionFactory;

@Repository
public class EmployeeMapper {

	/*
	 * Get All Employees as List<EmployeeDTO>
	 */
	public List<EmployeeDTO> getAllEmployees() throws IOException, ParseException {
		SqlSessionFactory factory = MybatisConnectionFactory.getSessionFactory();
		SqlSession session = factory.openSession();
		List<EmployeeDTO> list = session.selectList("getAllEmployees");
		session.commit();
		session.close();
		return list;
	}

	/*
	 * Insert New Employee
	 */
	public int saveEmployee(EmployeeDTO employee) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSessionFactory();
		SqlSession session = factory.openSession();
		int k=session.insert("insert", employee);
		session.commit();
		session.close();
		return k;
	}

	/*
	 * Update Employee
	 */
	public int updateEmployee(EmployeeDTO employee) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSessionFactory();
		SqlSession session = factory.openSession();
		int k=session.update("update", employee);
		session.commit();
		session.close();
		return k;
	}

	/*
	 * Delete Employee
	 */
	public int deleteEmployee(int id) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSessionFactory();
		SqlSession session = factory.openSession();
		int k = session.delete("delete", id);
		session.commit();
		session.close();
		return k;
	}

	/*
	 * Get Employee By ID
	 */
	public EmployeeDTO findByID(int id) {
		SqlSessionFactory factory = MybatisConnectionFactory.getSessionFactory();
		SqlSession session = factory.openSession();
		EmployeeDTO employee = (EmployeeDTO) session.selectOne("findById", id);
		session.commit();
		session.close();
		return employee;
	}

}
