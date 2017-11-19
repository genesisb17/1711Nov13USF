package Q8;

import java.util.ArrayList;
import java.util.List;

public class PalindromeList {

	public static void main(String[] args) {
		List<String> given= new ArrayList<>();
		given.add("karan");
		given.add("madam");
		given.add("tom");
		given.add("civic");
		given.add("radar");
		given.add("sexes");
		given.add("jimmy");
		given.add("kayak");
		given.add("john");
		given.add("refer");
		given.add("billy");
		given.add("did");
		
		List<String> palindromes=new ArrayList<>();
		
		for(int i=0;i<given.size();i++) {
			if(isPalindrome(given.get(i))) {
				palindromes.add(given.get(i));
			}
		}
		
		for(int i=0;i<palindromes.size();i++) {
			System.out.println(palindromes.get(i));
		}
	}
	
	static boolean isPalindrome(String str) {
		boolean check=false;
		if(str.length()<=1) {
			check=true;
		} else {
			if(str.charAt(0)==str.charAt(str.length()-1)) {
				check=isPalindrome(str.substring(1, str.length()-1));
			}
		}
		return check;
	}
}
