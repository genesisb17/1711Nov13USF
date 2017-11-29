package q5;

public class SubString {

	
	public static String subString(String str, int length) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String test = "This is a test string";
		System.out.println(subString(test, 11));
	}
}
