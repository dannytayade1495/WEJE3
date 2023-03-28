package com.jspiders.factorypattern.object;

import com.jspiders.factorypattern.inter.Browser;

public class Firefox implements Browser {

	@Override
	public void start() {
		System.out.println("Firefox browser started.");
	}

}
