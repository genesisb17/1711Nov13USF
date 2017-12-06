package com.ex.probs;

public class CodingChallenges {

	
	public int factorial(int n) {
		if (n < 1) return -1;
		if (n == 1) return n;
		else
			return n * factorial (n-1);
	}
	
	public String reverseString(String s) {
		int len = s.length();
		char[] sarr = new char[len];//<---this isn't necessary with
		char[] ans  = new char[len];//
		sarr = s.toCharArray();     //<---this line. just char[] sarr = s.toCharArray()
		for(char l : sarr) {
			System.out.print(l);
		}
		System.out.println();
		int track = 0;
		while(track < len) {
			ans[track] = sarr[len-1];
			ans[len-1] = sarr[track];
			track++;
			len--;			
		}
		s = new String(ans);
		return s;
	}
}
