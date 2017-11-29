class MergeSort
{
    public static void main(String args[])
    {
        int array[] = {0, 5, 10, 3, 1, 2, 9, 5, 6, 2};
 
        System.out.println("Given Array");
        printArray(array);
 
        MergeSort merge = new MergeSort();
        merge.sort(array, 0, array.length-1);
 
        System.out.println("\nSorted array");
        printArray(array);
    }
    
    
    void merge(int array[], int left, int mid, int right)
    {
        int n1 = mid - left + 1, n2 = right - mid;
 
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[mid + 1+ j];
 
        // Initial indexes of first and second sub arrays
        int i = 0, j = 0;
 
        // Initial index of merged sub array
        int k = left;
        while (i < n1 && j < n2)
        {
            if (leftArray[i] <= rightArray[j])
            {
                array[k] = leftArray[i];
                i++;
            }
            else
            {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of leftArray[] if any */
        while (i < n1)
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of rightArray[] if any */
        while (j < n2)
        {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts array[l..r] using
    // merge()
    void sort(int array[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int m = (left+right)/2;
 
            // Sort first and second halves
            sort(array, left, m);
            sort(array , m+1, right);
 
            // Merge the sorted halves
            merge(array, left, m, right);
        }
    }
    
    static void printArray(int array[])
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
