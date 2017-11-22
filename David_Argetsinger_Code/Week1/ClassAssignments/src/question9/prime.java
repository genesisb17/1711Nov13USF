package question9;

import java.util.ArrayList;

public class prime {
	static boolean isprime(int in)
	{
		for (double i=in-1.00; i>= 2; i--){
			if (in%i==0)
				return false;
		}
		return true;
	}
	
	static void primec(){
		ArrayList<Integer> list1=new ArrayList<Integer>(101);
		
		for(int i = 1; i <101; i++)
			list1.add(i);
		System.out.println("1 is prime");
		for(int i = 1 ; i <100; i++)
		{
			
			if(isprime(list1.get(i)))
				System.out.println(list1.get(i) + "is prime");
			
		}	
	}
	public static void main(String[] args) {
		primec(); 	
	}
}
