package com.jspiders.hibernateannotations.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateannotations.dto.EmployeeDTO;

public class EmployeeDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.
				createEntityManagerFactory("annotations");
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

	public static void main(String[] args) {
		try {
			openConnection();
			
			transaction.begin();
			
			EmployeeDTO employee = new EmployeeDTO();
			employee.setEmployee_name("Aniket");
			employee.setEmployee_email("aniket@gmail.com");
			manager.persist(employee);
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
