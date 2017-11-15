package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StudentIO {

	static String filename = "src/logs/students.txt";
	public static void main(String[] args) {
		Student s = new Student("Billy-Bob Thornton", 52);
		writeStudent(s);
	}
	
	static void writeStudent(Student student) {
		//Try-with-resources
		try (BufferedWriter bw = 
				new BufferedWriter(new FileWriter(filename, true))) {
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
