package com.jspiders.factorypattern.object;

import com.jspiders.factorypattern.inter.Browser;

public class Chrome implements Browser {

	@Override
	public void start() {
		System.out.println("Chrome browser started.");
	}

}
