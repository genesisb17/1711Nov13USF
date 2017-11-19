package Q2;

public class Fibonacci {
	public static void main(String[] args) {
		int add1=0;
		int add2=1;
		System.out.println(add1);
		System.out.println(add2);
		for(int i=0;i<23;i++) {
			int add3=add1+=add2;
			System.out.println(add3);
			add1=add2;
			add2=add3;
		}
		
	}
}
