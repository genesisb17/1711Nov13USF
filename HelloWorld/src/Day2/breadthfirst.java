package Day2;

public class breadthfirst {
	public static void main(String args[])
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		int key = 2;
		n1.right =0;
		n1.left = 2;
		n1.arr = arr;
		n1.search(arr,2,0,key);
		n1.b =true;
	}
}
