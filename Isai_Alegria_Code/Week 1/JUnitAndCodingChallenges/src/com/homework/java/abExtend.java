package com.homework.java;

public class abExtend extends abClass{
	
	public boolean upperCheck(String str) {
		
		char[] ch=str.toCharArray();
		for(int i = 0; i<ch.length; i++) {
			if(Character.isUpperCase(ch[i]))
				return true;
			
		}
		
		return false;
		
	}
	
	public  String changeToUpper(String str) {
		
		String temp = str.toUpperCase();
		return temp;
		
	}
	
	public  void stringToInt(String str) {
		
		int result = Integer.parseInt(str);
		result = result + 10;
		System.out.println("String converted with 10 added is " + result);
		
	}
	

}
