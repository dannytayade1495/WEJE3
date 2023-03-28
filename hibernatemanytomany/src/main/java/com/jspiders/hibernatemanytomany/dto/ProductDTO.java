package com.jspiders.hibernatemanytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class ProductDTO {

	@Id
	private int id;
	private String name;
	private String category;
	private double price;
	@ManyToMany(mappedBy = "products")
	private List<CustomerDTO> customers;

}
