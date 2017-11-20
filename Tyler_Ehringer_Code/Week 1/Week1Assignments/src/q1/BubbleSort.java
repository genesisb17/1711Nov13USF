package q1;

import java.util.Arrays;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] vals) {
		for(int i = 0; i < vals.length - 1; i++) {
			for(int j = 0; j < vals.length - 1; j++) {
				if(vals[j] > vals[j+1]) {
					int temp = vals[j+1];
					vals[j+1] = vals[j];
					vals[j] = temp;
				}
			}
		}
		return vals;
	}
	
	public static void main(String[] args) {
		int[] vals = {1,0,5,6,3,2,3,7,9,8,4};
		vals = bubbleSort(vals);
		Arrays.stream(vals).forEach(System.out::println);
	}

}
