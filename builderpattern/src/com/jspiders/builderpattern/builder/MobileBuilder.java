package com.jspiders.builderpattern.builder;

import com.jspiders.builderpattern.object.Mobile;

public class MobileBuilder {
	
	private String brand;
	private String model;
	private double price;
	private String colour;
	private int front_cam;
	private int rear_cam;
	private int ram;
	private int memory;
	private double processor;
	private String os;
	
	public MobileBuilder brand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public MobileBuilder model(String model) {
		this.model = model;
		return this;
	}
	
	public MobileBuilder colour(String colour) {
		this.colour = colour;
		return this;
	}
	
	public MobileBuilder os(String os) {
		this.os = os;
		return this;
	}
	
	public MobileBuilder front_cam(int front_cam) {
		this.front_cam = front_cam;
		return this;
	}
	
	public MobileBuilder rear_cam(int rear_cam) {
		this.rear_cam = rear_cam;
		return this;
	}
	
	public MobileBuilder ram(int ram) {
		this.ram = ram;
		return this;
	}
	
	public MobileBuilder memory(int memory) {
		this.memory = memory;
		return this;
	}
	
	public MobileBuilder price(double price) {
		this.price = price;
		return this;
	}
	
	public MobileBuilder processor(double processor) {
		this.processor = processor;
		return this;
	}
	
	public Mobile getMobile() {
		Mobile mobile = new Mobile(this.brand, this.model, 
				this.price, this.colour, this.front_cam, 
				this.rear_cam, this.ram, this.memory, 
				this.processor, this.os);
		return mobile;
	}

}
