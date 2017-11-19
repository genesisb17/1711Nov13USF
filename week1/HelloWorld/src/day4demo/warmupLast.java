package day4demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.revature.io.Student;

public class warmupLast {
	
	public static void main(String[] args) {
		String filename="src/logs/Data.txt";
		try(BufferedReader br=new BufferedReader(new FileReader(filename));){
			String line = null;
			while((line=br.readLine())!=null){
				
				StringTokenizer tok= new StringTokenizer(line,":");				
				System.out.println("Name: "+tok.nextToken()+" "+tok.nextToken());
				System.out.println("Age: "+tok.nextToken() + " years");
				System.out.println("State: " + tok.nextToken() + " State");
			}
			
		
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
