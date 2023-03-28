package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.beans.StudentBean;

public class StudentMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("StudentConfig.xml");
		
		StudentBean student = context.getBean(StudentBean.class);
		
		System.out.println(student);
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
