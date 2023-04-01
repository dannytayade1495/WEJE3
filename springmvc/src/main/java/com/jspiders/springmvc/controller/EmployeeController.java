package com.jspiders.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	
	//Home Controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}

}
