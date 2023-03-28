package com.jspiders.hibernatemanytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytomany.dto.CustomerDTO;
import com.jspiders.hibernatemanytomany.dto.ProductDTO;

public class ProductCustomerDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToMany");
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
			
			ProductDTO product1 = new ProductDTO();
			product1.setId(1);
			product1.setName("Jeans");
			product1.setCategory("Clothing");
			product1.setPrice(2000);
			
			ProductDTO product2 = new ProductDTO();
			product2.setId(2);
			product2.setName("Biscuits");
			product2.setCategory("Food");
			product2.setPrice(20);
			
			ProductDTO product3 = new ProductDTO();
			product3.setId(3);
			product3.setName("Shoes");
			product3.setCategory("Footwear");
			product3.setPrice(80000);
			
			CustomerDTO customer1 = new CustomerDTO();
			customer1.setId(1);
			customer1.setName("Shivani");
			customer1.setContact(98765412430L);
			customer1.setCity("Pune");
			
			CustomerDTO customer2 = new CustomerDTO();
			customer2.setId(2);
			customer2.setName("Anuj");
			customer2.setContact(98765002430L);
			customer2.setCity("Mumbai");
			
			CustomerDTO customer3 = new CustomerDTO();
			customer3.setId(3);
			customer3.setName("Anushka");
			customer3.setContact(98535412430L);
			customer3.setCity("Banglore");
			
			List<ProductDTO> products1 = Arrays.
					asList(product1, product3);
			customer1.setProducts(products1);
			manager.persist(customer1);
			
			List<ProductDTO> products2 = Arrays.
					asList(product1, product2);
			customer2.setProducts(products2);
			manager.persist(customer2);
			
			List<ProductDTO> products3 = Arrays.
					asList(product2, product3);
			customer3.setProducts(products3);
			manager.persist(customer3);
			
			List<CustomerDTO> customers1 = Arrays.
					asList(customer1, customer2);
			product1.setCustomers(customers1);
			manager.persist(product1);
			
			List<CustomerDTO> customers2 = Arrays.
					asList(customer2, customer3);
			product2.setCustomers(customers2);
			manager.persist(product2);
			
			List<CustomerDTO> customers3 = Arrays.
					asList(customer1, customer3);
			product3.setCustomers(customers3);
			manager.persist(product3);
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
