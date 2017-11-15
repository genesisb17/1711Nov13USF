package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeEx {
	/*
	 *  To serialize an object means to convert its state to a byte stream, so that
	 *  the byte stream can be reverted back into a copy of the object. A java object
	 *  is serializable if its class, or its super class, implements either
	 *  Serializable, or the sub-interface Externalizable.
	 */
	
	static String filename = "src/logs/bytestream.txt";
	
	void writeStream(Object o) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));) {
			oos.writeObject(o);
		}
		
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	Object readObject() {
		
		Object obj = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));) {
			obj = ois.readObject();
		} 
		
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} 
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		return obj;
	}
}
