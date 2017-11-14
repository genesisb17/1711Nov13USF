import java.util.Scanner;

public class ControlFlow {
	public static void main(String[] args)
	{
		/*
		 * A java statemnet is a complete unit of execution
		 * with a semicolon following it
		 * 
		 * A control flow statement breaks up the flow of
		 * execution by using decision making, looping, & branching,
		 * allowing the application to selectively execute
		 * particular segment of code
		 */
		
		System.out.print("Enter a number: ");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		if (x<10)
		{
			System.out.println("Hello");
		}
		else if(x < 100)
		{
			System.out.println("World");
		}
		else
		{
			System.out.println("Good Bye");
		}
		
		// Ternary
		System.out.println(x<10?"Hello":"World");
		
		// While
		while(x<5)
		{
			System.out.println("While Statement: " + x);
			x++;
		}
		
		//Do-While
		do
		{
			System.out.println("Do-While Statement: " + x);
			x++;
		} while (x < 10);
		
		// For Loop
		for(int i = 0; i < x; i++)
		{
			System.out.println("For Loop: " + x);
		}
		
		/*
		 * some notes on for loop:
		 * 1. initialization statement executes
		 * 2. if boolean expression is true, else exit loop
		 * 3. execute body
		 * 4. execute update statement
		 * 5. return to step 2
		 */
		
		int[] nums = {0, 2, 4, 6, 8};
		int sum = 0;
		for(int n : nums)
		{
			sum += n;
		}
		System.out.println(sum);
		
		x = 1;
		// Switch
		/*
		 * can hold int, byte, short, shrt, char, string, enum
		 */
		switch(x)
		{
		case 0:
		case 1:
			System.out.println("x is 0 or 1");
			break;
		case 5:
			System.out.println("x is 5");
		case 10:
			System.out.println("x is 10");
		default:
			System.out.println("x is " + x);
		}

	}
}
