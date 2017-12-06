package com.q3;

public class ReverseString {
	
	public static void main(String[] args) {
		
		String str = "abcdef";
		
		String solution = reverseString(str);
		
		System.out.println(solution);
		
		
			
	}
	
	 
	static public String reverseString(String s) {
		
		int length = s.length();
		
		char[] string_arr = s.toCharArray();
		
		char[] answer  = new char[length];
		
		System.out.println();
		
		int tracker = 0;
		
		while(tracker < length) {
			
			answer[tracker] = string_arr[length-1];
			
			answer[length-1] = string_arr[tracker];
			
			tracker++;
			
			length--;
			
		}
		s = new String(answer);
		return s;
	}
}
