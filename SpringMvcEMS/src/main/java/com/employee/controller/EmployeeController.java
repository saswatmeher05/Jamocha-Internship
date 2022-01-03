package com.employee.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.employee.model.EmployeeDTO;
import com.employee.service.EmployeeService;

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
//			model.addAttribute("saveMsg",s);
//			session.setAttribute("saveMsg", s);
			ra.addFlashAttribute("saveMsg", s);
			return "redirect:/ems/employeeList";
		} else {
			String s = employeeService.updateEmployee(employee);
//			model.addAttribute("updtMsg",s);
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
//		model.addAttribute("delMsg", s);
		session.setAttribute("delMsg", s);
		return "redirect:/ems/employeeList";
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
