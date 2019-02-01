package loc.solution;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Solution for Max Product Of Three problem
 * 
 * @author SN
 *
 */

public class MaxProductOfThree {

	public static void main(String[] args) {
		
		int[] arr = {10, 10, 10};
		
		System.out.println("\nMax product is: "+ getMaxProductOfThree(arr));

	}

	private static int getMaxProductOfThree(int[] arr) {
	
		int returnVal = 0;
		
		//need to get product of largest three,
		//so sort an take product of first three
		
		//sorting using selection sort in ascending order
		int max =0, maxIndex = 0;
		for(int i=0; i < arr.length - 1; i++) {
			max = arr[i];
			maxIndex = i;
			for(int j=i+1; j < arr.length; j++) {
				if(arr[j] > max) {
					maxIndex = j;
				}
				
			}
			
			if(maxIndex != i) {
				//swap
				arr[i] = arr[i] + arr[maxIndex];
				arr[maxIndex] = arr[i] - arr[maxIndex];
				arr[i] = arr[i] - arr[maxIndex];				
			}
			
			
		}
		
		Arrays.stream(arr).forEach(i -> System.out.print(" "+i));
		
		int res1=0, res2=0;
		
		if (arr.length > 2) {
			
			res1 = arr[0] * arr[1] * arr[2];
			res2 = arr[0] * arr[arr.length-1] * arr[arr.length-2];
			
			System.out.println("res1: "+res1 + "res2: "+res2);
			
			if(res1 > res2) {
				returnVal = res1;
			} else{
				returnVal = res2;
			}
			
		}		
		
		return returnVal;
	}

}
