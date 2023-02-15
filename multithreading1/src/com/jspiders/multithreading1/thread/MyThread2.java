package com.jspiders.multithreading1.thread;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("MyThread2 is now running.");
		}
	}

}
