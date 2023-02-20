package com.jspiders.builderpattern.object;

public class Mobile {
	
	String brand;
	String model;
	double price;
	String colour;
	int front_cam;
	int rear_cam;
	int ram;
	int memory;
	double processor;
	String os;
	
	public Mobile(String brand, String model, double price, 
			String colour, int front_cam, int rear_cam, int ram,
			int memory, double processor, String os) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.colour = colour;
		this.front_cam = front_cam;
		this.rear_cam = rear_cam;
		this.ram = ram;
		this.memory = memory;
		this.processor = processor;
		this.os = os;
	}

	@Override
	public String toString() {
		return "Mobile"
				+ "\nbrand : " + brand 
				+ "\nmodel : " + model 
				+ "\nprice : " + price 
				+ "\ncolour : " + colour
				+ "\nfront_cam : " + front_cam 
				+ "\nrear_cam : " + rear_cam 
				+ "\nram : " + ram 
				+ "\nmemory : " + memory
				+ "\nprocessor : " + processor 
				+ "\nos : " + os;
	}
}
