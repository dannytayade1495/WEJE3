package com.jspiders.builderpattern.main;

import com.jspiders.builderpattern.builder.MobileBuilder;
import com.jspiders.builderpattern.object.Mobile;

public class MobileMain {
	
	public static void main(String[] args) {
		
		Mobile mobile = new MobileBuilder()
										.brand("Samsung")
										.model("S23 Ultra")
										.price(135000)
										.ram(16)
										.memory(256)
										.getMobile();
		System.out.println(mobile);
		
	}

}
