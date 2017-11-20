package q4;

import java.util.stream.IntStream;

public class Factorial {
	
	public static int factorial(int n) throws IllegalArgumentException {
		if(n < 0) throw new IllegalArgumentException("Factorial not defined for negative values: " + n);
		return n <= 1 ? 1 : n * factorial(n - 1);
	}
	
	public static void main(String[] args) throws Exception{
		IntStream.of(5, 1, 0, 14).forEach(i -> System.out.println(i + " : " + factorial(i)));
	}

}
