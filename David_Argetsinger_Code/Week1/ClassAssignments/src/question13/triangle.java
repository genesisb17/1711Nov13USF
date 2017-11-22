package question13;

public class triangle {
	public static void main(String[] args) {
		int rows= 10;
		for(int i = 0; i <rows; i++){ 
			for(int j = 0; j <rows-1; j++) 
			{
				if(i+j%2==0)
					System.out.print("0");
					else 
						System.out.print("1");
			}
			System.out.println("");
		}
	}
}
