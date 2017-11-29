package com.codingchallenges;

public class StringBuilders {
	
	public static void main(String[] args)
	{
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("This is a string appended to strBuilder");
		System.out.println(strBuilder);
		
		strBuilder.reverse();
		System.out.println(strBuilder);
		
		strBuilder.reverse();
		strBuilder.delete(10, 12);
		System.out.println(strBuilder.replace(27, 35, "your fing"));		
	}

}
