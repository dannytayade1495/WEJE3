package com.jspiders.multithreading1.resource;

public class Account {
	
	int accountBalance;

	public Account(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public int checkBalance() {
		return this.accountBalance;
	}
	
	public synchronized void deposit(int amount) {
		System.out.println("Depositing " + amount + " in account");
		accountBalance += amount;
		System.out.println("Current balance : " + checkBalance());
	}
	
	public synchronized void withdraw(int amount ) {
		System.out.println("Withdrawing " + amount + " from account");
		accountBalance -= amount;
		System.out.println("Current balance : " + checkBalance());
	}

}
