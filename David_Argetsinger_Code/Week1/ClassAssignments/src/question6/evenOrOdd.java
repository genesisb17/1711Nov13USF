package question6;

import java.util.Scanner;


public class evenOrOdd {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int into=Integer.valueOf(in.nextLine());
		if(iseven(into))
		System.out.println(into+ " Is even");
		else 
			System.out.println(into+ " is not even");
		
	}
	static boolean iseven(int in){
		int hold= in/2;
		if(hold*2==in)
		return true;
		return false;
	}
}
