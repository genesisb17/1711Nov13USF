package day2demo;

import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		
		int[] arr = new int[4];
		
		try {
			arr[0] = 1;
			arr[6] = 6; //throws ArrayIndexOutOfBoundsException (the array has no sixth index)
			arr[3] = 4; //this is not executed since an exception thrown before
				
		}
	
		catch (RuntimeException re) {
			re.printStackTrace();
		}

		// UNREACHABLE CODE: because ArrayIndexOutOfBoundsException is a type of RuntimeException
//		catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
		
		finally {
			System.out.println("passed exception");
			System.out.println(arr[3]);
			
			
			//needs to be surrounded by a try/catch block since the method throws an IOException
			try {
				exampleException(6);
			} 
			
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void exampleException(int num) throws IOException {
		System.out.println("We are in exampleException() method...");
		throw new IOException();
	}
}
