package com.employee.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.ui.Model;

import com.employee.model.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> getAllEmployees(Model model)throws IOException, ParseException;

	public String saveEmployee(EmployeeDTO employee);

	public String updateEmployee(EmployeeDTO employee);

	public EmployeeDTO findByID(int id);

	public String deleteEmployee(int id);

}
