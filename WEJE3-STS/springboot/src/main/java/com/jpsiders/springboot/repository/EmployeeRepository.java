package com.jpsiders.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpsiders.springboot.pojo.EmployeePOJO;

public interface EmployeeRepository extends JpaRepository<EmployeePOJO, Integer> {

}
