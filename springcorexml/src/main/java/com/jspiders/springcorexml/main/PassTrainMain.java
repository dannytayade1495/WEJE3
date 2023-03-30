package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.beans.PassengerBean;

public class PassTrainMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
											("PassTrainConfig.xml");
		
		PassengerBean passenger1 = (PassengerBean) context.getBean
													("passenger1");
		System.out.println(passenger1);
		
		PassengerBean passenger2 = (PassengerBean) context.getBean
													("passenger2");
		System.out.println(passenger2);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
