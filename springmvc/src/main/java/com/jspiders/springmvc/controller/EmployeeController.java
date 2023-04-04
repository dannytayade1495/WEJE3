package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.EmployeePOJO;
import com.jspiders.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// Home Controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	// Add Page Controller
	@GetMapping("/add")
	public String addPage() {
		return "Add";
	}

	// Add Data Controller
	@PostMapping("/add")
	public String add(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String designation, @RequestParam double salary, ModelMap map) {
		EmployeePOJO employee = service.addEmployee(name, email, contact, designation, salary);
		if (employee != null) {
			// Success response
			map.addAttribute("msg", "Data added successfully..!!");
			return "Add";
		}
		// Failure response
		map.addAttribute("msg", "Data not added successfully..!!");
		return "Add";
	}

	// Search Page Controller
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}

	// Search Data Controller
	@PostMapping("/search")
	public String search(@RequestParam int id, ModelMap map) {
		EmployeePOJO employee = service.searchEmployee(id);
		if (employee != null) {
			// Success response
			map.addAttribute("msg", "Employee data found..!!");
			map.addAttribute("emp", employee);
			return "Search";
		}
		// Failure response
		map.addAttribute("msg", "Data not found..!!");
		return "Search";
	}

	// Remove Page Controller
	@GetMapping("/remove")
	public String removePage(ModelMap map) {
		List<EmployeePOJO> employees = service.searchAllEmployees();
		map.addAttribute("empList", employees);
		return "Remove";
	}

	// Remove Data Controller
	@PostMapping("/remove")
	public String remove(@RequestParam int id, ModelMap map) {
		EmployeePOJO employee = service.searchEmployee(id);
		if (employee != null) {
			// Success response
			service.removeEmployee(id);
			List<EmployeePOJO> employees = service.searchAllEmployees();
			map.addAttribute("empList", employees);
			map.addAttribute("msg", "Data removed successfully..!!");
			return "Remove";
		}
		// Failure response
		List<EmployeePOJO> employees = service.searchAllEmployees();
		map.addAttribute("empList", employees);
		map.addAttribute("msg", "Data does not exist..!!");
		return "Remove";
	}

}
