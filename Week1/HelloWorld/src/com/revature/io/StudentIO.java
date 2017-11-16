package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentIO {

	static String filename = "src/logs/students.txt";
	public static void main(String[] args) {
		
//		Student s2 = new Student("Rick James", 65);
//		writeStudent(s2);
		
		ArrayList<Student> stus = new ArrayList<>();
		stus = readStudents();
//		System.out.println(stus);
		
		SerializeEx serial = new SerializeEx();
//		serial.writeStream(stus);

		ArrayList<Student> deSerialized = (ArrayList<Student>) serial.readObject();
		System.out.println(deSerialized);
//		for(Student s : stus) {
//			
//			System.out.println(s);
//		}
		
		
		
	}
	
	static void writeStudent(Student student) {
		//Try-with-resources
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
			bw.write(student.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static ArrayList<Student> readStudents() {
		
		ArrayList<Student> students = new ArrayList<Student>();
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
