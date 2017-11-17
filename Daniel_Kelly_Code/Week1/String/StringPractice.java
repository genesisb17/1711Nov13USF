package com.revature.String;

public class StringPractice {

	public static void main(String[] args) {
		String nameUpper = "Daniel";
		String nameLower = "daniel";
		
		System.out.println("Is Empty " + nameUpper.isEmpty());
		System.out.println("Contains char " + nameUpper.contains("d"));
		System.out.println("Replace char " + nameUpper.replace("D", "B"));
		System.out.println("Equals ignore case " + nameUpper.equalsIgnoreCase(nameLower));
		System.out.println("Hashcode " + nameUpper.hashCode());
		
		
	}
	
}
