package q19;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTricks {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toCollection(ArrayList::new)); // create list of integers 1-10
		list.stream().forEach(System.out::println); // print list
		System.out.println(list.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum)); // print sum of even elements
		System.out.println(list.stream().filter(i -> i % 2 == 1).reduce(0, Integer::sum)); // print sum of odd elements
		list = list.stream().filter(a -> {
			if(a == 1) return false;
			for(int i = 2; i <= Math.sqrt(a); i++) {
				if(a % i == 0) return false;
			}
			return true;
		}).collect(Collectors.toCollection(ArrayList::new)); // remove prime elements
		list.stream().forEach(System.out::println); // print list
	}
}
