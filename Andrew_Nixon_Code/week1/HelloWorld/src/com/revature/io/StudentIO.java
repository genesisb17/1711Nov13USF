package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentIO {

	static String filename = "src/logs/students.txt";

	public static void main(String[] args) {

		//Student s = new Student("Genesis Bonds", 100);
		Student s = new Student("Rick James", 65);
		//writeStudents(s);
		
		ArrayList<Student> studs = new ArrayList<Student>();
		studs = readStudents(); 
		//System.out.println(studs);
		
		SerializeEx serial = new SerializeEx();
		//serial.writeStream(studs);
		ArrayList<Student> deserialized = (ArrayList<Student>) serial.readObject();
		System.out.println(deserialized);
		
	}
	
	static void writeStudents(Student student) {
		//try-with-resources
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			bw.write(student.toString());
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static ArrayList<Student> readStudents() {
		
		ArrayList<Student> students = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line = null;
			while((line=br.readLine())!=null) {
				String[] about = line.split(":");
				Student temp = new Student();
				temp.setName(about[0]);
				temp.setAge(Integer.parseInt(about[1]));
				students.add(temp);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}

}
