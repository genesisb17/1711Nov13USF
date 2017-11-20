package q12;

import java.util.stream.IntStream;

public class EvenNumbers {
	
	public static void main(String[] args) {
		int[] evenNumbers = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).toArray();
		for(int i : evenNumbers) System.out.println(i);
	}

}
