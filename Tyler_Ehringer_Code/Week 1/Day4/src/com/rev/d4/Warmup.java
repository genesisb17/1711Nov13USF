package com.rev.d4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

public class Warmup {

	
	public boolean isEven(int n) {
		return (n & 1) == 0;
	}
	
	public void printPrimesTo100() {
		IntStream.rangeClosed(1, 100)
			.filter(i -> {
				if(i == 1) return false;
				boolean prime = true;
				for(int p = 2; p < Math.sqrt(i); p++) {
					if(i % p == 0) {
						prime = false;
						break;
					}
				}
				return prime;
			}).forEach(System.out::println);
	}
	
	public void doSwitch(int n) {
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
			break;
		default:
			break;
		}
	}
	
	public void printTextContents() {
		try(BufferedReader br = new BufferedReader(new FileReader("src/res/Data.txt"))){
			br.lines().forEach(l -> {
				String[] data = l.split(":");
				System.out.println("Name: " + data[0] + " " + data[1] + "\n");
				System.out.println("Age: " + data[2] + " years\n");
				System.out.println("State: " + data[3] + " State\n");
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int min(int a, int b) {
		return a < b ? a : b;		
	}
	
	public static void main(String[] args) {
		Warmup w = new Warmup();
		System.out.println(w.min(2, 4));
		System.out.println(w.min(6, 3));
		w.printPrimesTo100();
		w.printTextContents();
		w.doSwitch(0);
		w.doSwitch(1);
	}
}
