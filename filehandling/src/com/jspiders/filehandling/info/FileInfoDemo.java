package com.jspiders.filehandling.info;

import java.io.File;
import java.io.IOException;

public class FileInfoDemo {

	public static void main(String[] args) {

		File file = new File("Hello.txt");

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
		System.out.println("Name of file : " + file.getName());
		System.out.println("Path of file : " + file.getAbsolutePath());
		System.out.println("Length of file : " + file.length());
		if (file.canRead()) {
			System.out.println("The file is readable.");
		} else {
			System.out.println("The file is not readable.");
		}
		if (file.canWrite()) {
			System.out.println("The file is writable.");
		} else {
			System.out.println("The file is not writable.");
		}
		if (file.canExecute()) {
			System.out.println("The file is executable.");
		} else {
			System.out.println("The file is not executable.");
		}
	}
}
