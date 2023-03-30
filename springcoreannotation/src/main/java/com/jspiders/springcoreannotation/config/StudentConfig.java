package com.jspiders.springcoreannotation.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotation.beans.StudentBean;

public class StudentConfig {
	
	@Bean("student1")
	public StudentBean getStudent1() {
		StudentBean student1 = new StudentBean();
		student1.setId(1);
		student1.setName("Akshay");
		student1.setCity("Pune");
		return student1;
	}
	
	@Bean("student2")
	public StudentBean getStudent2() {
		StudentBean student2 = new StudentBean(2, "Akshata", "Delhi");
		return student2;
	}

}
