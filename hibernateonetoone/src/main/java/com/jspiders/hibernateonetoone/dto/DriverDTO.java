package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class DriverDTO {
	
	@Id
	private int id;
	private String name;
	private long contact;
	@OneToOne
	private CarDTO car;

}
