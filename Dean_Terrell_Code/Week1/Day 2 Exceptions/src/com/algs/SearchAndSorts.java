package com.algs;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.*;

public class SearchAndSorts {

	public static void main(String[] args) {

		int[] num = {5, 7, 3, 2, 8, 13, 12, 1, 0, 50, 32};
		int[] num2 = {3, 6, 1, 8, 5, 0, 4};
		
		if(BinarySearch(num, 13))
			System.out.println("13 was found!");
		else
			System.out.println("13 was not found.");
		
		System.out.printf("Original num: ");
		for(int i : num)
			System.out.printf(" %d", i);
		
		bubbleSort(num);
		
		System.out.printf("\nBubblesort num: ");
		for(int i : num)
			System.out.printf(" %d", i);
		
		System.out.printf("\nOriginal num2: ");
		for(int i : num2)
			System.out.printf(" %d", i);
		
		mergeSort(num2);
		
		System.out.printf("\nMergesort num2: ");
		for(int i : num2)
			System.out.printf(" %d", i);
	}

	static boolean BinarySearch(int[] data, int key) {
		int low = 0;
		int high = data.length - 1;
		
		while(high >= low) {
			int middle = (low + high) / 2;
			if(data[middle] == key) {
				return true;
			}
			if(data[middle] < key) {
				low = middle + 1;
			}
			if(data[middle] > key) {
				high = middle - 1;
			}
		}
		return false;
	}
	
    static int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }
    

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(array, left, right);
        }
    }
    
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    
    // Merges the given left and right arrays into the given 
    // result array.  Second, working version.
    // pre : result is empty; left/right are sorted
    // post: result contains result of merging sorted lists;
    public static void merge(int[] result, 
                             int[] left, int[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // take from left
                i1++;
            } else {
                result[i] = right[i2];   // take from right
                i2++;
            }
        }
    }
 
    public static int[] doInsertionSort(int[] input){
        
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    
	public class Node {

	    private Node left;
	    private Node right;
	    private String label;

	    public Node(String label, Node left, Node right) {
	        this.left = left;
	        this.right = right;
	        this.label = label;
	    }

	    @Override
	    public String toString() {
	        return label;
	    }

	    public List<Node> getChildren() {
	        return Stream.of(left, right)
	               // .filter(Objects::nonNull)
	                .collect(Collectors.toList());
	    }
	    
	    public List<Node> searchByDepth() {
	        List<Node> visitedNodes = new LinkedList<>();
	        List<Node> unvisitedNodes = new LinkedList<>();
	        unvisitedNodes.add(this);

	        while(!unvisitedNodes.isEmpty()) {
	            Node currNode = unvisitedNodes.remove(0);

	            List<Node> newNodes = currNode.getChildren()
	                    .stream()
	                    .filter(node -> !visitedNodes.contains(node))
	                    .collect(Collectors.toList());

	            unvisitedNodes.addAll(0, newNodes);
	            visitedNodes.add(currNode);
	        }

	        return visitedNodes;
	    }
	    
	    public List<Node> searchByBreadth() {
	        List<Node> visitedNodes = new LinkedList<>();
	        List<Node> unvisitedNodes = Arrays.asList(this);

	        while(!unvisitedNodes.isEmpty()) {
	            List<Node> newNodes = unvisitedNodes
	                    .stream()
	                    .map(Node::getChildren)
	                    .flatMap(List::stream)
	                    .filter(node -> !visitedNodes.contains(node))
	                    .collect(Collectors.toList());

	            visitedNodes.addAll(unvisitedNodes);
	            unvisitedNodes = newNodes;
	        }

	        return visitedNodes;
	    }

	}

	}