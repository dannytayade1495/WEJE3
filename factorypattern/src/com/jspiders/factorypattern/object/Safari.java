package com.jspiders.factorypattern.object;

import com.jspiders.factorypattern.inter.Browser;

public class Safari implements Browser {

	@Override
	public void start() {
		System.out.println("Safari browser started.");
	}

}
