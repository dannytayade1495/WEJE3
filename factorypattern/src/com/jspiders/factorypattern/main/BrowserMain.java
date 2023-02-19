package com.jspiders.factorypattern.main;

import java.util.Scanner;

import com.jspiders.factorypattern.inter.Browser;
import com.jspiders.factorypattern.object.Chrome;
import com.jspiders.factorypattern.object.Edge;
import com.jspiders.factorypattern.object.Firefox;
import com.jspiders.factorypattern.object.Safari;

public class BrowserMain {
	
	private static boolean loop = true;
	private static Scanner scanner;
	private static Browser browser;
	
	public static void main(String[] args) {
		while (loop) {
			try {
				factory().start();
			} catch (NullPointerException e) {
				System.out.println("No Browser Selected");
			}
		}
		scanner.close();
	}
	
	private static Browser factory() {
		System.out.println("SELECT BROWSER"
				+ "\n1. Chrome"
				+ "\n2. Firefox"
				+ "\n3. Safari"
				+ "\n4. Edge");
		
		scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			browser = new Chrome();
			return browser;
			
		case 2:
			browser = new Firefox();
			return browser;
			
		case 3:
			browser = new Safari();
			return browser;
			
		case 4:
			browser = new Edge();
			return browser;
			
		default:
			loop = false;
			System.out.println("Invalid choice");
			return null;
		}
	}
}
