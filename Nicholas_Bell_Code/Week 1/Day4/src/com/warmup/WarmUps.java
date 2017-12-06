 package com.warmup;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math.*;

public class WarmUps {

	static String filename = "src/com/warmup/files/Data.txt";
	public String determineInt(int x) {
		if (x/2 != (x+1)/2) {
			return "Odd";
		}
		return "Even";
	}
	
	public void primes() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 2 ; i <= 100 ; i++) {
			arr.add(i);
		}
		
		for(int a : arr) {
			int i = 2;
			boolean flag = false;
			while (i <= a/2) {
				if (a%i == 0) {
					flag = true;
					break;
				}
				i++;
			}
			if(!flag) {
				ans.add(a);
			}
		}
		
		System.out.println(ans);		
	}
	
	public void Ternary(int x, int y, int ans) {
		ans =  (x < y ? x : y);
	}
	
	public void Switch() {

		

		
		boolean flag = false;
		do {
				System.out.println("Enter Choice: "
				+ "\n1) Square root "
				+ "\n2) Display Date "
				+ "\n3) Split 'I am Learning Core Java' and store in array\n");
		
				Scanner scan = new Scanner(System.in);
				int i = scan.nextInt();
		
			switch(i) {
					case 1:
						scan = new Scanner(System.in);
						i = scan.nextInt();
						double d;
						d =  Math.sqrt((double)i);
						break;
					case 2:
						Date date = new Date();
						System.out.println(date.toString());
						break;
					case 3:
						String s = new String("I am Learning Core Java");
						String ans[] = s.split(" ");
						System.out.println(ans);
						break;
					default:
						System.out.println("Enter valid selection:");
						flag = true;
			}
		}while(flag);	
	}

	public void readPrint() {
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;
			while((line = br.readLine())!=null) {
				String[] about = line.split(":");
				System.out.println("Name: " + about[0] + " " + about[1]);
				System.out.println("Age:" + about[2] + " years");
				System.out.println("State: " + about[3] + " State");
			}
			
		}catch(FileNotFoundException fne) {
			fne.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}
