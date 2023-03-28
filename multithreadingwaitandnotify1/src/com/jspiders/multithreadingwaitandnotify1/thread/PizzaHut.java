package com.jspiders.multithreadingwaitandnotify1.thread;

import com.jspiders.multithreadingwaitandnotify1.resource.Pizza;

public class PizzaHut extends Thread {
	
	Pizza pizza;

	public PizzaHut(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void run() {
		pizza.makePizza(15);
	}
	
}
