package loc.solution;

public class PassingCarCount {

	public static void main(String[] args) {
		/* *
		 * A non-empty array A consisting of N integers is given.
		 * The consecutive elements of array A represent consecutive
		 *  cars on a road.
		 *  Array A contains only 0s and/or 1s:
		 *  0 represents a car traveling east,
		 *  1 represents a car traveling west.
		 * The goal is to count passing cars. We say that a pair of cars
		 * (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to
		 * the east and Q is traveling to the west.
         *
		 * For example, consider array A such that:
		 * A[0] = 0
		 * A[1] = 1
		 * A[2] = 0
		 * A[3] = 1
		 * A[4] = 1
		 * We have five pairs of passing cars: 
		 * (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
		 * The function should return −1 if the number of pairs of passing
		 *  cars exceeds 1,000,000,000.
         * */
		
		int[] arr = {0,1,0,1,1};
		
		System.out.println("Passing Count cars is "+
				calculatePassingCarCount(arr));
	}

	private static int calculatePassingCarCount(int[] arr) {
		int count = 0;
		
		// Approach 1: Forming pairs and counting
		for(int i=0; i< arr.length; i++) {
			if(arr[i] == 0) {
				for(int j=i+1; j< arr.length; j++) {
					if(arr[j] == 1) {
						count++;
					}
				}
			}
		}
		
		// Approach 2: Using number of zeros as a multiplier
		int incrementer = 0;
		count = 0;
		
		for (int i : arr) {
			
			if(i == 0) {
				incrementer++;
			}
			
			if(i == 1) {
				count += incrementer; 
			}
			
		}
		
		if(count > 1000000000) {
			count = -1;
		}
		
		return count;
	}

}
