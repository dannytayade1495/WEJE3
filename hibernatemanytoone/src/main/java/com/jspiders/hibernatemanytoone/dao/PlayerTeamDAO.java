package com.jspiders.hibernatemanytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytoone.dto.PlayerDTO;
import com.jspiders.hibernatemanytoone.dto.TeamDTO;

public class PlayerTeamDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToOne");
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
			
			TeamDTO team = new TeamDTO();
			team.setId(1);
			team.setName("Mumbai Indians");
			team.setCoach("Zaheer Khan");
			team.setCity("Mumbai");
			manager.persist(team);
			
			PlayerDTO player1 = new PlayerDTO();
			player1.setId(1);
			player1.setName("Rohit Sharma");
			player1.setRole("Batsman");
			player1.setJersey_no(45);
			player1.setTeam(team);
			manager.persist(player1);
			
			PlayerDTO player2 = new PlayerDTO();
			player2.setId(2);
			player2.setName("Jasprit Bumrah");
			player2.setRole("Bowler");
			player2.setJersey_no(93);
			player2.setTeam(team);
			manager.persist(player2);
			
			PlayerDTO player3 = new PlayerDTO();
			player3.setId(3);
			player3.setName("S K Yadav");
			player3.setRole("Batsman");
			player3.setJersey_no(63);
			player3.setTeam(team);
			manager.persist(player3);
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
