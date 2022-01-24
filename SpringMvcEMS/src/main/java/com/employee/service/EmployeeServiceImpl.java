package com.employee.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.employee.dao.EmployeeMapper;
import com.employee.model.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public List<EmployeeDTO> getAllEmployees(Model model) throws IOException, ParseException {
		List<EmployeeDTO> list=employeeMapper.getAllEmployees();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("dd MMM yyyy");
		
		for(EmployeeDTO dto:list) {
			Date date=sdf.parse(dto.getDoj());
			dto.setDoj(String.valueOf(sdf1.format(date)));
			dto.setSkills(dto.getSkills().replaceAll(",", ", "));
		}
		return list;
	}
	
	@Override
	public String saveEmployee(EmployeeDTO employee) {
		int k=employeeMapper.saveEmployee(employee);
		if (k > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
		
	@Override
	public EmployeeDTO findByID(int id) {
		EmployeeDTO dto=employeeMapper.findByID(id);
		return dto;
	}
	
	@Override
	public String updateEmployee(EmployeeDTO employee) {
		int k=employeeMapper.updateEmployee(employee);
		if (k > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@Override
	public String deleteEmployee(int id) {
		int k=employeeMapper.deleteEmployee(id);
		if (k > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
}
