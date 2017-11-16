package Day4Lab;

import java.util.ArrayList;

public class PrimeNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		double random = Math.random();
		double randomFix = random * 100;
		int number = (int) (randomFix + 1);
		boolean check = true;

		for (int i = 0; i <= 99; i++) {
			random = Math.random();
			randomFix = random * 100;
			number = (int) (randomFix + 1);
			array.add(number);
		}
		for (int i = 0; i <= 99; i++) {
			check = true;
			for (int j = 2; j < array.get(i); j++) {
				if (array.get(i) % j == 0)
					check = false;
			}
			if (check == true)
				System.out.println(array.get(i));
		}
	}
}
