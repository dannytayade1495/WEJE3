package com.jspiders.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest.pojo.EmployeePOJO;
import com.jspiders.springrest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public EmployeePOJO addEmployee(EmployeePOJO employee) {
		EmployeePOJO pojo = repository.addEmployee(employee);
		return pojo;
	}

	public EmployeePOJO searchEmployee(int id) {
		EmployeePOJO pojo = repository.searchEmployee(id);
		return pojo;
	}

}
