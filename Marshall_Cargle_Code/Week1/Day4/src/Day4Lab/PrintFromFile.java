package Day4Lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrintFromFile {

	static String filename = "src/logs/Data.txt";

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] about = line.split(":");
				System.out.println("Name: " + about[0] + " " + about[1]);
				System.out.println("Age: " + about[2] + " years");
				System.out.println("State: " + about[3] + " State");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
