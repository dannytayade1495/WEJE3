package com.jspiders.springrest.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspiders.springrest.pojo.EmployeePOJO;

@Repository
public class EmployeeRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public EmployeePOJO addEmployee(EmployeePOJO employee) {
		openConnection();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		closeConnection();
		return employee;
	}

	public EmployeePOJO searchEmployee(int id) {
		openConnection();
		transaction.begin();
		EmployeePOJO pojo = manager.find(EmployeePOJO.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	
}
