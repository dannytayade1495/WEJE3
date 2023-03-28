package com.jspiders.multithreadingwaitandnotify.resource;

public class Pizza {

	private int noOfPizza;

	public synchronized void orderPizza(int orderedPizza) {
		System.out.println("Ordering " + orderedPizza + " pizzas");
		if (orderedPizza > noOfPizza) {
			System.out.println(orderedPizza + " pizzas not available");
			System.out.println("Please wait..!!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		noOfPizza -= orderedPizza;
		System.out.println
		("Ordered " + orderedPizza + " pizzas successfully.");
	}

	public synchronized void makePizza(int madePizza) {
		System.out.println("Making " + madePizza + " pizzas");
		noOfPizza += madePizza;
		System.out.println(noOfPizza + " pizzas available");
		this.notifyAll();
	}

}
