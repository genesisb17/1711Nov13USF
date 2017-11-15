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

}
