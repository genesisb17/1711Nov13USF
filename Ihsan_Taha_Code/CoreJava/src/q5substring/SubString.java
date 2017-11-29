package q5substring;

public class SubString {
	public static void main(String[] args) {
		String str = "12345";
		System.out.println(mySubString(str,3));
	}
	
	static String mySubString(String str, int idx) {
		char[] temp = new char[idx];
		for (int i = 0; i < idx; i++)
			temp[i] = str.charAt(i);
		
		return String.copyValueOf(temp);
	}
}
