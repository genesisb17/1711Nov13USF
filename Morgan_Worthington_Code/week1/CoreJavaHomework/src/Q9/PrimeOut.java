package Q9;

import java.util.ArrayList;
import java.util.List;

public class PrimeOut {
	public static void main(String[] args) {
		
		List<Integer> l=new ArrayList<>();
		for(int i=1;i<=100;i++) {
			l.add(i);
		}
		
		for(int i=0;i<l.size();i++) {
			if(isPrime(l.get(i))) {
				System.out.println(l.get(i));
			}
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
