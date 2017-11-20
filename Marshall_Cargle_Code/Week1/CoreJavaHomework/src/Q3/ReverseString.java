package Q3;

public class ReverseString {
	public static void main(String[] args) {
		String s="Hello";
		for(int i=0; i<s.length();i++)
			s=s.substring(1, s.length()-i)+s.substring(0,1)+s.substring(s.length()-i);
		System.out.println(s);
	}
}
