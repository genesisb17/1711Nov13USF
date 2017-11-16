package com.ex.probs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WarmupIO {

	static String filename = "src/data.txt";
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while((line = br.readLine()) != null) {
				String[] about = line.split(":");
				System.out.printf("Name: %s %s\nAge: %s years\nState: %s\n\n", about[0], about[1], about[2], about[3]);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
