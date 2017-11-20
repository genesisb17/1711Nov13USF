package question3;
/*
 * reverse a string without using a temp variable/reverse()/stringbuffer
 * stringbuilder
 */
public class ReverseString {
	
	public static void main(String[] args) {
		String reverse="RaceCar";
		for(int i=reverse.length(); i>0;i--)
		{
			reverse+=reverse.charAt(i-1);// continues to append the first letter to the last 
		}
		reverse=reverse.substring(reverse.length()/2);
		//cuts off the original word
		System.out.println(reverse);
	}
}
