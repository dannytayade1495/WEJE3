package com.jspiders.searializationdeserialization.desrialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.searializationdeserialization.object.User;

public class UserDeserialization {
	
	public static void main(String[] args) {
		
		File file = new File("User.txt");
		
		if (file.exists()) {
			
			try {
				FileInputStream fileInputStream = 
										new FileInputStream(file);
				ObjectInputStream objectInputStream = 
							new ObjectInputStream(fileInputStream);
				
				System.out.println("Reading object from file");
				User user = (User) objectInputStream.readObject();
				System.out.println(user);
				
				fileInputStream.close();
				objectInputStream.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist.");
		}
		
	}

}
