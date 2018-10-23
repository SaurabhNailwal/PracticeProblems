package loc.solution;

public class MinAvgSlice {

	public static void main(String[] args) {
		/*
		 * A non-empty array A consisting of N integers is given. A pair of integers (P,
		 * Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the
		 * slice contains at least two elements). The average of a slice (P, Q) is the
		 * sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be
		 * precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
		 * 
		 * For example, array A such that:
		 * 
		 * A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the
		 * following example slices:
		 * 
		 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average
		 * is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
		 * The goal is to find the starting position of a slice whose average is
		 * minimal.
		 */
		
		int[] arr = { 4, 2, 2, 5, 1, 5, 8};
		
		System.out.println("Minimum average slice starting position is: "+ findMinAvgSlice(arr));

	}

	private static int findMinAvgSlice(int[] arr) {
		
		double minAvg = Double.MAX_VALUE;
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		float sum = 0;
		int divisor = 1;
		double currAvg = 0;
		int minIndex = -1;
		
		// Approach 1
		for (int i = 0; i < arr.length-1; i++) {
			
			sum = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				
				sum += arr[j];
				divisor = (j - i)+1;
				currAvg = sum / divisor;
				//System.out.println("i: "+ i+" j: "+j+ " currAvg: "+ currAvg +" sum: "+sum +" divisor: "+divisor);
				
				if(currAvg < minAvg) {
					
					minAvg = currAvg;
					minIndex = i;
					//System.out.println("i: "+ i+" j: "+ j+ " minAvg: "+ minAvg);
				}
				
			}
			
		}
		
		// Approach 2: finding only first 2 and 3 slices
		// Proof : https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility
		
		minAvg = Double.MAX_VALUE;
		sum = 0;
		divisor = 1;
		currAvg = 0;
		minIndex = -1;
		
		for (int i = 0; i < arr.length-1; i++) {
			
			sum = arr[i];			
			
			// 2 element slice
			sum += arr[i+1]; 
			currAvg = sum/2.0;
			if(currAvg < minAvg){
				minAvg = currAvg;
				minIndex = i;				
			}
			
			if(i < arr.length-2) {
				// 3 element slice
				sum += arr[i+2];
				currAvg = sum/3.0;
				if(currAvg < minAvg){
					minAvg = currAvg;
					minIndex = i;				
				}		
			}			
			
		}
		
		
		return minIndex;
	}

}
