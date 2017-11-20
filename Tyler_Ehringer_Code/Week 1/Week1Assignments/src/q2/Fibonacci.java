package q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Fibonacci {
	
	public static List<Integer> fibs(int number) {
		List<Integer> fibs = new ArrayList<Integer>(Arrays.asList(1, 1));
		for(int n : IntStream.range(2, number).toArray()) fibs.add(fibs.get(n-1) + fibs.get(n-2));
		return fibs;
	}
	
	
	public static void main(String[] args) {
		for(Integer n : fibs(25)) System.out.println(n);
	}
}


