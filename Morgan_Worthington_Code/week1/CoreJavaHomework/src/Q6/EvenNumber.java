package Q6;

import java.util.Scanner;

public class EvenNumber {
	public static void main(String[] args) {
		System.out.println("Input number: ");
		
		try(Scanner sc=new Scanner(System.in);){
			int num=sc.nextInt();
			int div=num/2;
			if(div*2==num) {
				System.out.println(num+" is even.");
			} else {
				System.out.println(num+" is odd.");
			}
		}
	}
}
