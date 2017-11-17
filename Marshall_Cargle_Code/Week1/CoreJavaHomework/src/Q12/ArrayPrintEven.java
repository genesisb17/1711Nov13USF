package Q12;

public class ArrayPrintEven {
	public static void main(String[] args) {
		double[] array = new double[100];
		double num=1;
		for(int i=1; i<=100;i++)
			array[i-1]=i;
		for(double count:array)
			if(count%2==0)
				System.out.println(count);
	}
}
