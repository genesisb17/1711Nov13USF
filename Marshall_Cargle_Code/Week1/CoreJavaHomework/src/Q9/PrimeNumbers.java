package Q9;

import java.util.ArrayList;

public class PrimeNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		boolean check = true;

		for (int i = 0; i <= 99; i++) {
			array.add(i+1);
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
