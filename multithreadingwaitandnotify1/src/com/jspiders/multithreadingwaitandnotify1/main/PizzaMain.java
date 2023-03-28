package com.jspiders.multithreadingwaitandnotify1.main;

import com.jspiders.multithreadingwaitandnotify1.resource.Pizza;
import com.jspiders.multithreadingwaitandnotify1.thread.Friends;
import com.jspiders.multithreadingwaitandnotify1.thread.PizzaHut;

public class PizzaMain {
	
	public static void main(String[] args) {
		
		Pizza pizza = new Pizza();
		Friends friends1 = new Friends(pizza);
		Friends friends2 = new Friends(pizza);
		Friends friends3 = new Friends(pizza);
		PizzaHut pizzaHut = new PizzaHut(pizza);
		
		friends1.start();
		friends2.start();
		friends3.start();
		pizzaHut.start();
		
	}

}
