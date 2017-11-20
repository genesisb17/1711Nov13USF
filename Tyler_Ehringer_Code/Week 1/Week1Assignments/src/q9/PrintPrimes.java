package q9;

import java.util.stream.IntStream;

public class PrintPrimes {

	public static void printPrimesTo100() {
		IntStream.rangeClosed(1, 100).filter(i -> {
			if (i == 1) return false;
			for (int p = 2; p <= Math.sqrt(i); p++) if (i % p == 0) return false;
			return true;
		}).forEach(System.out::println);
	}

	public static void main(String[] args) {
		printPrimesTo100();
	}
}
