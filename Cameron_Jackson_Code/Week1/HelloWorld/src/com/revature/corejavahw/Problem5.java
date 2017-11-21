package com.revature.corejavahw;

public class Problem5 {

	public static void main(String[] args) {
		String str = mySubstring("Sub this String", 8);
		System.out.println(str);
	}
	
	public static String mySubstring(String str, int idx) {
		char[] strarr = str.toCharArray();
		char[] newarr = new char[idx];
		for (int i = 0; i < idx; ++i) {
			newarr[i] = strarr[i];
		}
		return new String(newarr);
	}

}
