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
		//Student s2 = new Student("Rick James", 65);
		//writeStudent(s2);
		
		ArrayList<Student> studs = new ArrayList<Student>();
		studs = readStudents();
		
		SerializeEx serial = new SerializeEx();
		//serial.writeStream(studs);
		@SuppressWarnings("unchecked")
		ArrayList<Student> deserialized = (ArrayList<Student>) serial.readObject();
		System.out.println(deserialized);	
	}
	
	static void writeStudent(Student student){
		//Try-with-resources
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			bw.write(student.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<Student> readStudents(){
		ArrayList<Student> students = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;
			while((line=br.readLine())!=null){
				String[] about = line.split(":");
				Student temp = new Student();
				temp.setName(about[0]);
				temp.setAge(Integer.parseInt(about[1]));
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
