package day2demo;

import java.util.Scanner;

public class ControlFlow {

	public static void main(String[] args) {
		// java statement is a complete unit of execut ion with a semiclon following it 
		//  a control flow statement breaks up the flow of execution
		// using decision making looping and branching
		//allowing the application to selectively execute 
		// particular segments of code 
		System.out.println("enter a number");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x<10)
			System.out.println("hello");
		else if(x<100) 
			System.out.println("world");
		else
			System.out.println("audios");
		
		//ternary
		System.out.println(x<10? "hello" : "goodbye");
		
		//while 
		do{
			x++;
			if (x==3) continue;//skips to next iteration 
			System.out.println("DO-WHILE STATEMNET: " + x);
			
		}while(x<5);
		//for 
		for(int i = 0; i< x;){
			System.out.println("wwwwww " + i);
			i++;
		}
		/*
		 * some nots about for loop: 
		 * 1 initalization statment exectu
		 * 2 if boolean exp is true, else exit 
		 * 3 execute body 
		 * 4 execute update statement
		 * 5 return to 2 
		 * 
		 */
		
		//foreach or enhanced 
		int [] nums={2,4,5,7,2,351,53,13};
		int sum =0;
		for(int y: nums){
			sum += y;
		}
		System.out.println(sum);
		
		//switch
		// can hold int byte short char string enum
		switch(x)
		{
		case 1:
		case 2:
		case 3:
			System.out.println("x is 1");
			
		case 5:
			System.out.println("x is 5");
			break;//breaks  entire loop 
			
		case 10:
			System.out.println("x is 10");
			
		default:
			System.out.println("bububububu");
			
		}
		
		
		Operations k = Operations.ADD;
		
		System.out.println(k.calculate(10, 10));
		
		}

	}


