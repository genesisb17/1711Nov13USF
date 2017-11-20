package q13;

import java.util.Iterator;
import java.util.stream.Stream;

public class Triangle {

	public static void main(String[] args) {
		printTriangle(4);
	}

	public static void printTriangle(int rows) {
		Iterator<Character> iter = Stream.iterate('0', c -> c == '0' ? '1' : '0').iterator();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(iter.next());
			}
			System.out.println();
		}
	}

}
