package loc.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for Permutation Check problem
 * 
 * @author SN
 *
 */

public class PermutationCheck {

	public static void main(String[] args) {
		
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
