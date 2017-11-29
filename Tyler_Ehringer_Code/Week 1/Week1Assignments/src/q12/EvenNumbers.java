package q12;

import java.util.stream.IntStream;

public class EvenNumbers {
	
	public static void main(String[] args) {
		int[] Numbers = IntStream.rangeClosed(1, 100).toArray();
		for(int i : Numbers) if((i & 1) == 0) System.out.println(i);
	}

}
