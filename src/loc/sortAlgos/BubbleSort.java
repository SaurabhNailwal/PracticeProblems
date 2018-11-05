package loc.sortAlgos;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] inpArray = {7,3,4,8,2,6,9,1,5};

		System.out.print(" Bubble sort - Input array: ");		
		Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));		
		
		
        bubbleSort(inpArray);
        
        System.out.print("\n Bubble sort - Sorted array: ");        
        Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));

	}

	private static void bubbleSort(int[] inpArray) {
		
		boolean swapped = true;
		int lastUnsortedIndex = inpArray.length;
		
		while(swapped) {
			
			swapped = false;
			lastUnsortedIndex--;
			
			for(int i=0; i < lastUnsortedIndex; i++) {
				if(inpArray[i] > inpArray[i+1]) {
					// swap
					inpArray[i] += inpArray[i+1];
					inpArray[i+1] = inpArray[i] - inpArray[i+1];
					inpArray[i] = inpArray[i] - inpArray[i+1]; 
					
					swapped = true;
				}
			}
			
		}
		
		
	}

}
