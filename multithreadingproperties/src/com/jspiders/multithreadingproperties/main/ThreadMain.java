package com.jspiders.multithreadingproperties.main;

import com.jspiders.multithreadingproperties.thread.MyThread1;
import com.jspiders.multithreadingproperties.thread.MyThread2;

public class ThreadMain {
	
	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		
		myThread1.setName("Thread1");
		myThread1.setPriority(8);
		
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		
		thread.setName("Thread2");
		thread.setPriority(3);
		
		thread.start();
		myThread1.start();
		
	}

}
