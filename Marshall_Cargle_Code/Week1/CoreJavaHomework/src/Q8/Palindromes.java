package Q8;

import java.util.ArrayList;

public class Palindromes {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> palindromes = new ArrayList<>();
		names.add("karen");
		names.add("madam");
		names.add("tom");
		names.add("civic");
		names.add("radar");
		names.add("sexes");
		names.add("jimmy");
		names.add("kayak");
		names.add("john");
		names.add("refer");
		names.add("billy");
		names.add("did");
		for(String name:names) {
			StringBuilder nameReverse=new StringBuilder(name);
			nameReverse.reverse();
			if(name.equals(nameReverse.toString()))
					palindromes.add(name);
		}
		System.out.println(palindromes);
	}
}
