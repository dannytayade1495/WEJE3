package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.CarDTO;
import com.jspiders.hibernateonetoone.dto.DriverDTO;

public class CarDriverDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToOne");
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
			
			CarDTO car = new CarDTO();
			car.setId(1);
			car.setBrand("Tata");
			car.setModel("Nexon");
			car.setRegNo("MH14AB1234");
			
			DriverDTO driver = new DriverDTO();
			driver.setId(1);
			driver.setName("Akshay");
			driver.setContact(9871245603L);
			
			car.setDriver(driver);
			manager.persist(car);
			
			driver.setCar(car);
			manager.persist(driver);
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}
	}
}
