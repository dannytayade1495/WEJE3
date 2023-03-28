package com.jspiders.multithreading1.thread;

import com.jspiders.multithreading1.resource.Account;

public class Husband extends Thread {
	
	Account account;
	
	public Husband(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.deposit(5000);
		account.withdraw(500);
	}

}
