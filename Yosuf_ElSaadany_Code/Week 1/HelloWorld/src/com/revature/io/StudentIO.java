package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentIO {
	
	// CREATE FILE IN THE SPECIFIED PATH
	static String filename = "src/logs/students.txt";
	
	public static void main(String[] args) {
		
		// ADD STUDENTS TO FILE
		//Student s2 = new Student("Jose Belloga", 25);
		//writeStudent(s2);
		
		// Read Students into arraylist
		ArrayList<Student> studs = new ArrayList<Student>();
		studs = readStudents();
		
		// 
		SerializeEx serial = new SerializeEx();
		//serial.writeStream(studs);
		
		@SuppressWarnings("unchecked")
		ArrayList<Student> deserialized = (ArrayList<Student>) serial.readObject();
		System.out.println(deserialized);
		
	}
	
	static void writeStudent(Student student) {
		// Try-with-resources
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true));){
			
			bw.write(student.toString());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<Student> readStudents() {
		ArrayList <Student> students = new ArrayList <Student>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			 
			String line = null;
			while((line = br.readLine()) != null) {
				String[] about = line.split(":");
				Student temp = new Student();
				temp.setName(about[0]);
				temp.setAge(Integer.parseInt(about[1]));
				students.add(temp);
			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

}
