package loc.solution;

import java.util.stream.IntStream;

public class TapeEquilibrium {

	public static void main(String[] args) {
		/* * 
		 * A non-empty array A consisting of N integers is given, array A represents
		 * numbers on a tape. Any integer P, such that 0 < P < N, splits this tape into
		 * two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N −
		 * 1]. The difference between the two parts is the value of: |(A[0] + A[1] + ...
		 * + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])| In other words, it is the
		 * absolute difference between the sum of the first part and the sum of the
		 * second part.
		 */

		int[] arr = { 6, 3, 4, 1, 5, 2, 3, 1 };

		System.out.println("The minimal difference point is: " 
				+ findMinimalDiffPoint(arr));

	}

	private static int findMinimalDiffPoint(int[] arr) {

		int minDiff = Integer.MAX_VALUE;
		int minP = 0;
		
		int currentSum = 0;
		int otherHalfSum = 0;
		int currentDiff = 0;

		int arrSum = IntStream.of(arr).sum();
		//System.out.println("Array Sum: "+ arrSum);
		
		for (int i = 0; i < arr.length-1; i++) {
			currentSum += arr[i];
			
			otherHalfSum = arrSum - currentSum;
			
			currentDiff = Math.abs(currentSum - otherHalfSum);
			
			//System.out.println("currentSum: "+ currentSum 
			//		+" otherSum: "+ otherHalfSum +" currentDiff: "+ currentDiff);
			
			if(currentDiff < minDiff) {
				minDiff = currentDiff;
				minP = i+1;
			}
			
		}
		
		System.out.println("Minimal Difference is: "+ minDiff);

		return minP;
	}

}
