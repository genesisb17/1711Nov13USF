package p1;

import java.util.Scanner;

public class Stringa{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String example = s.nextLine();
		System.out.println(example.endsWith("a"));
		System.out.println(example.toUpperCase());
		System.out.println(example.replace('e', 'r'));
		System.out.println(example.length());
		System.out.println(example.concat(example));
	}
}
