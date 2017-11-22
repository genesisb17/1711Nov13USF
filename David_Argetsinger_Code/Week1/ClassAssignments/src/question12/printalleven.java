package question12;

import java.util.ArrayList;

public class printalleven {
	static boolean iseven(int in)
	{
			if (in%2==0)
				return false;
			else
		return true;
	}
	
	static void primec(){
		ArrayList<Integer> list1=new ArrayList<Integer>(101);
		
		for(int i = 1; i <101; i++)
			list1.add(i);
		for(int i: list1)
		{
			if(iseven(i))
				System.out.println(list1.get(i) + "is even");
			
		}	
	}
	public static void main(String[] args) {
		primec(); 	
	}


}
