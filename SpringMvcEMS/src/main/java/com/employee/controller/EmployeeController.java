package com.employee.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.employee.model.EmployeeDTO;
import com.employee.service.EmployeeService;
import com.employee.util.EmployeeDataExcelExport;
import com.employee.util.EmployeeDataPdfExport;

@Controller
@RequestMapping("/ems")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/employeeList")
	public String showEmployeeList(Model model) throws IOException, ParseException {
		List<EmployeeDTO> list = employeeService.getAllEmployees(model);
		model.addAttribute("employeeList", list);
		return "EmployeeStatusScreen";
	}

	@GetMapping("/showFormForAdd")
	public String EmployeeFormScreen(Model model) {
		model.addAttribute("employee", new EmployeeDTO());
		return "EmployeeFormScreen";
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employee, Model model, HttpSession session,
			RedirectAttributes ra) {
		if (employee.getId() == null) {
			String s = employeeService.saveEmployee(employee);
//			session.setAttribute("saveMsg", s);
			ra.addFlashAttribute("saveMsg", s);
			return "redirect:/ems/employeeList";
		} else {
			String s = employeeService.updateEmployee(employee);
			session.setAttribute("updtMsg", s);
			return "redirect:/ems/employeeList";
		}
	}

	@GetMapping("/displayUpdateForm")
	public String updateEmployee(@RequestParam("id") int id, Model model) {
		EmployeeDTO dto = employeeService.findByID(id);
		model.addAttribute("employee", dto);
		return "EmployeeFormScreen";
	}

	@GetMapping("/displayDeleteForm")
	public String deleteEmployee(@RequestParam("id") int id, Model model, HttpSession session) {
		String s = employeeService.deleteEmployee(id);
		session.setAttribute("delMsg", s);
		return "redirect:/ems/employeeList";
	}
	
	@GetMapping("/excelexport")
	public ModelAndView exportToExcel(Model model,HttpSession session) throws IOException, ParseException {
		ModelAndView mav=new ModelAndView();
		mav.setView(new EmployeeDataExcelExport());
		//read data from db
		List<EmployeeDTO> list=employeeService.getAllEmployees(model);
		//session.setAttribute("expMsg", "Exported To Excel");
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/pdfexport")
	public ModelAndView exportToPdf(Model model) throws IOException, ParseException {
		ModelAndView mav=new ModelAndView();
		mav.setView(new EmployeeDataPdfExport());
		//read data from db
		List<EmployeeDTO> list=employeeService.getAllEmployees(model);
		mav.addObject("list",list);
		return mav;
	}

	// Error Pages
	@GetMapping("/404")
	public String page404(Model model) {
		return "404";
	}

	@GetMapping("/500")
	public String page500(Model model) {
		return "500";
	}

}
