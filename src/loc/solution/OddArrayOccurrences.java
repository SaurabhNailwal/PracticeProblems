package loc.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import loc.ds.MyString;

/**
 * Solution for Odd Array Occurences problem
 * 
 * @author SN
 *
 */

public class OddArrayOccurrences {

	public static void main(MyString[] args) {

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
