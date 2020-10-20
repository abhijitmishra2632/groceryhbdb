package com.cosmos.contactnumbers.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cosmos.contactnumbers.model.Users;

@Service
public class UserUtil {
	
	public void toFile(List<Users> users) throws IOException {
		// TODO Auto-generated method stub
		String filename = "file.txt";
		FileOutputStream file= null;
		ObjectOutputStream out = null;
		try {
			// Saving of object in a file
			file = new FileOutputStream(filename);
			out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(users);
			System.out.println("Object has been serialized");
		}
		catch (IOException ex) {
			System.out.println("IOException is caught");
		}finally {
			out.close();
			file.close();
		}
	}

	public List<Users> fromFile() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Users> users = null;
				String filename = "file.txt";
				FileInputStream file= null;
				ObjectInputStream input = null;
				try {
					// Saving of object in a file
					file = new FileInputStream(filename);
					input = new ObjectInputStream(file);
					// Method for serialization of object
					users=(List<Users>) input.readObject();
					System.out.println("Object has been serialized");
				}
				catch (IOException ex) {
					System.out.println("IOException is caught");
				}finally {
					input.close();
					file.close();
				}
				return users;
	}

}
