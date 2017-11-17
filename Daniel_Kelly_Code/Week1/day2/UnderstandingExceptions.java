package com.revature.day2;

import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) {
		
		try{
		int[] arr = new int[4];
		arr[0] = 1;
		arr[6] = 6;
		}catch(ArithmeticException e){
			e.printStackTrace();
		}/*catch(RuntimeException re){
			re.printStackTrace();
		}
		*/
		
		//finally always runs even if exception not caught
		finally{
			System.out.println("passed exception");
		}
		
		//exampleException(6);

	}
	
	void exampleException(int num)throws IOException{
		System.out.println("we are in example exception method");
		throw new IOException();
	}

}
