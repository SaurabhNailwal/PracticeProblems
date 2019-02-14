package loc.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution for AbsDistinct problem
 * 
 * @author SN
 *
 */
public class AbsDistinct {

	public static void main(String[] args) {

		//int[] A = { -5, -3, -1, 0, 3, 6 };
		int[] A = { -2, -2 };   		
		int absCount = getAbsoluteDistinct1(A);
		
		System.out.println("1 Absolute distinct count is: "+ absCount);
		
		absCount = getAbsoluteDistinct2(A);
		
		System.out.println("2 Absolute distinct count is: "+ absCount);

	}

	/**
	 * Approach 2 - using no additional data structure
	 * 
	 * @param a
	 * @return
	 */
	private static int getAbsoluteDistinct2(int[] A) {
		
		if (A == null || A.length == 0) {
			return 0;
		}

		if (A.length == 1) {
			return 1;
		}
		
		// Store absolute values
		
		for(int i=0; i< A.length; i++) {			
			A[i] = Math.abs(A[i]);			
		}
		
		// sort and check next
		Arrays.sort(A);
		
		int curElement = A[0]; 
		int distinctCount = 1;
		int newElem = -1;
		
		for(int i=1; i< A.length; i++) {
			
			newElem = Math.abs(A[i]);
			
			if(curElement != newElem) {
				curElement = newElem;
				distinctCount++;
			}
			
		}
		
		
		return distinctCount;
	}

	/**
	 * Approach 1 - using additional data structure
	 * 
	 * @param A
	 * @return
	 */
	private static int getAbsoluteDistinct1(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		if (A.length == 1) {
			return 1;
		}
		
		// Store in Set and return size
		Set<Integer> elementSet = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			elementSet.add(Math.abs(A[i]));
		}

		return elementSet.size();

	}

}
