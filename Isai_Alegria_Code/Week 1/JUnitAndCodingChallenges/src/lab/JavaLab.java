package lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class JavaLab {
	
	static String filename = "src/logs/Data.txt";
	public static void main(String[] args) {
	
		primeCheck();
		min(15, 20);
		//min(20,15);
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter number: ");
		int number = scan.nextInt();
		scan.close();	
		
		Student s1 = new Student("Mickey", "Mouse", 35, "Arizona");
		Student s2 = new Student("Hulk", "Hogan", 50, "Virginia");
		Student s3 = new Student("Roger", "Rabbit", 18, "California");
		Student s4 = new Student("Wonder", "Woman", 22, "Montana");
		writeStudent(s1);
		writeStudent(s2);
		writeStudent(s3);
		writeStudent(s4);
		
		ArrayList<Student> studs = new ArrayList<Student>();
		studs = readStudents();
		System.out.println(studs);
		
		switch(number) {
	
		case 1:
			int square = 25;
			System.out.println("Square root of " + square + " is " + Math.sqrt(square));
			break;
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3:
			String str = "I am learning Java";
			String[] arr = str.split(" ");
			break;
			
			
		
		}
	
	}
	
//program to find if a number is even or odd without using the modulus operator
public boolean evenOrOdd(int val) {
		
		if((val & 1) == 0) {
			System.out.println("The number entered is even.");
			return true;
		}
		
		else
		{
			System.out.println("The number entered is odd.");
			return false;
		}
	}

//makes an arraylist from 0 to 100 and displays only prime numbers
public static void primeCheck() {
	
	ArrayList<Integer> intList = new ArrayList<>();
	Integer temp;
	int x;
	boolean isPrime = true;
	
	for(int i=1; i < 101; i++) {
		intList.add(i);
	}
//System.out.println(intList);
	
	while(intList.isEmpty()!=true)
	{
		
		isPrime = true;
		temp = intList.get(0);
		for(int i=2;i<=temp/2;i++)
		{
	           x=temp%i;
		   if(x==0)
		   {
		      isPrime=false;
		      break;
		   }
		}
		//If isPrime is true then the number is prime 
		if(isPrime)
		{
			
		   System.out.println(temp + " is a Prime Number");
		}	  

		  intList.remove(0);
		  
			  
	 }
		  
		  
	} //prime check end

//find the smaller value of two numbers using ternary operator
public static void min(int x, int y) {
	
	
	int value;
	value = (x < y) ? x : y;
	
	System.out.println(value + " is the smaller number");


}

static void writeStudent(Student student) {
	
	//Try-with-resource
	try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
		bw.write(student.toString());
		
	} catch (IOException e) {
		e.printStackTrace();
	
	}
}

static ArrayList<Student> readStudents() {
	
	ArrayList<Student> students = new ArrayList<Student>();
	try(BufferedReader br = new BufferedReader(new FileReader(filename))){
		String line = null;
		while((line = br.readLine())!=null) {
			String[] about = line.split(":");
			Student temp = new Student();
			temp.setfName(about[0]);
			temp.setlName(about[1]);
			temp.setAge(Integer.parseInt(about[2]));
			temp.setLocation(about[3]);
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