package com.q5;

public class MakeSubstring {
	
	public static void main(String[] args) {
		String str = "abcedfg";
		int index = 4;
		//char[] cstr = str.toCharArray();
		char[] answer = new char[index];
		for(int i  = 0; i < index ; i++) {
			answer[i] = str.charAt(i);
		}
		System.out.println(answer);
	}

}
