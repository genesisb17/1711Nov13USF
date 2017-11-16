package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentID 
{
	static String fileName = "src/logs/students.txt";
	public static void main(String[] args) 
	{
		//Student s = new Student("Ihsan Taha", 30);
		//writeStudent(s);
		ArrayList<Student> studs = new ArrayList<>();
		studs = readStudents();
		System.out.println(studs);
		
		SerializeEx serial = new SerializeEx();
		serial.writeStream(studs);
		
		@SuppressWarnings("unchecked")
		ArrayList<Student> deserialized = (ArrayList<Student>) serial.readObject();
		System.out.println(deserialized);
	}
	
	static void writeStudent(Student student)
	{
		// Try with resources
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));)
		{
			bw.write(student.toString());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	static ArrayList<Student> readStudents()
	{
		ArrayList<Student> students = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName));)
		{
			String line = null;
			while((line=br.readLine())!=null)
			{
				String[] about = line.split(":");
				Student temp = new Student();
				temp.setName(about[0]);
				temp.setAge(Integer.parseInt(about[1]));
				students.add(temp);
				
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return students;
	}

}
