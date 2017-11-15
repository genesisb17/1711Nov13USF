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
		readStudents().stream().forEach(System.out::print);
		SerializeEx ser = new SerializeEx();
		ser.writeObject(readStudents());
		
		ArrayList<Student> students = (ArrayList<Student>) ser.readObject();
		System.out.println(students);
		
//		Student s = new Student("Tyler Ehringer", 50);
//		Student s2 = new Student("Rick James", 473);
//		writeStudent(s2);
	}
	
	static void writeStudent(Student student) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<Student> readStudents() {
		ArrayList<Student> students = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			br.lines().forEach(s -> {
				String[] data = s.split(":");
				students.add(new Student(data[0], Integer.parseInt(data[1])));
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return students;
	}
	
}
