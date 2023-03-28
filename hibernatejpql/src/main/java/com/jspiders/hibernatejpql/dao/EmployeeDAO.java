package com.jspiders.hibernatejpql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernatejpql.dto.EmployeeDTO;

public class EmployeeDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("jpql");
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
			
			jpql = "from EmployeeDTO";
			query = manager.createQuery(jpql);
			
			List<EmployeeDTO> employees = query.getResultList();
			for(EmployeeDTO employee : employees) {
				System.out.println(employee);
			}
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
