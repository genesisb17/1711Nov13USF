package day3demo;

import java.util.StringTokenizer;

public class StringsandThings {

	public static void main(String[] args) {
		
/*		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str.concat(" world");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str + " " + buff + " " + build);
		
*/
		// StringBuilder Object
		StringBuilder B = new StringBuilder("Hello");
		
		// Replace
		System.out.println(B.replace(0, B.length() , "Hi"));
		
		// Append
		System.out.println(B.append(" Yosuf"));
		
		// Subsequence
		System.out.println(B.subSequence(3, B.length()));
		
		// Tokenizer
		
		String str = "pickles:ketchup:mustard:onion";
		
		StringTokenizer Tokenizer = new StringTokenizer(str,":");
		
		for(int i = 0; i < Tokenizer.countTokens();i++) {
			System.out.println(Tokenizer.nextToken());
		}
		
		
	}
	
	
}
