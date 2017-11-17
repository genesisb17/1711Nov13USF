package com.revature.day4;


public class EvenNumber {

	public static String evenNumber(int a){
		
		//works because odd would give you a fraction and since it's an integer it will not 
		//include the remainder
		if((a/2)*2 == a){
			return a + " is an even number";
		}else{
			return a + " is an odd number";
		}
	}
}
