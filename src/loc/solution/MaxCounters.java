package loc.solution;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class MaxCounters {

	public static void main(String[] args) {
		/**
		 * You are given N counters, initially set to 0, and you have two possible operations on them:

			increase(X) − counter X is increased by 1,
			max counter − all counters are set to the maximum value of any counter.
			A non-empty array A of M integers is given. This array represents consecutive operations:

			if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
			if A[K] = N + 1 then operation K is max counter.
			For example, given integer N = 5 and array A such that:

			    A[0] = 3
			    A[1] = 4
			    A[2] = 4
			    A[3] = 6
			    A[4] = 1
			    A[5] = 4
			    A[6] = 4
			the values of the counters after each consecutive operation will be:

			    (0, 0, 1, 0, 0)
			    (0, 0, 1, 1, 0)
			    (0, 0, 1, 2, 0)
			    (2, 2, 2, 2, 2)
			    (3, 2, 2, 2, 2)
			    (3, 2, 2, 3, 2)
			    (3, 2, 2, 4, 2)
			The goal is to calculate the value of every counter after all operations.
		 **/
		
		int N = 5;
		int[] inpArr = {3,4,4,6,1,4,4};
		
		int[] outArr = calculateCounterValues(inpArr, N);
		
		System.out.println();
		IntStream.of(outArr).forEach(i -> System.out.print("-"+i));

	}

	private static int[] calculateCounterValues(int[] inpArr, int N) {
		
		int[] outArr = new int[N];
		int maxCounterValue = 0;
		
		// Approach 1: Assign each counter value directly
		for(int i : inpArr) {
			if(i == N+1) {
				//assign max value to all counters
				assignMaxCounterValue(outArr, maxCounterValue);
			}else {
				outArr[i-1]++;
				if(outArr[i-1] > maxCounterValue) {
					maxCounterValue = outArr[i-1];
				}
			}
			//IntStream.of(outArr).forEach(j -> System.out.print("-"+j));
			//System.out.println("");
		}
		
		IntStream.of(outArr).forEach(i -> System.out.print("-"+i));		
		
		
		//Approach 2: Keep a variable to store increment value
		
		int[] outArr1 = new int[N];
		maxCounterValue = 0;
		int incrementVal = 0;
		for(int i : inpArr) {
			if(i == N+1) {
				//assign max value to all counters
				incrementVal = maxCounterValue;
			}else {
				if(incrementVal > outArr1[i-1]) {
					outArr1[i-1] = incrementVal+1;
				} else {
					outArr1[i-1]++;
				}
				if(outArr1[i-1] > maxCounterValue) {
					maxCounterValue = outArr1[i-1];
				}
			}
			//IntStream.of(outArr).forEach(j -> System.out.print("-"+j));
			//System.out.println("");
		}
		
		for(int i=0; i < N ; i++) {
			if(incrementVal > outArr1[i]) {
				outArr1[i] = incrementVal;
			}
			//IntStream.of(outArr).forEach(j -> System.out.print("-"+j));
			//System.out.println("");
		}
		

		return outArr1;
	}

	private static void assignMaxCounterValue(int[] outArr, int maxCounterValue) {
		
	   //return Arrays.stream(outArr).map(i -> i =maxCounterValue).toArray();
       for(int i=0; i<outArr.length; i++) {
    	   outArr[i] = maxCounterValue;
       }
		
	}

}
