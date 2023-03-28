package com.jspiders.hibernateonetomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PlayerDTO {

	@Id
	private int id;
	private String name;
	private String role;
	private int jersey_no;

}
