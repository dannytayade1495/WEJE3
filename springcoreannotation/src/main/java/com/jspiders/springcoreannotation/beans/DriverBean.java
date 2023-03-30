package com.jspiders.springcoreannotation.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DriverBean {
	
	@Value("1")
	private int id;
	@Value("Vaibhav")
	private String name;
	@Value("8697452130")
	private long contact;

}
