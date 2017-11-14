package Day2;

public class MergeSort 
{
	int righti;
	int lefti;
	int[] array;
	int[] mergeSort(int righti,int lefti,int...array)
	{
		int temp;
	     for(int i=righti; i < lefti; i++){  
	         for(int j=righti+1; j < lefti; j++){  
	                  if(array[j-1] > array[j]){  
	                         //swap elements  
	                         temp = array[j-1];  
	                         array[j-1] = array[j];  
	                         array[j] = temp;  
	                 }                  
	         }  
	     }
	     return array;
	}
	void combine(int[] arr1,int[] arr2)
	{
		
		int l = arr1.length+arr2.length;
		int [] sol=new int[l];
		for(int i =0;i<l;i++)
		{
			for(int j = 0;j <arr1.length;j++)
			{
				sol[i]=arr1[j];
			}
			for(int j = 0;j <arr2.length;j++)
			{
				sol[i]=arr2[j];
			}
			}
			int temp;
		     for(int i=0; i < l; i++){  
		         for(int j=1; j < l-i; j++){  
		                  if(sol[j-1] > sol[j]){  
		                         //swap elements  
		                         temp = sol[j-1];  
		                         sol[j-1] = sol[j];  
		                         sol[j] = temp;  
		                 }                  
		         }  
		     }
		for(int i = 0;i<sol.length;i++)
		{
			System.out.print(sol[0]);
		}
		
	}
}
