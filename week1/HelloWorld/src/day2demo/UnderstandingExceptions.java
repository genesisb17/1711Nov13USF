package day2demo;

import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		int[] arr = new int[4];
		arr[0] = 1;

		try{
			arr[7] = 6;
		}catch(ArithmeticException e){
			arr[arr.length-1] = 2;
			e.printStackTrace();
		}/*catch(RuntimeException re){
			re.printStackTrace();
		}*/
		finally{
			System.out.println("\n" + arr[3]);
			System.out.println("passed exception");
			
			try {
				exampleException(6);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void exampleException(int num) throws IOException{
		System.out.println("we are in example exception method");
		throw new IOException();
	}
	
	/*
	 * - Never Hide Exceptions. At the least log them. printStackTrace
	 * 	 method prints the entire stack trace when an exception occurs. 
	 * 	 If you handle an exception, it is always a good practice to log
	 *   the trace.
	 * - Do not use exception handling for flow control in a program. They 
	 * 	 have a significant performance impact.
	 * - Think about the user. What does the user want to see if there 
	 *   is an exception?
	 * - Think about the support developer. What does the support developer 
	 *   need to debug the exception?
	 * - Think about the calling method. Can the calling method do something
	 * 	 about the exception being thrown? If not, create un checked 
	 *   exceptions. For example, Spring Framework chooses to make most of 
	 *   the jdbc exceptions as unchecked exceptions because , in most cases,
	 *   there is nothing that a caller of the method can do about a jdbc exception

	 */

}
