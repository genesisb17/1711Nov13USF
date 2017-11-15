package day2demo;

import java.util.Scanner;

public class UnderstandingArrays {
	/*
	 * an array is an area of memory on the heap with space 
	 * for a designed number of slements 
	 * var args are variable arguments
	 */
	public static void main(String[] args) {
//		int a = sum();
//		int b= sum(1,5,7,8,135,243,4);
//		int c=sum(5,2);
		
		System.out.println("enter numbers seperated by spaces:");
		Scanner in= new Scanner(System.in);
		
		String num = in.nextLine();
		String[] numStrings=num.split(" "); //regex 
		
		//Arrays.stream(numStrings).map(Integer//lamda);
		int[] numArr = new int[numStrings.length];
		
		for(int i = 0; i< numStrings.length;i++){
			//numStrings[i]=numStrings[i].trim();// only works on front and back
			numArr[i]=Integer.parseInt(numStrings[i]);
		}
		System.out.println(sum(numArr));
		in.close();
	}

	static int sum(int...nums){
	// can have any number of elemets but var nums should be last!
		//don't upt something after variable arguments, so there's no point in more 
		//if you put sum(int x, int..num) you need atleast one 
		//num[0] is invalid as you don't know if num[0] exists
		int s = 0;
		for(int i:nums){
			s=s+i;
		}
		return s;
		}
	
	
}
