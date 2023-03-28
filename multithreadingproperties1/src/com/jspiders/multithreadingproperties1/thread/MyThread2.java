package com.jspiders.multithreadingproperties1.thread;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Name of thread : " + Thread.currentThread().getName());
		System.out.println("Priority of thread : " + Thread.currentThread().getPriority());
	}

}
