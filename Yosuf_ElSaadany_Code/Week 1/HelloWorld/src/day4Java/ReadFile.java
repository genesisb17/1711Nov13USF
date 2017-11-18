package day4Java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.revature.io.Student;

public class ReadFile {

	public static void main(String[] args) {
		readEmployees();
	}

	static void readEmployees() {
		try(BufferedReader br = new BufferedReader(new FileReader("src/logs/Data.txt"))){
			String line = null;
			while((line = br.readLine()) != null) {
				String[] about = line.split(":");
				System.out.println("Name: " + about[0] + " " + about[1]);
				System.out.println("Age: " + about [2]);
				System.out.println("State: " + about[3]);
			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
