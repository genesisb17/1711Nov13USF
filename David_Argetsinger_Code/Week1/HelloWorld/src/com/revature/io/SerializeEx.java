package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeEx {
	
	/*
	 * to searlize an object means to convert it's state to a bye stream
	 * that can be reverted back to a copy of the object 
	 * an obj is serializable if class or any of its superclasses either serializable 
	 * or it;s sub interface externalizavle 
	 */
	static String filename= "src/logs/bytestream.txt";
	Object readObject(){
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
		{ 
			obj=ois.readObject();
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
	
	void writeStream(Object o)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
