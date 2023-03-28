package com.jspiders.multithreading1.thread;

public class MyThread1 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			if (i == 3) {
				this.stop();
			}
			System.out.println("MyThread1 is now running.");
		}
	}

}
