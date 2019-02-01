package loc.solution;

import java.util.stream.IntStream;

/**
 * Solution for Tape Equilibrium problem
 * 
 * @author SN
 *
 */

public class TapeEquilibrium {

	public static void main(String[] args) {
		
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
