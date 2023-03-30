package com.jspiders.springcoreannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspiders.springcoreannotation.beans.CarBean;

@ComponentScan(basePackages = "com.jspiders.springcoreannotation")
public class CarDriverConfig {
	
	@Bean
	public CarBean getBean() {
		return new CarBean();
	}

}
