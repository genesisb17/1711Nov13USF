package hw.q12;

public class EvenPrint {

	public static void main(String[] args) {
		int[] x = new int[100];
		
		for(int i = 0; i < 100; i++)
			x[i] = i+1;
		
		for(int i : x)
			if(i % 2 == 0)
				System.out.printf("%d ", i);
	}
}
