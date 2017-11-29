package Q19;

import java.util.ArrayList;
import java.util.List;

public class ArrayList10 {
	public static void main(String[] args) {
		List<Integer> nums=new ArrayList<>();

		int sumEven=0;
		int sumOdd=0;

		for(int i=0;i<10;i++) {
			nums.add(i+1);
		}

		System.out.println("The array: ");
		for(int i=0;i<10;i++) {
			System.out.println(nums.get(i));
		}

		for(int i=0;i<10;i++) {
			if(nums.get(i)%2==0) {
				sumEven+=nums.get(i);
			} else {
				sumOdd+=nums.get(i);
			}
		}

		int numprimes=1;
		while(numprimes>0) {
			numprimes=0;
			for(int i=0;i<nums.size();i++) {
				if(isPrime(nums.get(i))){
					nums.remove(i);
					numprimes++;
				}
			}
		}
		

		System.out.println("Sum of even numbers: "+sumEven);
		System.out.println("Sum of odd numbers: "+sumOdd);

		System.out.println("The array without primes:");
		for(int i=0;i<nums.size();i++) {
			System.out.println(nums.get(i));
		}
	}

	static boolean isPrime(int num){
		boolean check=true;
		int count=0;
		if(num>3){
			for (int i=num-1;i>1;i--){
				if(num%i==0){
					count++;
				}
			}
		}
		if(count>0){
			check=false;
		}
		return check;
	}
}
