package com.rev.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeExample {
	/*
	 * To serialize an object means to convert its state
	 * to a byte stream so that the byte stream can be reverted 
	 * back into a copy of the object. A java object is serializable 
	 * if its class or any of its superclasses implements either serializable or its
	 * subinterface, externalizable
	 */
	
	static String filename = "HelloWorld/src/logs/bytestream.txt";
	
	void writeStream(Object o) {
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(filename))){
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Object readObject() {
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

}
