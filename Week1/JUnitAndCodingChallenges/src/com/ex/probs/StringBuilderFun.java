package com.ex.probs;
import java.util.StringTokenizer;
public class StringBuilderFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Below I play around with String builder and use some of the
		 * methods to show the capabilities of the builder and how its
		 * used. 
		 */
		StringBuilder name = new StringBuilder("ABoogie");
		String food = new String("Pizza,Sandwiches,Lasagna,Cookies"); //
		System.out.println("Original String Builder: " + name); //before method call on String builder object
		
		/*
		 * deleteCharAt method deletes char at given index
		 */
		System.out.println("Size of String Builder: " + name.length());
		name.deleteCharAt(0); 
		System.out.println("Modified String Builder: " + name); 
		System.out.println();
		
		/*
		 * setCharAt places a char in the given index. one thing to  note,
		 * the deleteCharAt truncates the original string making is not the same length
		 */
		
		System.out.println("String Builder Size After Modification: " + name.length());
		name.setCharAt(0, 'A');
		System.out.println("Modified String Builder w/ setCharAt: " + name);
		
		/* 
		 * the reverse method reverses the characters in the string. Refer to 
		 * CodingChallenges.java reverseIt method to understand the concept
		 * of what the reverse function does. 
		 */
		name.reverse();
		System.out.println("Modified String Builder w/ reverse: " + name);
		System.out.println();
		
		/*Below the StringTokenizer is used to separate the foods in the given 
		 * string. 
		 */
		
		System.out.println("Original String w/ Delimeters: " + food);
		System.out.println("String parts after tokenizing: ");
		StringTokenizer str = new StringTokenizer(food, ",");
		while (str.hasMoreTokens()) {
			System.out.print(str.nextToken() + " ");
		}
		System.out.println();
		System.out.println();
		/* creating 2 string objects and then adding them together. To 
		 * 
		 */
		
		String favNum = new String("31");
		String favNumTwo = new String("29");
		
		System.out.println("First Number: " + favNum + "\n" + "Second Number: " + favNumTwo + "\n" + "Numbers Added: " + (Integer.parseInt(favNum) + Integer.parseInt(favNumTwo)));
		System.out.println();
		/*
		 * Calling garbage collector manually
		 */
		
		Runtime runtimee = Runtime.getRuntime();
		
		/*calling the freeMemory method indicates how much free memory
		 * there is available in the Java Virtual machine. To show
		 * that the garbage collector frees up space, I'm calling
		 * the method before and after I call the garbage collector
		 */
		
		System.out.println("The amount of free memory in bytes: " + runtimee.freeMemory());
		
		runtimee.gc();
		
		System.out.println("The amount of free memory in bytes: " + runtimee.freeMemory());
		 /* the toString method can return the string representation of the object
		  * calling it. in this case, I decided to use the method on the runtime object
		  * out of curiosity!
		  */
		String runtimer = runtimee.toString();
		System.out.println("String Representation of Runtime Object: " + runtimer);
		
	}

}
