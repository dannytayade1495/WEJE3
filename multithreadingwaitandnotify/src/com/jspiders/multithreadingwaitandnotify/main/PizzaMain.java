package com.jspiders.multithreadingwaitandnotify.main;

import com.jspiders.multithreadingwaitandnotify.resource.Pizza;
import com.jspiders.multithreadingwaitandnotify.thread.Friends;
import com.jspiders.multithreadingwaitandnotify.thread.PizzaHut;

public class PizzaMain {
	
	public static void main(String[] args) {
		
		Pizza pizza = new Pizza();
		
		Friends friends1 = new Friends(pizza);
		Friends friends2 = new Friends(pizza);
		PizzaHut pizzaHut = new PizzaHut(pizza);
		
		friends1.start();
		friends2.start();
		pizzaHut.start();
		
	}

}
