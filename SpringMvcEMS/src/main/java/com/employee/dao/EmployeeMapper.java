package com.employee.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeDTO;
import com.employee.util.MybatisConnectionFactory;

@Repository
public class EmployeeMapper {
	
	/* 
	 * Get All Employees as List<EmployeeDTO> 
	 */
	public List<EmployeeDTO> getAllEmployees() throws IOException{
		SqlSessionFactory factory=MybatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		List<EmployeeDTO> list=session.selectList("getAllEmployees");
		session.commit();
		session.close();
		return list;
	}

	/* 
	 * Insert New Employee 
	 */
	public void saveEmployee(EmployeeDTO employee) {
		SqlSessionFactory factory=MybatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		session.insert("insert", employee);
		session.commit();
		session.close();
	}
	
	/* 
	 * Update Employee 
	 */
	public void updateEmployee(EmployeeDTO employee) {
		SqlSessionFactory factory=MybatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		session.update("update", employee);
		session.commit();
		session.close();
	}
	
	/* 
	 * Delete Employee 
	 */
	public void deleteEmployee(int id) {
		SqlSessionFactory factory=MybatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		session.delete("delete", id);
		session.commit();
		session.close();
	}
	
	/* 
	 * Get Employee By ID
	 */
	public EmployeeDTO findByID(int id) {
		SqlSessionFactory factory=MybatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		EmployeeDTO employee=(EmployeeDTO)session.selectOne("findById", id);
		session.commit();
		session.close();
		return employee;
	}
	
	
	
}
