package com.revature.day3;

public class CodingChallenges {
	
	public int factorial(int n){
		if(n<0){
			System.out.println("cannot be negative"); return 0;
		}
		if(n == 1){
	        return 1;
	    }
	    return n * (factorial(n-1));
	}
	
	public String reverseString(String str){
		if(str.length()==1)
		{
			return str;
		}
		return str.charAt(str.length()-1) + reverseString(str.substring(0,str.length()-1));
	}

}
