package Q4;

public class factorial {
	public static void main(String[] args) {
		int num=4;
		int count=num;
		int total = 1;
		for (int i = 0; i < count; i++) {
			total *= num;
			num--;
		}
		System.out.println(total);
	}
}
