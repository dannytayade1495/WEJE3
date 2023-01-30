package com.jspiders.multithreadingproperties.thread;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println
		("The name of the thread is " 
		+ Thread.currentThread().getName());
		System.out.println
		("The priority of the thread is " 
		+ Thread.currentThread().getPriority());
	}

}
