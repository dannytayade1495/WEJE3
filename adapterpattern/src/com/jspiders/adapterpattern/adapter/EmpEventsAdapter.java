package com.jspiders.adapterpattern.adapter;

import com.jspiders.adapterpattern.classentity.Employee;
import com.jspiders.adapterpattern.interfaceentity.Events;

public class EmpEventsAdapter extends Employee implements Events {

	@Override
	public void childrensDay() {
		
		EmpEventsAdapter adapter = new EmpEventsAdapter();
		adapter.setEmpid(1);
		adapter.setName("Avinash");
		adapter.setDesignation("Manager");
		adapter.setEmail("avinash@gmail.com");
		
		System.out.println
		("Chief guest of the Children's Day event is : "
				+ adapter.getName() + 
		"\nHe is the " + adapter.getDesignation());
		
	}
	
	public static void main(String[] args) {
		
		EmpEventsAdapter adapter = new EmpEventsAdapter();
		adapter.childrensDay();
		
	}

}
