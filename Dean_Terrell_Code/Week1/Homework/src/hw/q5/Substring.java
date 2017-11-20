package hw.q5;

public class Substring {
	public static void main(String[] args) {
		String str = "Superman no here";
		System.out.println("Original string: Superman no here");
		System.out.println("subString(str, 5): " + subString(str, 5));
	}
	
	public static String subString(String str, int idx) {
		String newString = "";
		for(int i = 0; i < idx; i++)
			newString = newString.concat(String.valueOf(str.charAt(i)));
		return newString;
	}
}
