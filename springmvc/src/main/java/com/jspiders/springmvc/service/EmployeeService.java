package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.EmployeePOJO;
import com.jspiders.springmvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public EmployeePOJO addEmployee(String name, String email, 
									long contact, String designation,
									double salary) {
		EmployeePOJO employee = repository.
				addEmployee(name, email, contact, designation, salary);
		return employee;
	}

	public EmployeePOJO searchEmployee(int id) {
		EmployeePOJO employee = repository.searchEmployee(id);
		return employee;
	}

	public List<EmployeePOJO> searchAllEmployees() {
		List<EmployeePOJO> employees = repository.searchAllEmployees();
		return employees;
	}

	public void removeEmployee(int id) {
		repository.removeEmployee(id);
	}

	public void updateEmployee(int id, String name, String email, long contact, String designation, double salary) {
		repository.updateEmployee(id, name, email, contact, designation, salary);
		
	}

}
