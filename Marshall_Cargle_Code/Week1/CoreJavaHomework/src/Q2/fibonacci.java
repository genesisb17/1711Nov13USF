package Q2;

public class fibonacci {
	public static void main(String[] args) {
		int temp1 = 0;
		int temp2 = 1;
		System.out.println(temp1+"\n"+temp2);
		int print=0;
		for(int i=2;i<25;i++) {
			print=temp1+temp2;
			System.out.println(print);
			temp1=temp2;
			temp2=print;
		}
	}
}
