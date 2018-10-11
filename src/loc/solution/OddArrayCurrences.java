package loc.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddArrayCurrences {

	public static void main(String[] args) {

		/*
		 * A non-empty array A consisting of N integers is given. The array contains an
		 * odd number of elements, and each element of the array can be paired with
		 * another element that has the same value, except for one element that is left
		 * unpaired.
		 * 
		 * For example, in array A such that:
		 * 
		 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the elements
		 * at indexes 0 and 2 have value 9, the elements at indexes 1 and 3 have value
		 * 3, the elements at indexes 4 and 6 have value 9, the element at index 5 has
		 * value 7 and is unpaired.
		 */

		// int[] inputArray = {9,3,9,3,9,7,9};
		int[] inputArray = { 9, 3, 9, 3, 9, 7, 9, 7, 2, 8, 8 };

		System.out.println("unpaired Element: " + getUnpairedElement(inputArray));

	}

	private static int getUnpairedElement(int[] inputArray) {
		
		// Approach 1: Add in an array and remove, return the remaining element
		List<Integer> oddList = new ArrayList<Integer>();
		
		for (Integer i : inputArray) {
			if( oddList.contains(i)) {
				oddList.remove(i);
			} else{
				oddList.add(i);
			}
			
		}
		//return oddList.get(0);
		
		// Approach 2: Add in an Hashmap and remove, return the remaining element
		Map<Integer, Integer> elements = new HashMap<Integer, Integer>();

		for (Integer i : inputArray) {
			if( elements.containsKey(i)) {
				elements.remove(i);
			} else {
				elements.put(i, 1);
			}
		}
		
		int retVal = 0;
		
		for (Integer key : elements.keySet()) {
			
			retVal = key;
			break;
		}
		
		//return retVal;		
		
		// Approach 3: Store in a HashMap and search for the value 1
		Map<Integer, Integer> elems = new HashMap<Integer, Integer>();
		
		for (Integer i : inputArray) {
			
			if( elems.containsKey(i)) {
				elems.put(i,elems.get(i)+1);
			} else {
				elems.put(i, 1);
			}
			
		}
		
		
		for(Integer key: elems.keySet()) {
			
			if(elems.get(key) == 1) {
				retVal = key;
				break;
			}
		}
		
		return retVal;
		
	}

}
