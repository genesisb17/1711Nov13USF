package Q5;

import java.util.Scanner;

public class Substring {
	public static void main(String[] args) {
		System.out.println("Input string: ");
		
		try(Scanner sc=new Scanner(System.in);){
			String input=sc.nextLine();
			System.out.println("Input upper bound of substring: ");
			int ub=sc.nextInt();
			if(ub>input.length()) {
				System.out.println("Upper bound longer than string. Assumed to be length of string.");
				ub=input.length();
			}
			String sub=substring(input, ub);
			System.out.println("The substring is "+sub);
		}
	}
	
	public static String substring(String str, int upper) {
		String sub="";
		for(int i=0;i<upper;i++) {
			sub+=str.charAt(i);
		}
		
		return sub;
	}
}
