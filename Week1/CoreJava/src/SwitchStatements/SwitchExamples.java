package SwitchStatements;

public class SwitchExamples {

	public static void main(String[] args) {
		/*
		 * This program will use the switch case statements to run specific
		 * things based on the case
		 */
		int x = 3;
		switch(x) {
		case 1:
			System.out.println(Math.sqrt(36));
			break;
		case 2:
			System.out.println("Today's date is " + "Saturday, November 18 2017");
			break;
		case 3:
			String sentence = "I am learning Java";
			System.out.println(sentence);
			String[] pieces = sentence.split(" ");
			for(String g: pieces)
				System.out.println(g);
		}
	}

}
