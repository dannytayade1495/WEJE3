package com.jspiders.singletonpattern.object;

public class SingletonEager {
	
	private static SingletonEager object = new SingletonEager();
	
	private SingletonEager() {
		System.out.println("Constructer accessed");
	}

	public static SingletonEager getObject() {
		System.out.println("Object creation method accessed.");
		return object;
	}
}
