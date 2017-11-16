package Day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class lab111617 {
	/*
	 * interger is even without % 
	 * use junittestcase to test 
	 * 
	 * creates an arraylist which stores numbers from 1-100
	 * prints all primes 
	 * 
	 * find minimum- of two using ternary : ?
	 * 
	 * write a program demonstrating switch case 
	 */
	boolean iseven(int in){
		int hold= in/2;
		if(hold*2==in)
		return true;
		return false;
	}
	static boolean isprime(int in)
	{
		for (double i=in-1.00; i>= 2; i--){
			if (in%i==0)
				return false;
		}
		return true;
	}
	
	static void primec(){
		ArrayList<Integer> list1=new ArrayList<Integer>(101);
		
		for(int i = 1; i <101; i++)
			list1.add(i);
		System.out.println("1 is prime");
		for(int i = 1 ; i <100; i++)
		{
			
			if(isprime(list1.get(i)))
				System.out.println(list1.get(i) + "is prime");
			
		}	
		
	
		
	}
	
	static void switchin(int in){

        switch (in) {
            case 1:  System.out.println(Math.sqrt(25));
                     break;
            case 2: DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            		LocalDate localDate = LocalDate.now();
            		System.out.println(dtf.format(localDate));
                     break;
            case 3:  String initial="I  am learning Core Java";
            		 String[] words= new String[initial.length()];
            			 words=initial.split(" ");
            			 System.out.println(words[0]+words[1]+words[5]);
                     break;     
                     }
        System.out.println("done switching");
	}
	
	static void readwrite()
	{
		String line=null;
		try{
			FileReader  fr= new FileReader("src/text/Data.txt");
			BufferedReader br= new BufferedReader (fr);
            while((line = br.readLine()) != null) {
            	int typecount=0;
            	for(int i = 0; i < line.length();i++)
                {
                	
                	if(line.charAt(i)==':' && typecount==0){
                		System.out.print("Name: ");
                		typecount++;
                		continue;
                	}
                	if (line.charAt(i)==':' && typecount==1){
                		System.out.print(" ");
                		typecount++;
                		continue;
                	}
                	if (line.charAt(i)==':' && typecount==2){
                		System.out.print("\n Age: ");
                		typecount++;
                		continue;
                	}
                	if(line.charAt(i)==':' && typecount==3){
                		System.out.print("\n State: ");
                		typecount++;
                		continue;
                	}
                	if(line.charAt(i)!=':')
                	System.out.print(line.charAt(i));
                	else
                	System.out.print(" ");
                }
            	System.out.print(" State \n");
                	
            }   
            br.close();
		}catch(FileNotFoundException  ex)
		{
			ex.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		primec();
		int a = 3, b=6;
		System.out.println(" a = 3 b = 6");
		System.out.println((a > b) ? "a is larger" : "b is larger");
		switchin(1);
		switchin(2);
		switchin(3);
		readwrite();
	}
	
}
