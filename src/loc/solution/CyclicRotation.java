package loc.solution;

import java.util.stream.IntStream;

public class CyclicRotation {

	public static void main(String[] args) {
		
		/*An array A consisting of N integers is given. Rotation of the array means
		 *that each element is shifted right by one index, and the last element of 
		 *the array is moved to the first place. For example, the rotation of array
		 * A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one
		 *  index and 6 is moved to the first place).The goal is to rotate array A
		 *   K times; that is, each element of A will be shifted to the right K times.*/
		
		int[] arr = {3, 8, 9, 7, 6};
		
		cyclicRotate(arr, 3);

	}

	private static void cyclicRotate(int[] arr, int k) {
		
		if(arr.length <= 1 ) {
			return;
		}
		
		//if number of rotations is equal to number of elements
		// or a multiple then we get the original array back
		if(k % arr.length == 0) {
			return;
		}		
		
		// reducing the rotation by the array length
		k = k % arr.length;
		
		//Approach 1: Rotate the elements to the right k times
		/*
		   int nextElement = -1;
		   int currentElement = -1;
		   
		   for(int i=0; i<k; i++) {
			
			currentElement = arr[0];
			
			for(int j=0; j < arr.length -1; j++) {
				
				nextElement = arr[j+1];			
				arr[j+1] = currentElement;								
				currentElement = nextElement;
				
			}
			
			//moving last element to first place
			arr[0] = currentElement;
			
			System.out.print(">> ");
			IntStream.of(arr).forEach(b -> System.out.print(b+" "));
			System.out.println();
			
		}*/
		
		//Approach 2: Assign the elements to a new array shifting by k
		
		int[] newArr = new int[arr.length];		
		
		
		for(int m=0; m< arr.length; m++) {
			
			newArr[(m + k) % arr.length] = arr[m];
			
			System.out.print("## ");
			IntStream.of(newArr).forEach(b -> System.out.print(b+" "));
			System.out.println();
			
		}
		
	}

}
