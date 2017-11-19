package Q12;

public class HundredEven {
	public static void main(String[] args) {
		int[] hundred= new int[100];
		
		for(int i=0;i<100;i++) {
			hundred[i]=i+1;
		}
		
		for(int x:hundred) {
			if(x%2==0) {
				System.out.println(x);
			}
		}
	}
}
