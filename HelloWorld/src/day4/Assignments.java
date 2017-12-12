package day4;

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

public class Assignments 
{
	boolean test(int num)
	{
		String s;
		String[] s1;
		String[] s2 = {"2","4","6","8","0"};
		s = Integer.toString(num);
		s1 = s.split("");
		System.out.println(s1[s1.length-1]);
		for(int i = 0;i<s1.length;i++)
		{
			
			if(s1[s1.length-1].equals(s2[i]))
			{
				return true;
			}
		}
		
		return false;
	}
	int minm(int n1,int n2)
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
	
	ArrayList<Integer> a()
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
				if(p==0)
				{
					System.out.println(i);
				}
				i = i+2;
			//}
		}
		return j;
	}
	
	//problem 4
	void Switching(int x,int n)
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
	People m = new People("Mickey Mouse",50,"Arizona");
	People h = new People("Hulk Hogan",50,"Virgina");
	People r = new People("Roger Rabbit",22,"Califonia");
	People w = new People("Wonder Woman",18,"Montana");
	

	void WritetoFile(People p)
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
	
	static ArrayList<People> readPeople()
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