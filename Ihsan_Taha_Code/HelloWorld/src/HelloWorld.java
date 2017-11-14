import java.util.Scanner;

public class HelloWorld {
	// comment
	
	/*
	  MultiLine Comment
	 */
	
	// main method
	static public void main(String[] args)
	{
		boolean f = false;
		String name = "Ihsan";
		System.out.println(name);
		
		int x = 5;
		
		Integer ex = new Integer(x);
		
		ex = x; // Autoboxing: CHECK
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Type Something: ");
		String text = scan.nextLine();

		System.out.println("Hello " + text);
		
		int twoDarray[][] = new int[0][1];
		
		twoDarray[0][0] = 2;
		twoDarray[0][1] = 1;
	}
}
