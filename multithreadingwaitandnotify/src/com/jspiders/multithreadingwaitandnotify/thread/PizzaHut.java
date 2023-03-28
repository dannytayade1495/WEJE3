package com.jspiders.multithreadingwaitandnotify.thread;

import com.jspiders.multithreadingwaitandnotify.resource.Pizza;

public class PizzaHut extends Thread {

	private Pizza pizza;

	public PizzaHut(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public void run() {
		pizza.makePizza(10);
	}
	
}
