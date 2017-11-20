package q10;

public class Minimum {
	
	static int min(int a, int b) {
		return a < b ? a : b;
	}
	
	public static void main(String[] args) {
		System.out.println(min(23, 43));
		System.out.println(min(74, 34));
	}

}
