package loc.sortAlgos;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] inpArray = {7,3,4,8,2,6,9,1,5};
		
		System.out.print(" Insertion sort - Input array: ");		
		Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));
		
		System.out.print("\n Insertion sort - Sorted array: ");
		
        insertionSort(inpArray);
        
        Arrays.stream(inpArray).forEach(i -> System.out.print(" "+ i));
        
	}
	
	public static void insertionSort(int[] inpArray) {
		
		int temp = -1;
		int j = 0;
		
		for(int i=1; i < inpArray.length; i++) {
			

			temp = inpArray[i];
			
			/*for(j=i; j>0; j--) {
				
				// find insertion position and shift
				if(temp < inpArray[j-1]) {					
					//shift
					inpArray[j] = inpArray[j-1];
					
				}else {
					//insertion position found					
					break;
				}				
				
			}*/
			
			j=i;
			
			while(j>0 && inpArray[j-1]> temp) {
				// keep shifting till you find position
				inpArray[j] = inpArray[j-1];
				j--;
			}
			
			//insert
			inpArray[j] = temp;
			
			
		}
		
	}

}
