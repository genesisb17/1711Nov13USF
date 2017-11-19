package Q3;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		
		
		try(Scanner sc=new Scanner(System.in);){
			System.out.println("Input String: ");
			String input=sc.nextLine();
			String rev=reverse(input);
			System.out.println(rev);
			
		}
		
	}
	
	static String reverse(String str) {
		String rev="";
		if(str.length()<2) {
			rev=str;
		} else {
			rev=str.substring(str.length()-1);
			rev+=reverse(str.substring(0, str.length()-1));
		}
		
		return rev;
	}
}
