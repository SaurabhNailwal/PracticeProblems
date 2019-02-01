package loc.solution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Solution for Missing Element problem
 * 
 * @author SN
 *
 */

public class MissingElement {

	public static void main(String[] args) {

		/*  Find the missing element in teh array from range 1 to N+1*/
		
		int[] A = {2,3,1,5};
		
		System.out.println("Missing Element: "+ findMissingElement(A));

	}

	private static int findMissingElement(int[] a) {
		
		int missingElem = a.length;
		Set<Integer> elements = new HashSet<Integer>();
		
		
		for (int i : a) {			
			elements.add(i);			
		}
		
		for(int i=1; i < a.length+1; i++) {			
			if(!elements.contains(i)) {
				//System.out.println(i);
				return i;
			}
		}
		
		return missingElem;
	}
	

}
