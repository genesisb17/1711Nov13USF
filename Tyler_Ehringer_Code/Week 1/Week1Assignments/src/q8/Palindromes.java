package q8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import q3.ReverseString;

public class Palindromes {
	
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", 
				"radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		ArrayList<String> palindromes = strings.stream()
				.filter(s -> s.equals(ReverseString.reverseString(s)))
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(palindromes);
	}
}
