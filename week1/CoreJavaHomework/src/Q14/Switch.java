package Q14;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
			int choice;
			System.out.println("Input choice for switch: ");
			choice=sc.nextInt();
			
			//switch case
			switch(choice){
			case 1:
				System.out.println("Input number: ");
				int num=sc.nextInt();
				double sqrt= Math.sqrt(num);
				System.out.println("The square root is " + sqrt);
				break;
			case 2:
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
				break;
			case 3:
				String toSplit="I am learning Core Java";
				String[] words=toSplit.split(" ");
				for(int i=0;i<words.length;i++) {
					System.out.println(words[i]);
				}
				break;
				
			default:
				
			}
		sc.close();

	}
}
