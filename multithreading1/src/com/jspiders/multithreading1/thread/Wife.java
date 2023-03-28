package com.jspiders.multithreading1.thread;

import com.jspiders.multithreading1.resource.Account;

public class Wife extends Thread {
	
	Account account;

	public Wife(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.deposit(1000);
		account.withdraw(5000);
	}

}
