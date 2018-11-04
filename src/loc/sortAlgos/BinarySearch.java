package loc.sortAlgos;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int[] inpArray = { 7, 3, 4, 8, 2, 6, 9, 1, 5 };

		System.out.print(" Input array: ");
		Arrays.stream(inpArray).forEach(i -> System.out.print(" " + i));

		// sorting before binary search
		MergeSort.mergeSort(inpArray);

		System.out.print("\n Sorted array: ");
		Arrays.stream(inpArray).forEach(i -> System.out.print(" " + i));
		
		int searchElem = 5;

		int index = binarySearchRecursive(inpArray, 0, inpArray.length - 1, searchElem);

		if (index >= 0) {
			System.out.print("\n Recursive - Element found at: " + index);
		} else {
			System.out.print("\n Recursive - Element not found");
		}
		
		index = binarySearchIterative(inpArray, searchElem);

		if (index >= 0) {
			System.out.print("\n Iterative - Element found at: " + index);
		} else {
			System.out.print("\n Iterative - Element not found");
		}

	}

	public static int binarySearchRecursive(int[] inpArray, int start, int end, int elem) {

		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		// end condition
		if (inpArray[mid] == elem) {
			return mid;
		}

		if (elem > mid) {
			binarySearchRecursive(inpArray, mid + 1, end, elem);
		} else {
			binarySearchRecursive(inpArray, start, mid, elem);
		}

		return -1;
	}

	public static int binarySearchIterative(int[] inpArray, int elem) {
		
		int start = 0;
		int end = inpArray.length - 1;

		int mid = 0;
		
		while(start < end) {
			
			mid = (start + end) / 2;
			
			if(inpArray[mid]==elem) {
				return mid;
			}
			
			if(elem < mid) {
				end = mid;
			}else {
				start = mid+1;
			}
		}

		return -1;
	}

}
