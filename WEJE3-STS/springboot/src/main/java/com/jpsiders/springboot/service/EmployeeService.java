package com.jpsiders.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpsiders.springboot.pojo.EmployeePOJO;
import com.jpsiders.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public EmployeePOJO addEmployee(EmployeePOJO employee) {
		EmployeePOJO pojo = repository.save(employee);
		return pojo;
	}

	public EmployeePOJO searchEmployee(int id) {
		EmployeePOJO pojo = repository.findById(id).orElse(null);
		return pojo;
	}

}
