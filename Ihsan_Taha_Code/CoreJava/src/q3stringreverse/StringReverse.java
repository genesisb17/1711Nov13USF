package q3stringreverse;

public class StringReverse {
	public static void main(String[] args) {
		String s1 = "Hello";
		myReverse(s1);
	}

	static void myReverse(String s) {
		for (int i=s.length()-1;i>=0; i--)
			System.out.print(s.charAt(i));
	}
}
