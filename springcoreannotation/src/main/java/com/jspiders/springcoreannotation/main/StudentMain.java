package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotation.beans.StudentBean;
import com.jspiders.springcoreannotation.config.StudentConfig;

public class StudentMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext
											(StudentConfig.class);
		StudentBean student1 = (StudentBean) context.getBean
													("student1");
		System.out.println(student1);
		StudentBean student2 = (StudentBean) context.getBean
													("student2");
		System.out.println(student2);
		
		((AnnotationConfigApplicationContext)context).close();
	}

}
