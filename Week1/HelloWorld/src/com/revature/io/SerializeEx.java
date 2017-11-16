package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeEx{
	/*
	 * To serialize an object means to convert its state
	 * to a byte stream so that the byte stream can be reverted 
	 * back into a copy of the object. A Java object is
	 * serializeable if its class or any of its superclasses
	 * implements either Serializable or its subinterface
	 * Externalizable
	 * */
	
	static String filename = "src/logs/bytestream.txt";
	
	void writeStream(Object o) {
	
			try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));){
				os.writeObject(o);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	Object readObject() {
		Object obj = null;
		
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))){
			
			obj = is.readObject();
			
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
