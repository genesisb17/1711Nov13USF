package com.revature.hello;

public class Primitives {
	//A class to detail some cool things about primitives and their wrapper classes
	
	
	
	public static void main(String[] args) {
<<<<<<< HEAD
		System.out.println(Integer.MAX_VALUE); // 2
=======
		System.out.println(Integer.MAX_VALUE);
>>>>>>> master
		System.out.println(Integer.MIN_VALUE);
		
		//cannot use commas for separation of digits but can use _
		//underscores have to be located within digits
		int commas = 1_000_000_000;
		//int wrong = _100;
		//int alsowrong = 100_;
		//double doublewrong = 10_._0_;
		
		/*
		 * when a number is present in code, it is called a 
		 * literal. By default, Java assumes you are defining
		 * an int value with a whole number literal. In the 
		 * following example. 98323559823 is out of range for an
		 * int, so we get a compiler error when trying to declare
		 * it without the L signifier. 
		 */
<<<<<<< HEAD
		//long wronglong = 98323559823; // does not compile
		long rightlong = 98323559823L;
		
		long okToCast = 13415;  //automatically casted to long
		
		//octal numbers(digits 0-7), led by 0
		int oct = 017;
		System.out.println(oct);//8+7=15
		
		//hex(0-9,A-F), led by 0x
		int hex = 0xFF;//16*15+15=255
		int hex2 = 0X6A;//6*16+10=106
		System.out.println(hex);
		System.out.println(hex2);
		
		//binary(0-1), led by 0b
		int bin = 0b10010011;//2^0+2^1+2^7+2^4=147
		int bin2 = 0B1010101110;//2^9+2^7+2^5+2^3+2^2+2^1=686
		System.out.println(bin);
		System.out.println(bin2);
		
=======
		//long wronglong = 98_323_559_823; // does not compile
		long rightlong = 98323559823L;
		
		long okToCast = 13415;  //automatically casted to long
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		//octal numbers(digits 0-7)
		int oct = 017;
		System.out.println(oct);
		//hex(0-9,A-F)
		int hex = 0xFF;
		int hex2 = 0X6A;
		
		//binary(0-1)
		int bin = 0b10010011;
		int bin2 = 0B1010101110;
>>>>>>> master
		
		
		
		
		
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> master
