package day5.java;

public class LabQs {
	//bubble sort
	public void Q1(int[] arr) {
		
		int r = arr.length;
		int temp = 0;		
		int count = 0;
        for(int i=0; i < r; i++){
            for(int j=1; j < (r-i) ; j++){  
                     if(arr[j-1] > arr[j]){  
                            //swap elements  
                            temp = arr[j-1];  
                            arr[j-1] = arr[j];  
                            arr[j] = temp;
                            count++;
                    }  
            }  
        }
        
        for(int z = 0; z < r; z++) {
        	System.out.print(arr[z] + " ");
        }
        
	}
	//fibonacci
	public int Q2(int a) {
		
		if(a == 0 || a == 1) {
			
			return a;
		}
		
		int n1 = 0;
		int n2 = 1;

		for(int i = 2; i < a; i++) {

			int temp = n1 + n2;
			System.out.println(n1 + " + " + n2 + " = " + temp);
			n1 = n2;
			n2 = temp;
		}
		return n2;
	}
	
	public static void Q3(String y) {

		int len = y.length()-1;
		char[] z = y.toCharArray();
		int count = 0;
		for(int i = len; i > -1; i--) {
			System.out.println("this is i " + i);
			z[count] = y.charAt(i);
			count++;
		}
		
		String result = new String(z);
		System.out.println(result);
	}
	
	public static void Q4(int t) {
		
		
	}
	
	public static void main(String[] args) {
		
		int[] x = new int[] {0, 1, 5, 6, 3, 2, 3, 7, 9, 8 ,4};
		LabQs qs = new LabQs();
		qs.Q1(x);
		System.out.println();
		qs.Q2(25);
		System.out.println();
		qs.Q3("Labradoodle");
	}
	
	
}
