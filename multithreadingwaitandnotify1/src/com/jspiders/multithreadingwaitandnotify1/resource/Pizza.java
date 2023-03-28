package com.jspiders.multithreadingwaitandnotify1.resource;

public class Pizza {
	
	int noOfPizza;
	
	public synchronized void orderPizza(int orderedPizza) {
		System.out.println("Ordering " + orderedPizza + " pizzas.");
		if (orderedPizza > noOfPizza) {
			System.out.println
			(orderedPizza + " pizzas not available. Please Wait.");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		noOfPizza -= orderedPizza;
		System.out.println
		("Successfully ordered " + orderedPizza + " pizzas");
	}
	
	public synchronized void makePizza(int makePizza) {
		System.out.println("Making " + makePizza + " pizzas");
		noOfPizza += makePizza;
		this.notifyAll();
	}

}
