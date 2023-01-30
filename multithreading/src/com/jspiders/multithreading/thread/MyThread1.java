package com.jspiders.multithreading.thread;

public class MyThread1 extends Thread {
	
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println("MyThread1 is now running");
		}
	}

}
