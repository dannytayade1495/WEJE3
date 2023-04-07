package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private String jpql;

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

	public AdminPOJO addAdmin(String username, String password) {
		openConnection();
		transaction.begin();
		AdminPOJO admin = new AdminPOJO();
		admin.setUsername(username);
		admin.setPassword(password);
		manager.persist(admin);
		transaction.commit();
		closeConnection();
		return admin;
	}

	public AdminPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "from AdminPOJO "
				+ "where username = '" + username + "' "
				+ "and password = '" + password + "'";
		query = manager.createQuery(jpql);
		List<AdminPOJO> list = query.getResultList();
		for (AdminPOJO admin : list) {
			transaction.commit();
			closeConnection();
			return admin;
		}
		transaction.commit();
		closeConnection();
		return null;
	}


}
