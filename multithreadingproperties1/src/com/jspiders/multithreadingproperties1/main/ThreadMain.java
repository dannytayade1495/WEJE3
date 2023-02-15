package com.jspiders.multithreadingproperties1.main;

import com.jspiders.multithreadingproperties1.thread.MyThread1;
import com.jspiders.multithreadingproperties1.thread.MyThread2;

public class ThreadMain {
	
	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		
		myThread1.setName("Thread 1");
		myThread1.setPriority(8);
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		
		thread.setName("Thread 2");
		thread.setPriority(10);
		
		myThread1.start();
		thread.start();
		
	}

}
