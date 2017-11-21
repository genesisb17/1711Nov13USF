package Q5;

import java.util.Scanner;

public class SubStringType {
	public static void main(String[] args) {
		System.out.println("What word?");
		Scanner scan = new Scanner(System.in);
		char[] test=scan.nextLine().toCharArray();
		System.out.println("To how many letters?");
		int here = Integer.parseInt(scan.nextLine());
		for(int i=0;i<here;i++)
			System.out.print(test[i]);		
	}
}
