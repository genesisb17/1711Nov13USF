package question8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class palindomes {
	
	static boolean reversi(String reverse){
	String normal=reverse;
	for(int i=reverse.length(); i>0;i--)
	{
		reverse+=reverse.charAt(i-1);// continues to append the first letter to the last 
	}
	reverse=reverse.substring(reverse.length()/2);
	if(reverse.equals(normal))
	return true;
	else
		return false;
	}
	public static void main(String[] args) {
		ArrayList<String> initial= new ArrayList<String>();
		ArrayList<String> palin= new ArrayList<String>();
		initial.add("karan");
		initial.add("madam");
		initial.add("tom");
		initial.add("civic");
		initial.add("radar");
		initial.add("sexes");
		initial.add("jimmy");
		initial.add("kayak");
		initial.add("john");
		initial.add("refer");
		initial.add("billy");
		initial.add("did");
		for(int i = 0 ; i < initial.size(); i++)
		{
		if( (reversi(initial.get(i)) ) )
			{
			palin.add(initial.get(i));
			}
		}
	}
	
}

