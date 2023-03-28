package com.jspiders.multithreadingwaitandnotify1.thread;

import com.jspiders.multithreadingwaitandnotify1.resource.Pizza;

public class Friends extends Thread {
	
	Pizza pizza;
	
	public Friends(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void run() {
		pizza.orderPizza(5);
	}

}
