package q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Switching {
	
	public static void doSwitch(int n) {
		String[] strings;
		switch(n) {
		case 0:
			System.out.println(Math.sqrt(41786));
			break;
		case 1:
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println(df.format(new Date()));
			break;
		case 2:
			strings = "I am learning core Java".split(" ");
			Arrays.stream(strings).forEach(System.out::println);
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		doSwitch(0);
		doSwitch(1);
		doSwitch(2);
	}
	

}
