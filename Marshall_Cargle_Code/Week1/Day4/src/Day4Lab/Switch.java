package Day4Lab;

import java.util.Date;
import java.util.Scanner;

public class Switch {

	public static Date date = new Date();

	public static void main(String[] args) {
		System.out.println(
				"What would you like to do? \n1=Square Root a number\n2=Print out the Date\n3=Print out a split message\nElse=End");
		Scanner scanIn = new Scanner(System.in);
		method(scanIn.nextInt());
	}

	public static void method(int number) {
		String[] array = new String[2];
		String string = "I am learning Core Java";
		switch (number) {
		case 1:
			System.out.println("Please enter in an Integer:");
			Scanner scanIn = new Scanner(System.in);
			System.out.println(Math.sqrt(scanIn.nextInt()));
			break;
		case 2:
			System.out.println(date);
			break;
		case 3:
			array = string.split(" ");
			for (int i = 0; i < array.length; i++)
				System.out.println(array[i]);
			break;
		}
	}
}
