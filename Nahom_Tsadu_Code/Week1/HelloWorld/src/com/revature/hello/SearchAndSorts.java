package com.revature.hello;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SearchAndSorts {
	/*
	 * 1. Binary Search (COMPLETE)
	 * 2. Breadth First Search
	 * 3. Depth First Search
	 * 4. Bubble Sort (COMPLETE)
	 * 5. Merge Sort (COMPLETE)
	 * 6. Insertion Sort
	 */
	public static void main(String[] args) {
		
		int[] numArray = {2, 16, 99, 89, 45, 22, 106, 299, 12, 34, 24, 56, 3, 10};
		//System.out.println(Collections.min(Arrays.asList(numArray)));
		
		//Start Search..
		SearchAndSortOps.start(numArray);
		
		//Bubble Sort
		SearchAndSortOps.bubbleSort(numArray);
		
		SearchAndSortOps.shuffle(numArray);
		//Merge Sort
		//System.out.println(ops.mergeSort(numArray));
		//Arrays.stream(ops.mergeSort(numArray)).forEach(n -> System.out.print(n + ", "));
		SearchAndSortOps.runMergeSort(numArray);
		//Arrays.stream(SearchAndSortOps.shuffle(numArray)).forEach(n -> System.out.print(n + ", "));
		SearchAndSortOps.shuffle(numArray);
		
		//Binary Search
		//SearchAndSortOps.binarySearch(SearchAndSortOps.getRandomElement(numArray), numArray);
		
		
	}
	
	public static class SearchAndSortOps{
		
		private static Random gen = new Random();
		
		public static void start(int[] arr){
			System.out.println("Running Searches...");
			System.out.println();
			System.out.print("Unsorted List: ");
			Arrays.stream(arr).forEach(n -> System.out.print(n + ", "));
			System.out.println();
			System.out.println();
		}
		
		public static int getRandomElement(int[] arr){
			return arr[gen.nextInt(arr.length)];
		}
		
		public static int[] shuffle(int[] arr){
			
			int temp;
			int tempIndex;
			
			System.out.println("Shuffling the list...");
			
			for(int i = 0; i < arr.length; i++){
				tempIndex = gen.nextInt(arr.length);
				temp = arr[tempIndex];
				arr[tempIndex] = arr[i];
				arr[i] = temp;
			}
			
			System.out.println("Shuffle complete!");
			System.out.print("Unsorted List: ");
			Arrays.stream(arr).forEach(n -> System.out.print(n + ", "));
			System.out.println();
			System.out.println();
			
			return arr;
		}
		
		//Runs in O(n^2)
		public static int[] bubbleSort(int[] arr){
			
			boolean sorted = true;
			int swapCount = 0;
			int passCount = 0;
			
			System.out.println("Running Bubble Sort...");
			
			while(sorted){
				
				swapCount = 0;
			
				for(int i = 0; i < arr.length; i++){
					
					if(i < arr.length - 1){
						
						if(arr[i] > arr[i + 1]){
							int temp = arr[i + 1];
							arr[i + 1] = arr[i];
							arr[i] = temp;
							swapCount++;
						}
					}
					
					if(i > 0){
						if(arr[i] < arr[i - 1]){
							int temp = arr[i - 1];
							arr[i - 1] = arr[i];
							arr[i] = temp;
							swapCount++;
						}
					}
				}
				
				if(passCount > 0 && swapCount == 0){
					
					sorted = true;
					break;
				}
				
				passCount++;
			}
			
			System.out.println("Bubble Sort Completed in " + passCount + " Passes!");
			System.out.print("Sorted List: ");
			Arrays.stream(arr).forEach(n -> System.out.print(n + ", "));
			System.out.println();
			System.out.println();
				
			return arr;
		}
		
		public static int[] runMergeSort(int[] arr){
			
			System.out.println("Running Merge Sort...");
			
			int[] sortedList = mergeSort(arr);
			
			System.out.println("Merge Sort Completed!");
			System.out.print("Sorted List: ");
			Arrays.stream(arr).forEach(n -> System.out.print(n + ", "));
			System.out.println();
			System.out.println();
			
			return sortedList;
		}
		
		public static int[] mergeSort(int[] arr){
			
			if(arr.length == 1){
				
				return arr;
				
			}else{
				
				int[] arrL = Arrays.copyOfRange(arr, 0, ((arr.length) / 2));
				mergeSort(arrL);
				
				int[] arrR = Arrays.copyOfRange(arr, ((arr.length) / 2), arr.length);
				mergeSort(arrR);
				
				//Sort Code
				int i = 0, j = 0, k = 0;
				int leftLength = arrL.length;
				int rightLength = arrR.length;
				int fullLength = arr.length;
				
				while(i < leftLength && j < rightLength){
					if( arrL[i] < arrR[j]) {
		                arr[k] = arrL[i] ;
		                i++;
		            }else{
		                arr[k] = arrR[j];
		                j++;
		            }
					
		            k++;
				}
				
				while ( i < leftLength ) {
		            arr[k] = arrL[i];
		            k++;
		            i++;
		        }
				
		        while ( j < rightLength ) {
		            arr[k] = arrR[j];
		            k++;
		            j++;
		        }
			}
			
			return arr;
		}

		public static int binarySearch(int n, int[] arr){
			
			boolean found = false;
			int midpoint = 0;
			int num = 0;
			
			System.out.println("Running Binary Search for number " + n + "...");
			
			while(!found){
				midpoint = (arr.length-1) / 2;
				
				if(n > arr[midpoint]){
					arr = Arrays.copyOfRange(arr, (midpoint + 1), (arr.length));
				}else if(n < arr[midpoint]){
					arr = Arrays.copyOfRange(arr, 0, (midpoint));
				}else if(n == arr[midpoint]){
					num = arr[midpoint];
					found = true;
				}
			}
			
			System.out.print("Integer " + n + " was found!");
			System.out.println();
			System.out.println();
			
			return num;
		}
	

	}
	
		

}
