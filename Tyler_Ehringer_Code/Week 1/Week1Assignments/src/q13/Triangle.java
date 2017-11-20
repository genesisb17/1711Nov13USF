package q13;

public class Triangle {
	
	public static void main(String[] args) {
		String s = "0101010101";
		int index = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(s.charAt(index++));
			}
			System.out.println();
		}
	}

}
