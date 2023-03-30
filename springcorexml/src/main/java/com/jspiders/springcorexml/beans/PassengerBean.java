package com.jspiders.springcorexml.beans;

import lombok.Data;

@Data
public class PassengerBean {

	private int id;
	private String name;
	private int age;
	private char gender;
	private TrainBean train;

}
