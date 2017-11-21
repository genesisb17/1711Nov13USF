package ReadIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadAboutIt {
	/*
	 * in this class, we create a method that will read in from the data file containing
	 * the information we are looking to extract. after doing so, the method will print 
	 * the information in the following format
	 * 
	 * Name: FirstName LastName
	 * Age: Age
	 * State: State
	 */
	static String fileName = "src/logs/data.txt";

	
	public static void main(String[] args) {
		ArrayList<People> persons = new ArrayList<>();
		persons = readPeople();
		
	}
	
	static ArrayList<People> readPeople(){
		ArrayList<People> persons = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			while((line = br.readLine())!= null) {
				String [] about = line.split(":");
				People temp = new People();
				temp.setFirstName(about[0]);
				temp.setLastName(about[1]);
				System.out.println("Name: " + temp.getFirstName() + " " + temp.getLastName());
				temp.setAge(Integer.parseInt(about[2]));
				System.out.println("Age: " + temp.getAge());
				temp.setState(about[3]);
				System.out.println("State: " + temp.getState());
				System.out.println();
				persons.add(temp);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons;
		
	}

}
