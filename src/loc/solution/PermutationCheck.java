package loc.solution;

import java.util.HashSet;
import java.util.Set;

public class PermutationCheck {

	public static void main(String[] args) {
		/* *
		 * A non-empty array A consisting of N integers is given.
		 * A permutation is a sequence containing each element 
		 * from 1 to N once, and only once.
		 * The goal is to check whether array A is a permutation.
		 * */
		
		int[] arr = { 3, 2 , 1, 4, 6};
		
		int retVal = isArrayAPermutation(arr);
		
		String permVal ="a permutation";
		
		if(retVal == 0) {
			permVal = "not " + permVal; 
		}
		
		System.out.println("The array is "+ permVal);

	}

	private static int isArrayAPermutation(int[] arr) {
		int retValue = 1;
		
		Set<Integer> elementSet = new HashSet<Integer>();
		
		for(int i : arr) {
			elementSet.add(i);
		}
		
		for (int i=1; i < arr.length+1; i++) {
			if(!elementSet.contains(i)) {
				retValue = 0;
			}
		}
		
		
		return retValue;
	}

}
