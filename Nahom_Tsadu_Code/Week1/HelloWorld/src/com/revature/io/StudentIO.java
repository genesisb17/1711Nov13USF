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
		
		//Student student = new Student("Randy Savage", 36);
		//writeStudent(student);
		
		ArrayList<Student> students = readStudents();
		students.stream().forEach(s -> System.out.println(s.getName() + ": " + s.getAge()));
	}
	
	static void writeStudent(Student student){
		
		try(BufferedWriter bw = 
			new BufferedWriter(
			new FileWriter(filename, true))){
			
			bw.write(student.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	static ArrayList<Student> readStudents(){
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		try(BufferedReader br = 
			new BufferedReader(
			new FileReader(filename))){
			
			String line = null;
			
			while((line=br.readLine()) != null){
				String[] about = line.split(":");
				students.add(new Student(about[0], Integer.parseInt(about[1])));
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return students;
	}
}
