package loc.sortAlgos;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] inpArray = {7,3,4,8,2,6,9,1,5};

		System.out.print(" Selection sort - Input array: ");		
		Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));		
		
		
        selectionSort(inpArray);
        
        System.out.print("\n Selection sort - Sorted array: ");        
        Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));

	}

	public static void selectionSort(int[] inpArray) {
		
		//int smallestElem = -1;
		int smallestElemIndex = -1;

		for (int i = 0; i < inpArray.length; i++) {
			
			//smallestElem = inpArray[i];
			smallestElemIndex = i;
			for(int j = i+1; j < inpArray.length; j++) {
				
				//finding the smallest element
				if(inpArray[j] < inpArray[smallestElemIndex]) {
					smallestElemIndex = j;
				}				
				
			}
			
			if(smallestElemIndex != i) {
				inpArray[i] = inpArray[smallestElemIndex] + inpArray[i];
				inpArray[smallestElemIndex] = inpArray[i] - inpArray[smallestElemIndex];
				inpArray[i] = inpArray[i] - inpArray[smallestElemIndex];				
			}
			
			
		}
		
		
	}

}
