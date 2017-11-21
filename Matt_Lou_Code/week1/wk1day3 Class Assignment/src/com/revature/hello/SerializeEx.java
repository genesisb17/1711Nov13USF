package com.revature.hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeEx {
	/*To serialize an object means to convert its state to a byte
	stream so that the byte stream can be reverted back into copy of the 
	object. A java obect is serializable if its class or any of its 
	superclasses implements either Serializable or its subinterface 
	Externalizable*/
	
	static String filename = "src/logs/bytestream.txt";
	
	void writeStream(Object o) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
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
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
