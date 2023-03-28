package com.jspiders.multithreadingsleep1.main;

public class SleepDemo {
	
	public static void main(String[] args) {
		
		String message = "This is the sleep()";
		char[] charArray = message.toCharArray();
		
		for (int i = 0; i < message.length(); i++) {
			System.out.print(charArray[i]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
