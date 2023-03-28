package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo2 {
	
	public static void main(String[] args) {

		File file = new File("D:/WEJE3/Hello.txt");

		if (file.exists()) {
			System.out.println("File already exists");
		} else {

			try {
				file.createNewFile();
				System.out.println("File created");
			} catch (IOException e) {
				System.out.println("File not created");
				e.printStackTrace();
			}
		}

	}

}
