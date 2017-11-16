package day4.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LabWarmUp {

	
	public boolean EvenStuff(int x) {
		
		boolean even = true;
		if((x/2) * 2 == x) {
			return even;
		}
		
		else {
			return false;
			
		}
	}
	
	public static void PrimeNums() {
		ArrayList<Integer> list = new ArrayList<>();
		int count = 1;
		int factor = 0;
		for(int i = 4; i > 0; i--) {
			for(int j = count; j > 0; j--) {
				if(count%j == 0) {
					factor++;
				}
				System.out.println("j is " + j);
				count++;
			}
			if(factor == 1) {
				System.out.println("factor = 1");
			}
			

		}

		
	}
	
	
	public int minimumOf(int a, int b) {
		
		return a > b ? b : a;
		
	}
	
	
	public static void switchTest() {
		int x = 0;
		String sp = "I am learning Core Java";

		switch(x) {
		case 0:
			System.out.println("The square root of 789 is: " + Math.sqrt(789) + ".");
		case 1:
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(now.format(dtf));
		case 2:
			String[] arr = sp.split("\\s");
			for(String xx : arr) {
				
				System.out.print(xx + " | ");
			}
		}
	}
	
	String filename = "src/logs/Data.txt";
	public void readToFi(String filename) {
		
		ArrayList<String> wo = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String ln = null;
			while((ln = br.readLine()) != null) {
				
				String[] ow = ln.split(":");
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//PrimeNums();
		switchTest();
	}

}
