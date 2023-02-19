package com.jspiders.factorypattern.object;

import com.jspiders.factorypattern.inter.Browser;

public class Edge implements Browser {

	@Override
	public void start() {
		System.out.println("Edge browser started.");
	}

}
