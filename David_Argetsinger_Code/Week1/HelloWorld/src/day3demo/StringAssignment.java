package day3demo;

import java.util.StringTokenizer;

public class StringAssignment {

	private static Runtime rt;
	//Runtime.Process exec (...) allows for multithtreading has multiple overloaded 
	//Runtime.exit(int) terminates virtual machine, will close the program 
	//Runtime.halt  will also terminate the machine but will not wait for finalizers to finish ( is dangerous)
	//Runtime.load(string) used for loading into the dynamic library 
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
		
		str="20";
		String str1="10";
		int integ=Integer.valueOf(str1)+Integer.valueOf(str);
		System.out.println(integ);
		System.gc();

		
		
	}

}
