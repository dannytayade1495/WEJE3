package com.jspiders.multithreading1.main;

import com.jspiders.multithreading1.resource.Account;
import com.jspiders.multithreading1.thread.Husband;
import com.jspiders.multithreading1.thread.Wife;

public class AccountMain {
	
	public static void main(String[] args) {
		
		Account account = new Account(10000);
		Husband husband = new Husband(account);
		Wife wife = new Wife(account);
		
		husband.start();
		wife.start();
		
	}

}
