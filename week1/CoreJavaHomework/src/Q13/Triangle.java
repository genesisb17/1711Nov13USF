package Q13;

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Input lines of triangle: ");
			int lines=sc.nextInt();
			for(int i=1;i<=lines;i++) {
				if(i%2!=0) {
					for(int j=0;j<i;j++) {
						System.out.print(j%2+" ");
					}
				} else {
					for(int j=0;j<i;j++) {
						System.out.print((j+1)%2+" ");
					}
				}

				System.out.println();
			}
		}
	}
}
