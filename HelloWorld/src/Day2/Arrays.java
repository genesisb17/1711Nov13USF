package Day2;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a = sum();
		int b = sum(1,5,7,8,135,2463,4);
		int c = sum(8,2);*/
		System.out.println("enter numbers to add seperated by a space");
		Scanner sc = new Scanner(System.in);
		String nums = sc.nextLine();
		String[] numStrings = nums.split(" ");
		int[] numArr = new int[numStrings.length];
		for(int i = 0; i <numStrings.length;i++)
		{
			//numStrings[i] = numStrings.length.trim();
			numArr[i]=Integer.parseInt(numStrings[1]);
		}
		System.out.println(sum(numArr));
	
	}
	//what does ... mean??
	//,, - means that it is 0-as many as you want
	//... puts it in an array
	static int sum(int... nums)
	{
		
		int s = 0;
		for(int i:nums)
		{
			s = s+1;
		}
		return s;
	}
}