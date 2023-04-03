package com.jspiders.springmvc.controller;

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
	
	//Home Controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	//Add Page Controller
	@GetMapping("/add")
	public String addPage() {
		return "Add";
	}
	
	//Add Data Controller
	@PostMapping("/add")
	public String add(@RequestParam String name,
						@RequestParam String email,
						@RequestParam long contact,
						@RequestParam String designation,
						@RequestParam double salary,
						ModelMap map) {
		EmployeePOJO employee = service.
				addEmployee(name, email, contact, designation, salary);
		if (employee != null) {
			//Success response
			map.addAttribute("msg", "Data added successfully..!!");
			return "Add";
		}
		//Failure response
		map.addAttribute("msg", "Data not added successfully..!!");
		return "Add";
	}

}
