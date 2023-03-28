package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CarDTO {

	@Id
	private int id;
	private String brand;
	private String model;
	private String regNo;
	@OneToOne
	private DriverDTO driver;

}
