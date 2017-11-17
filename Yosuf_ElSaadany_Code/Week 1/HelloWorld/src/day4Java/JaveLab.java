package day4Java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class JaveLab {
	



	public static void main(String[] args) {
		
		/*
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++)
			list.add(i);
		int count = 0;
		
		for(int i = 2; i <= 100; i++) {
			for(int j = 2; j <= i; j++) {
				if(list.get(i) % j == 0) {
					count += 1;
					
					//System.out.println(list);
				}
					
			}
		}
		*/
		
		// Call Min Function
		int x = 10;
		int y = 2;
		int min = minimum(x,y);
		System.out.println(min);
		
		double root = 10;
		int Case = 3;
		Switch(root, Case);
		
	}
	
	// Even or Odd
	public boolean even(int num) {
		boolean bool;
		
		if((num/2)*2 == num) {
			bool = true;
			return bool;
		}
		else {
			bool = false;
			return bool;
		}
	}
	
	// Minimum Using Ternary operator
	public static int minimum (int x, int y) {
		
		int min = (x < y) ? x : y;
		return min;
		
	}
	
	// Switch Problem
	public static void Switch(double x, int Case) {
		
		// String
		String str1 = "I am Learning Core Java";
		StringTokenizer Tokenizer = new StringTokenizer(str1," ");	
		String[] S = new String[100];	
		int i = 0;
		
		switch(Case) {
			case 1:
				x = Math.sqrt(x);
				System.out.println(x);
				break;
			case 2:
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				break;
			case 3:
				while(Tokenizer.hasMoreTokens()) {
					S[i] = Tokenizer.nextToken().toString();
					System.out.println(S[i]);
					i++;
				}
				break;
			default:
				System.out.println("Enter correct case number");
			}
		
	}
}
