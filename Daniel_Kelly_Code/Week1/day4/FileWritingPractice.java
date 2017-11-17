package com.revature.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileWritingPractice {

	static String filename = "src/logs/Data.txt";
	
	public static void main(String[] args) {
		
		ArrayList<People> p = new ArrayList<People>();
		p = readPeople();
		
		System.out.println(p);

	}
	
	static ArrayList<People> readPeople(){
		ArrayList<People> people = new ArrayList<People>();
			
			try(BufferedReader br = new BufferedReader(new FileReader(filename));){
				String line = null;
				while((line=br.readLine())!=null){
					String[] about = line.split(":");
					People temp = new People();
					temp.setFirstName(about[0]);
					temp.setLastname(about[1]);
					temp.setAge(Integer.parseInt(about[2]));
					temp.setLocation(about[3]);
					people.add(temp);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return people;
		}

}
