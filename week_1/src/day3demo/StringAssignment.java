package day3demo;

public class StringAssignment {
	
	public static void main(String[] args) {
		stringBuilderManipulation();
	}
	
	static void stringBuilderManipulation() {
		System.out.println("Creating a new StringBuilder object, 'sb', with the value 'Revature'...");
		StringBuilder sb = new StringBuilder("Revature");
		
		System.out.println("Result: " + sb);
		
		System.out.println("\nAppending ' Training' to the StringBuilder object, 'sb'...");
		sb.append(" Training");
		System.out.println("" + sb);
		
		System.out.println("\nDeleting index positions 0 through 9 of the StringBuilder object, 'sb'...");
		sb.delete(0, 9);
		System.out.println("Result: " + sb);
		
		System.out.println("\nCreating a new StringBuilder object, 'sb2', with the value ' test'...");
		StringBuilder sb2 = new StringBuilder(" test");
		
		System.out.println("Appending ' Training' to the StringBuilder object, 'sb'...");
		sb.append(sb2);
		System.out.println("Result: " + sb);
	}
	
	static void stringTokenizerPractice() {
		
	}
	
	
}
