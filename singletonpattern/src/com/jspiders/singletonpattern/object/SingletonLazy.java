package com.jspiders.singletonpattern.object;

public class SingletonLazy {
	
	private static SingletonLazy object;
	
	private SingletonLazy() {
		System.out.println("Constructer accessed.");
	}
	
	public static SingletonLazy getObject() {
		System.out.println("Object creation method accessed.");
		if (object == null) {
			object = new SingletonLazy();
		}
		return object;
	}

}
