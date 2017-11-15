package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * To serialize an object means to convert its tstate to 
 * a byte stream so that the byte stream can be reverted 
 * back into a copy of the object. A java object is serializable
 * if its class or any of its superclasses implements either Serializable
 * or its subinterface Externalizable
 */
public class SerializeEx {
	
	static String filename = "src/logs/bytestream.txt";
	
	void writeStream(Object o) {
		try (ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
