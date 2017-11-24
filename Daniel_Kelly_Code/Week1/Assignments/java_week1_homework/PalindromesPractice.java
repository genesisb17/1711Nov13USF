package com.revature.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromesPractice {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		
		System.out.println(al.toString());
		
		ArrayList<String> pal = new ArrayList<String>();
		
		for(String st : al)
		{
			if(st.equals(new StringBuilder(st).reverse().toString())){
				pal.add(st);
			}
		}
		
		System.out.println(pal.toString());

	}

}
