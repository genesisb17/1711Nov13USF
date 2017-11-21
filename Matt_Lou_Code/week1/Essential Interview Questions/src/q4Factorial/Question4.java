package q4Factorial;

public class Question4 {

	public static void main(String[] args) {
		
		int num = 3;
		System.out.println(factorial(4));
	}
	
	static int factorial(int num) {
		if(num == 1) {
			return num;
		}
		else if(num >= 1) {
			return num * factorial(num - 1);
		}
		return num;
	}
}
