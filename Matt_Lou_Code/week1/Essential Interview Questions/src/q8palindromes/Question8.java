package q8palindromes;

import java.util.ArrayList;

public class Question8 {

	public static void main(String[] args) {
		String[] str = { "karan", "madam","tom", "civic", "radar", "sexes", "jimmy",
				"kayak", "john", "refer", "billy", "did" };
		ArrayList<String> normal = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		for(int i = 0; i < str.length; i++) {
			normal.add(str[i]);
			if(str[i].contentEquals(str[i])) {
				palindromes.add(str[i]);
			}
			System.out.println(normal.get(i));
			System.out.println(palindromes.get(i));
		}
		
	}

}
