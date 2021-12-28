package com.employee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.dao.EmployeeMapper;
import com.employee.model.EmployeeDTO;

@Controller @RequestMapping("/ems") 
public class EmployeeController {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@RequestMapping("/listOfEmployee")
	public String showEmployeeList(Model model) throws IOException {
		model.addAttribute("employeeList",employeeMapper.getAllEmployees());
		return "ListEmployees";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new EmployeeDTO());
		return "addEmployee";
	}
	
	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employee,Model model) {
		if(employee.getId()==null) {
			employeeMapper.saveEmployee(employee);
		}else {
			employeeMapper.updateEmployee(employee);
		}
		return "redirect:/ems/listOfEmployee";
	}
	
	@RequestMapping("/displayUpdateForm")
	public String updateEmployee(@RequestParam("id") int id,Model model) {
		model.addAttribute("employee", employeeMapper.findByID(id));
		return "addEmployee";
	}
	
	@RequestMapping("/displayDeleteForm")
	public String deleteEmployee(@RequestParam("id") int id, Model model) {
		String s=employeeMapper.deleteEmployee(id);
		model.addAttribute("delMsg",s);
		return "forward:/ems/listOfEmployee";
	}
	
	//Error Pages
	
	@RequestMapping(value="/404")
	public String page404(Model model) {
		return "404";
	}
	
	@RequestMapping(value="/500")
	public String page500(Model model) {
		return "500";
	}
}
