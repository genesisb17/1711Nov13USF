package com.foundation.classes;

/**
 * 
 * @author Ihsan Taha
 * Date: 11/15/2017
 * Description:
 * A program that covers the foundation of Java
 */
public class FoundationPractice {
	
	// Doorway to program
	public static void main(String[] args)
	{
		// 1. Valid String Identifiers 
		String _str = "_str", $str = "$str";
		print(_str);
		print($str);
		
		// error String str; print(str);
		
		// Casting
		// error boolean b = 0;
		// error boolean b = false, b = true;
		
		boolean condition = false;
		System.out.println(condition);
		
		System.out.println("Byte:\t" + Byte.SIZE);
		System.out.println("Short:\t" + Short.SIZE);
		System.out.println("Int:\t" + Integer.SIZE);
		System.out.println("Float:\t" + Float.SIZE);
		System.out.println("Float:\t" + Long.SIZE);
		System.out.println("Double:\t" + Double.SIZE);
		
		byte b = 65;
		short s = 32767;
		int i = 2_147__483_647;
		float f = 123456789012345678901234567890123456789.123456789012345678901234567890123456789012345678900000000000000000000000000099999f; // 39 digits
		float f2 = 12345678901234567890123456789012345678.9123456789012345678901234567890123456789012345678900000000000000000000000000099999f; // 39 digits
		float f3 = 123.45E5f;
		long l = 0;
		// error long l = 0.0;
		long l2 = 0l;
		// error long l3 = 012345678L;
		// error long l3 = 9.3E5L;
		long l4 = 92233720379999999L;
		
		double d = 0001.0d;
		
		System.out.println(f);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(l);
		System.out.println(l2);
		System.out.println(l4);
		System.out.println(d);
		
		char a = 'a';
		
		if (a > 15)
			System.out.println(true);
		else
			System.out.println(false);
		
		b = (byte)a;
		System.out.println(b);	
		a = (char)b;
		System.out.println(a);
		
		i = 99999;
		a = (char)i;
		System.out.println(a);
		
		f = 001.0010f;
		a = (char)f;
		System.out.println(a);
		
		// error can't mix boolean with any other primitive i = (int)condition;
		
		// Implicit Casting
		s = b;
		i = s;
		f = i;
		d = f;
		f = l;
		d = l;
		
		// Explicit Casting
		l = (long)d;
		f = (float)d;
		l = (long)f;
		i = (int)l;
		s = (short)i;
		b = (byte)a;
		b = (byte)s;
	
	}
	
	public static void print(String s)
	{
		System.out.println(s);
	}

}
