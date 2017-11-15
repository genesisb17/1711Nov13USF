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
//		Student s = new Student("Billy-Bob Thornton", 52);
//		writeStudent(s);
		ArrayList<Student> studs = new ArrayList<Student>();
		studs = readStudents();
		System.out.println(studs);
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
	
	static ArrayList<Student> readStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		try (BufferedReader br = 
				new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] member = line.split(":");
				Student temp = new Student();
				temp.setName(member[0]);
				temp.setAge(Integer.parseInt(member[1]));
				students.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}
}
