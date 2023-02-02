package com.jspiders.multithreadingwaitandnotify.thread;

import com.jspiders.multithreadingwaitandnotify.resource.Pizza;

public class Friends extends Thread {
	
	private Pizza pizza;

	public Friends(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public void run() {
		pizza.orderPizza(5);
	}

}
