package com.jspiders.searializationdeserialization.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.searializationdeserialization.object.User;

public class UserSerialization {
	
	public static void main(String[] args) {
		
		File file = new File("User.txt");
		
		if (file.exists()) {
			System.out.println("File already exists");
		} else {
			try {
				file.createNewFile();
				System.out.println("File created successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileOutputStream fileOutputStream = 
								new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = 
						new ObjectOutputStream(fileOutputStream);
			
			User user = new User(1, "Tappu", "tappusena@tmkoc.com",
					 			"tappu123", "babita143");
			objectOutputStream.writeObject(user);
			System.out.println("Object written to file");
			
			fileOutputStream.close();
			objectOutputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
