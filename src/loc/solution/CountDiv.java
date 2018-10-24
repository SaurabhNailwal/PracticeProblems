package loc.solution;

public class CountDiv {

	public static void main(String[] args) {
		/*
		 * given three integers A, B and K, returns the number of integers within the
		 * range [A..B] that are divisible by K
		 */

		int A = 6, B = 11, K = 2;

		System.out.println("Number of divisible numbers by " + K + 
				" is " + countDivNums(A, B, K));

	}

	private static int countDivNums(int A, int B, int K) {
		int returnVal = 0;
		
		// Approach 1		
		for (int i = A; i <= B; i++) {
			
			if(i % K == 0) {
				returnVal++;
			}
		}
		System.out.println("Approach 1: "+ returnVal);
		
		// Approach 2
		returnVal = ((B/K) - (A/K) + (A%K == 0? 1 : 0));
		
		return returnVal;
	}

}
