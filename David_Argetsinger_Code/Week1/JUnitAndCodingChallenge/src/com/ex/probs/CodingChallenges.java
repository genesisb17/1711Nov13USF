package com.ex.probs;

public class CodingChallenges {

	public int factorial(int n){
		if (n<0) {System.out.println("cannot be less than zero");
		return 0;}
		if (n == 0)
			return 1;
		else 
			return (n*factorial(n-1));
		
		/*
		int total=1;
		for(int i = 1 ; i <=n ; i++)
		{
			total*=n;
		}
		return total;
		*/
	}
	public String reverseString(String s)
	{
		for (int i = s.length()-1; i<0; i++)
		{
			s+=s.charAt(i);
			s=s.substring(i);
		}
		return s;
	}
	
}
