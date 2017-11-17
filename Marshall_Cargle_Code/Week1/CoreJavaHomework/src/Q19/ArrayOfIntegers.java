package Q19;

import java.util.ArrayList;

public class ArrayOfIntegers {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		int evenTotal = 0;
		int oddTotal = 0;
		for (int i = 1; i <= 10; i++)
			list.add(i);
		System.out.println(list);
		for (int i = 0; i < 10; i++)
			if (i % 2 == 1)
				evenTotal += list.get(i);
		System.out.println(evenTotal);
		for (int i = 0; i < 10; i++)
			if (i % 2 == 0)
				oddTotal += list.get(i);
		System.out.println(oddTotal);
	}

}
