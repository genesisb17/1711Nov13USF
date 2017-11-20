package q6;

public class Even {

	public static boolean isEven(int n) {
		return (n & 1) == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isEven(14));
		System.out.println(isEven(27));
	}
	
}
