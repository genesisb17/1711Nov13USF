package warmup;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WarmUp {
//	Warmup Exercises:
//		Write a program to determine if an integer is even without using the modulus operator (%) , and write a jUnit test case
//		Write a program that creates an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
//		Find the minimum of two numbers using ternary operators.
//		Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
//		Case 1: Find the square root of a number using the Math class method.
//		Case 2: Display today’s date.
//		Case 3: Split the following string and store it in a sting array.
//		“I am learning Core Java”
//		Create a notepad file called Data.txt and enter the following:
//		Mickey35:Arizona
//		Hulk:Hogan:50:Virginia
//		Roger22:California
//		Wonder18:Montana
//		Write a program that would read from the file and print it out to the screen in the following format:
//		Name: Mickey Mouse
//		Age: 35 years
//		State: Arizona State
	
	String oddOrEven(int num) {
		String ans;
		if(num/2==Math.round((float)(num)/2))
		{
			ans = "even";
			return ans;
		}else{
			ans = "odd";
			return ans;
		}
	}

	
	public static void main(String[] args) throws IOException {
		
		
		int number = 5;
		String core = "I am learning Core Java";
		switch(number) {
		case 1:
			Math.sqrt(number);
		case 2:
			System.out.println("11/16/2017");
		case 3:
			String[] arr = core.split(" ");
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.println("1");
		for(int i = 1; i < 101; i++) {
			arr.add(i);
		}
		for(int i = arr.get(0); i < arr.size(); i++) {
			boolean isPrime = true;
			for(int j = arr.get(1); j < i; j++) {
				if(arr.get(i) % arr.get(j) == 0) {
					isPrime = false;
				}
			}
			if(isPrime == true) {
				System.out.println(arr.get(i));
			}
		}
		System.out.println("--------------------------");
		
		System.out.println("Enter 2 numbers to compare: ");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.close();
		System.out.println((num1 < num2) ? num1 + " is smaller" : num2 + " is smaller");
			
		System.out.println("--------------------------");
		
		BufferedReader in = new BufferedReader(new FileReader("src/warmup/data.txt"));
		String lin;
		while((lin = in.readLine()) != null) {
//			System.out.println(lin);
			StringTokenizer tok = new StringTokenizer(lin, ":");
			System.out.println("Name: " + tok.nextToken() + " " + tok.nextToken() + "\n" 
			+ "Age: " + tok.nextToken() + "\n" + "State: " + tok.nextToken());
		}
		
	}

}























