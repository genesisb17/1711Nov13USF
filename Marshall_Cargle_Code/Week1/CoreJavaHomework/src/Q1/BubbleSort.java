package Q1;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		array=bubbleSort(array);
		for(int num:array)
		System.out.print(num+"  ");
	}
	
	static int[] bubbleSort(int... nums) {
		int extra = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					extra = nums[j];
					nums[j] = nums[i];
					nums[i] = extra;
				}
			}
		}
		return nums;

	}
}
