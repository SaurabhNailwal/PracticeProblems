package loc.solution;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * Solution for Max Counters problem
 * 
 * @author SN
 *
 */

public class MaxCounters {

	public static void main(String[] args) {
			
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
