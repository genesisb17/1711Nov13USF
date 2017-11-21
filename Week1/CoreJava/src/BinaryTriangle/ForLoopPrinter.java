package BinaryTriangle;

public class ForLoopPrinter {
	/*
	 * this program will use a loop to print out a triangle based on 0
	 * and 1's 
	 */
	public static void main(String[] args) {
		for(int x=0; x < 4; x++) {
			if(x==0)
				System.out.println(x);
			else if(x==1)
				System.out.println(x + " " + (x-1) );
			else if(x==2)
				System.out.println((x-1) + " " + (x-2) + " " + (x-1));
			else
				System.out.println((x-x) + " " + (x-2) + " " + (x-x) + " " + (x-2));
		}
	}
}
