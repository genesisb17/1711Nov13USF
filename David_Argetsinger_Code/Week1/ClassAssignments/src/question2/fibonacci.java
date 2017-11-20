package question2;

public class fibonacci {
	/*
	 * first 20 fibs
	 */
	public static void main(String[] args) {
		System.out.println("0");
		//initial 0;
		int a=0;
		int b=1;
		for (int i = 0 ; i<12;i++)
		{
		System.out.println(a+b);
			b+=a;
		System.out.println(a+b);
			a+=b;
		}
		System.out.println(a+b);
		//due to uneven requested number of fibs 
			
	}
}
