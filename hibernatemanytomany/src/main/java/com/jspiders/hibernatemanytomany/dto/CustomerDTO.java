package com.jspiders.hibernatemanytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class CustomerDTO {
	
	@Id
	private int id;
	private String name;
	private long contact;
	private String city;
	@ManyToMany
	private List<ProductDTO> products;

}
