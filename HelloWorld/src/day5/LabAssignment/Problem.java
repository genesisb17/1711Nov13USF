package day5.LabAssignment;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import day4.People;

public class Problem 
{

	int[] b = {1,0,5,6,3,2,3,7,9,8,4};
	void Problem1(int[] b)
	{
		int temp;
	for(int i=0;i<b.length;i++)
	{
		for(int j=1; j < b.length;j++)
		{
		     if(b[j-1] > b[j]){  
                 //swap elements  
                 temp = b[j-1];  
                 b[j-1] = b[j];  
                 b[j] = temp;  
         }    
		}
	}
	System.out.println("Promblem 1");
	for(int i=0;i<b.length;i++)
	{
		System.out.print(b[i]);
	}
	System.out.println("\n");
	}
	
	void Problem2() 
	{
		System.out.println("Problem 2");
		System.out.print(0+" ");
		System.out.print(1+" "); 
		int num1 = 0;
		int num2 =1;
			for(int i =2;i<25;i++)
			{
				System.out.print(num1+num2+" ");
				if(i%2==0)
				{
					num1 =num1+num2;
				}
				else
				{
					num2 = num1+num2;
				}
			}
			System.out.println("\n");
	}
	public void Problem3(String s)
	{
		System.out.println("Problem 3");

		for(int i = s.length()-1 ;i>=0;i--)
		{
			System.out.print(s.charAt(i));
			
		}
		System.out.println("\n");
	}
	
	int Problem4(int n)
	{
		
		if(n==1||n==0)
		{
			return 1;
		}
		else
		{
			return n*Problem4(n-1);
		}
	}
	void Problem5(String str,int idx)
	{
		int i =0;
		for(;i<idx;i++)
		{
			System.out.print(str.charAt(i));
		}
	}
	boolean Problem6(int num)
	{
		String s;
		String[] s1;
		String[] s2 = {"2","4","6","8","0"};
		s = Integer.toString(num);
		s1 = s.split("");
		System.out.println("Problem 6");
		for(int i = 0;i<s1.length;i++)
		{
			
			if(s1[s1.length-1].equals(s2[i]))
			{
				return true;
			}
		}
		return false;
	}
	void Problem8()
	{
		ArrayList<String> pali=new ArrayList<String>();
		ArrayList<String> non=new ArrayList<String>();
		String[] s= {"karan", "madam","tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length;i++)
		{
			int k=0;
			
			for(int j = s[i].length()-1 ;j>=0;j--)
			{
				sb.insert(k,s[i].charAt(j));
				k++;
			}
			System.out.println(sb);
		}
		
	}
	ArrayList<Integer> Problem9()
	{
		ArrayList j = new ArrayList();
		int p;
		for(int i = 1;i<100;i++)
		{
			j.add(i);
		}
		//test prime
		int k; 
		for(int i = 1;i<100;)
		{
			//if(!test(i))
			//{
				
				p = 0;
				for(k = 2;k<i;k++)
				{
					if(i%k==0)
					{
						p=1;
					}
				}
				i = i+2;
			//}
		}
		return j;
	}
	int Problem10(int n1,int n2)
	{
		int z = n1<n2?1:0;
		if(z==1)
		{
			return n1;
		}
		else 
		{
			return n2;
		}
	}
	void Problem13()
	{
		int count;
		count =1;
		int p=0;
		for(int i =0;i<4;i++)
		{
			for(int j =0;j<count;j++)
			{
				if(p==0)
				{
					System.out.print("0 ");
					p=1;
				}
				else
				{
					System.out.print("1 ");
					p=0;

				}
			}
			count++;
			System.out.println("\n");
		}
	}
	void Problem14(int x,int n)
	{

			switch(x)
			{
			case 1:
				System.out.println(Math.sqrt(n));
				break;
			case 2:
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Calendar calobj = Calendar.getInstance();
				System.out.println(df.format(calobj.getTime()));
				break;
			case 3:
				String s ="I am learning Core Java";
				String[]s1=s.split(" ");
				System.out.println(s1[0]);
				break;
			}
			
			
	}
	
	void Problem17()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("pricipal");
		int p =sc.nextInt();
		System.out.println("rate");
		int r = sc.nextInt();
		System.out.println("time(years)");
		int t = sc.nextInt();
		int i = p*r*t;
		System.out.println("interest");
		System.out.println(i);
	}
	People m = new People("Mickey Mouse",50,"Arizona");
	People h = new People("Hulk Hogan",50,"Virgina");
	People r = new People("Roger Rabbit",22,"Califonia");
	People w = new People("Wonder Woman",18,"Montana");
	//work on 19
	void Problem19()
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		int e = 0;
		int o = 0;
		for(int i =1;i<11;i++)
		{
			a.add(i);
		}
		System.out.println(a);
		for(int j =0;j<a.size();j++)
		{
			if(Problem6(a.get(j)))
			{
				
				e=e+a.get(j);
			}
			else 
			{
				o=o+a.get(j);			}
			}
	}
	void P20WritetoFile(People p)
	{
		String filename = "src/logs/Data.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true)))
		{
			bw.write(p.toString());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	static ArrayList<People> P20readPeople()
	{
		String filename = "src/logs/Data.txt";
		ArrayList<People> students = new ArrayList<People>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String line = null;
			while((line = br.readLine())!=null)
			{
				String[] about = line.split(":");
				People p = new People();
				p.setName(about[0]);
				p.setAge(Integer.parseInt(about[1]));
				students.add(p);
				System.out.println(about[0]+" "+about[1]+" "+about[2]);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return students;
	}
 
}
