package com.jspiders.multithreadingsleep.main;

public class SleepDemo {
	
	public static void main(String[] args) {
		
		String message = "This is the magic of sleep()";
		
		char[] messageArray = message.toCharArray();
		
		for (int i = 0; i < message.length(); i++) {
			System.out.print(messageArray[i]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
