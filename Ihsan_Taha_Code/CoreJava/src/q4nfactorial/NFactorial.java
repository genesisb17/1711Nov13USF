package q4nfactorial;

public class NFactorial {
	public static void main(String[] args) {
		System.out.println(nFactorial(5));
	}
	
	static int nFactorial(int n) {
		if (n == 1)
			return n;
		else
			return n * nFactorial(n-1);
	}
}
