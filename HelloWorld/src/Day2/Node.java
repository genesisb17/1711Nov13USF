package Day2;

public class Node {
int left;
int right;
int key;
int[] arr;
boolean b;
public void search(int[]arr,int left,int right,int key)
{
	for(int i = right;i<left;i++)
	{
		if (arr[i]==key)
		{
			System.out.println("found");
		}
	}
}

}
