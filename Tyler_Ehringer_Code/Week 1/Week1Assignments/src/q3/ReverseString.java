package q3;

public class ReverseString {

	public static String reverseString(String s) {
		return s.length() < 1 ? s : s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
	}
	
	public static void main(String[] args) {
		System.out.println(reverseString("This is a string to reverse"));
	}
	
}
