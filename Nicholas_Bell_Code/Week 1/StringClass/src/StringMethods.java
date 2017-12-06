import java.util.Scanner;

public class StringMethods {
	public static void main(String[] args) {
		String example = "Words";
		
		//turn "words" to "wordy"
		example = example.replace('s', 'y');
		System.out.println(example);
		//get new word
		Scanner sc = new Scanner(System.in);
		String example2 = sc.nextLine();		
		System.out.println(example2);
		System.out.println("String 1 is equal to string 2: " + example.equals(example2));
		
		
	}

}
