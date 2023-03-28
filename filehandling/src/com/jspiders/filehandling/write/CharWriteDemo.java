package com.jspiders.filehandling.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharWriteDemo {
	
	public static void main(String[] args) {
		
		File file = new File("CharStream.txt");
		
		if (file.exists()) {
			System.out.println("File already exists");
		} else {
			try {
				file.createNewFile();
				System.out.println("File created");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("Data from program");
			System.out.println("Data written to file");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
