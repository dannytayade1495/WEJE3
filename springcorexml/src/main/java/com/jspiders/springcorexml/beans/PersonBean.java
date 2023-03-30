package com.jspiders.springcorexml.beans;

import lombok.Data;

@Data
public class PersonBean {
	
	private int id;
	private String name;
	private String email;
	private long contact;
	private AadharBean aadhar;

}
