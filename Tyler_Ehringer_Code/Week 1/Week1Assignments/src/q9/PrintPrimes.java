package q9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintPrimes {

	public static List<Integer> printPrimesTo(int n) {
		return IntStream.rangeClosed(1, n).parallel()
				.filter(i -> {
					if (i == 1) return false;
					for (int p = 2; p <= Math.sqrt(i); p++) if (i % p == 0) return false;
					return true;
				}).boxed().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		printPrimesTo(10000000);
		long end = System.nanoTime();
		System.out.println((end - start) / 1000000000.0f);
	}
}
