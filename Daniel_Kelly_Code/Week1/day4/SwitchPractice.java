package com.revature.day4;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

public class SwitchPractice {

	public static void main(String[] args) {
		
		int i = 3;
		
		switch(i){
		case 1:
			System.out.println("Enter a number: ");
			Scanner scan = new Scanner(System.in);
			int number = scan.nextInt();
			int sq = (int) Math.sqrt(number);
			System.out.print(sq + "is the square root.");
			break;
		case 2:
			ZoneId zonedId = ZoneId.of( "America/Tampa" );
			LocalDate today = LocalDate.now( zonedId );
			System.out.println( "today : " + today );
			break;
		case 3:
			String x = "I am learning core Java";
			for(String y : x.split(" ")){
				System.out.println(y);
			}
		}

	}

}
