package q20;

import java.io.BufferedReader;
import java.io.FileReader;

public class FilePrinter {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("src/q20/Data.txt"))){
			br.lines().forEach(l -> {
				String[] data = l.split(":");
				System.out.println("Name: " + data[0] + " " + data[1]);
				System.out.println("Age: " + data[2] + " years");
				System.out.println("State: " + data[3] + " State");
				System.out.println();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
