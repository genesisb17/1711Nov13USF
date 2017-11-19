package com.codingchallenges;

public class CodingChallenges {
	
	public int fact(int n) {
		int result;
		
		if (n < 0)
			System.out.println("invalid input");
		
		if (n == 1)
			return 1;
		result = fact(n -1)*n;
		
		return result;
		
	}

	public String reverseString(String str)
	{	
		char c[] = str.toCharArray();
		char r[] = new char[str.length()];
		
		for (int n = c.length-1, i = 0; n >= 0; n--, i++)
			r[i] = c[n];
		
		str = String.copyValueOf(r);
		return str;		
	}
	
}
