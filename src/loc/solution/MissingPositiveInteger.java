package loc.solution;

import java.util.HashSet;
import java.util.Set;

public class MissingPositiveInteger {

	public static void main(String[] args) {
		/* *
		 * Given an array A of N integers, return the smallest 
		 * positive integer (greater than 0) that does not occur
		 *  in A.
		 * */
		//int[] arr = {1, 3, 6, 4, 1, 2};
		int[] arr = {1, 2, 6, 4, 5, 3};
		System.out.println("The smallest positive integer is "
				+findSmallestPositiveInteger(arr));
        
	}

	private static int findSmallestPositiveInteger(int[] arr) {

		int retVal = arr.length+1;
		Set<Integer> elementSet = new HashSet<Integer>();
		
		for(int i: arr) {
			elementSet.add(i);
		}
		
		for(int i=1; i <= arr.length; i++) {
			if(!elementSet.contains(i)) {
				retVal = i;
				break;
			}
		}
		
		return retVal;
	}

}
