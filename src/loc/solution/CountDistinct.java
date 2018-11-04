package loc.solution;

import java.util.HashSet;
import java.util.Set;

import loc.sortAlgos.InsertionSort;
import loc.sortAlgos.MergeSort;

public class CountDistinct {

	public static void main(String[] args) {
		/*
		 * given an array A consisting of N integers, returns the number of distinct
		 * values in array A.
		 */
		
		int[] A = { 2, 1, 1, 2, 3, 1};
		
		System.out.println("Distinct count is: "+ getDistinctCount(A));

	}

	private static int getDistinctCount(int[] A) {
		int distinctCount = 1;
		
		// Approach 1: Sort and then count
		sortArray(A);
		
		for (int i = 1; i < A.length; i++) {
			if(A[i] != A[i-1]) {
				distinctCount++;
			}
		}
		
		System.out.println("Approach 1 solution: "+ distinctCount);
		
		// Approach 2: Add array elements to Set and get count
		Set<Integer> elementSet = new HashSet<Integer>();
		
		for (int elem : A) {
			elementSet.add(elem);
		}
		
		distinctCount = elementSet.size();
		
		return distinctCount;
	}

	private static void sortArray(int[] A) {
		
		
		if (A.length < 7) {
			// Insertion sort for length less than 7
			InsertionSort.insertionSort(A);;
			
		}else {
			// Merge Sort
			MergeSort.mergeSort(A);
		}	
		
		
	}

}
