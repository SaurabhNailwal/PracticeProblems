package loc.solution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingElement {

	public static void main(String[] args) {

		/*  An array A consisting of N different integers is given.
		 *  The array contains integers in the range [1..(N + 1)],
		 *  which means that exactly one element is missing.
		 *  Find that missing element.*/
		
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
