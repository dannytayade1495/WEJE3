package com.jspiders.multithreading.thread;

public class MyThread3 extends Thread{
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			if (i == 3) {
				this.stop();
			}
			System.out.println
			(this.getName() + " is now running");
		}
	}

}
