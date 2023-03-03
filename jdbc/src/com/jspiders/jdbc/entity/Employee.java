package com.jspiders.jdbc.entity;

public class Employee {
	
	private int empno;
	private String ename;
	private String email;
	private long contact;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno 
				+ ", ename=" + ename 
				+ ", email=" + email 
				+ ", contact=" + contact + "]";
	}
	
}
