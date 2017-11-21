package CommandLiner;

public class Commando {

	public static void main(String[] args) {
		/* assuming that the argument being passed when compiling and running the program through
		 * the command line is "Felix" , we print to console number of chars were expecting and then
		 * print the argument that is being passed. the argument can be accessed through args[0]
		 */
		System.out.println("The number of chars in the string to be input through command line is:" + 5);
		System.out.println("String that was input is " + args[0]);
		
	}

}
