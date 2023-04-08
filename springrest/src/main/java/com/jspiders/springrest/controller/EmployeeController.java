package com.jspiders.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.EmployeePOJO;
import com.jspiders.springrest.response.EmployeeResponse;
import com.jspiders.springrest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(path = "/add",
				consumes = {MediaType.APPLICATION_JSON_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeePOJO employee) {
		EmployeePOJO pojo = service.addEmployee(employee);
		if (pojo != null) {
			//Success
			return new ResponseEntity<EmployeeResponse>(new EmployeeResponse("OK", "Employee data added. ", pojo, null), HttpStatus.ACCEPTED);
		}
		//Failure
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse("FAIL", "Employee data not added. ", null, null), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(path = "/search/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EmployeeResponse> searchEmployee(@PathVariable int id){
		EmployeePOJO pojo = service.searchEmployee(id);
		if (pojo != null) {
			//Success
			return new ResponseEntity<EmployeeResponse>(new EmployeeResponse("OK", "Employee data found. ", pojo, null), HttpStatus.FOUND);
		}
		//Failure
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse("FAIL", "Employee data not found. ", null, null), HttpStatus.NOT_FOUND);
	}

}
