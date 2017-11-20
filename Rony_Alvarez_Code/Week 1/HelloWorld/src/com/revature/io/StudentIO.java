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
		
		//Student s = new Student("Rony Alvarez", 100);
		//Student s2 = new Student("John Doe", 80);
		//Student s3 = new Student("Sophia Williams", 45);
		
		//writeStudent(s);
		//writeStudent(s2);
		//writeStudent(s3);
		
		modifyFile(filename, "Cristiano Ronaldo", "Rony Alvarez");
		
		//ArrayList<Student> studs = new ArrayList<Student>();
		//studs = readStudents();
		
		//SerializeEx serial = new SerializeEx();
		//serial.writeStream(studs);
		
		//@SuppressWarnings("unchecked")
		//ArrayList<Student> deserialized = (ArrayList<Student>) serial.readObject();
		
		//System.out.println(deserialized);

	}
	
	static void writeStudent(Student student) {
		
		// Try-with-resources
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			
			bw.write(student.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	static ArrayList<Student> readStudents() {
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			
			String line = null;
			while( (line = br.readLine()) != null) {
				
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
	
	
	
	
	
	static void modifyFile(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);
		
		String oldContent = "";
		
		BufferedReader reader = null;
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();
				
				line = reader.readLine();
			}
			
			//Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replaceFirst(oldString, newString);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//Closing the resources
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	

}
