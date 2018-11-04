package loc.sortAlgos;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] inpArray = {7,3,4,8,2,6,9,1,5};

		System.out.print(" Merge sort - Input array: ");		
		Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));		
		
		
        mergeSort(inpArray);
        
        System.out.print("\n Merge sort - Sorted array: ");        
        Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));

	}
	
	public static void mergeSort(int[] inpArray) {
		
		int[] tempArray = new int[inpArray.length];
		
		mergeSort(inpArray,tempArray, 0, inpArray.length-1);
		
	}

	private static void mergeSort(int[] inpArray,int[] tempArray, int start, int end) {
		
		if (start >= end) {
			return;			
		}
		
		int mid = (start + end)/2;
		
		//System.out.println("val: "+ start+" "+ mid+" "+ end);
		
		mergeSort(inpArray, tempArray, start, mid);
		mergeSort(inpArray, tempArray, mid+1, end);
		
		merge(inpArray, tempArray,start, mid, end);
		
		
	}
	
	private static void merge(int[] inpArray,int[] tempArray, int start, int mid, int end) {
		
		
		int i= start , j = mid+1;
		
		for(int k=start; k <= end; k++) {
			
			if(i <= mid && (j > end || inpArray[i] < inpArray[j]) ) {
				tempArray[k] = inpArray[i];
				i++;
			}else {
				tempArray[k] = inpArray[j];
				j++;
			}
			
		}
		
		for (int k = start; k <= end; k++) {
			
			inpArray[k] = tempArray[k];
			
		}
		
		
	}

}
