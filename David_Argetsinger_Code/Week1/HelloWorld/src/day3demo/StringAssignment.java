package day3demo;

import java.util.StringTokenizer;

public class StringAssignment {

	public static void main(String[] args) {
		StringBuilder st= new StringBuilder("yellow");
		//three methods to manip
		st.reverse();
		System.out.println(st);
		st.reverse();
		System.out.println(st);
		String str = " ranger";
		st.append(str);
		System.out.println(st);
		// end three methods
		str="orange blue green white";
		StringTokenizer w= new StringTokenizer(str);
		while(w.hasMoreTokens())
			System.out.println(w.nextToken());
//
//		Create two String objects with number values (i.e. “20). Write a method that adds the two.
//		Request garbage collection in your method.
//		Create a Runtime object and note at least three methods. Imagine how you would use them.
		
	}

}
