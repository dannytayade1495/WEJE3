package com.jspiders.springcoreannotation.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class CarBean {
	
	@Value("1")
	private int id;
	@Value("Tata")
	private String brand;
	@Value("Harrier")
	private String model;
	@Value("MH14XY4567")
	private String regno;
	@Autowired
	private DriverBean driver;

}
