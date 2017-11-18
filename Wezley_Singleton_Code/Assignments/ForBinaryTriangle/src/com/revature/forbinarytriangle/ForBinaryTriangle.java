package com.revature.forbinarytriangle;

/*
 *  - Display the triangle on the console as follows using any type of loop. Do NOT use a simple group of print 
  statements to accomplish this.

		0
		1 0
		0 1 0
		1 0 1 0
 */

public class ForBinaryTriangle {

	public static void main(String[] args) {

		printBinaryTriangle();

	}

	static void printBinaryTriangle() {
		
		// this outer for-loop determines the height of the triangle (4 rows in this case)
		for(int i = 0; i <= 4; i++) {

			/* 
			 *  this inner for-loop handles the creation of the rows for the triangle,
			 *  and ensures that the length of any given row is the same as its current height
			 */
			for(int j = 0; j < i; j++) {

				if (j % 2  == 0) {
					System.out.print("0");
				} 

				else {
					
					// just messing around with if-statements to remove excess whitespace on the ends of rows
					if ((i % 2 == 0) && (j == (i - 1))) {
						System.out.print(" 1");
					}
					
					else {
						System.out.print(" 1 ");
					}
					
				}
				
			}

			/* 
			 *  begins the triangle on the first line of the console, 
			 *  without this is starts on the second line
			 */
			if (i != 0) {
				System.out.println();
			}

		}


	}

}
