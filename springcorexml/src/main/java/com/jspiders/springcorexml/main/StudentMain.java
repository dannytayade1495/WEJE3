package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.beans.StudentBean;

public class StudentMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
											("StudentConfig.xml");
		
		StudentBean student1 = (StudentBean) context.getBean
													("student1");
		System.out.println(student1);
		StudentBean student2 = (StudentBean) context.getBean
													("student2");
		System.out.println(student2);
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
