package loc.solution;

import java.util.Stack;

/**
 * Codility Fish problem.
 * 
 * @author sn
 *
 */

public class Fish {

	public static void main(String[] args) {

		int[] A = { 4, 3, 2, 1, 5 };
		int[] B = { 0, 1, 0, 0, 0 };
		
		int fishCount = findAliveFishCount(A, B);
		
		System.out.println("Number of alive fishes: " + fishCount);

	}

	private static int findAliveFishCount(int[] A, int[] B) {
		
		
		if(A == null || A.length == 0) {
			return 0;
		}
		
		// Approach : Store downstream fish size in stack and pop when upstream 
		// fish comes and check size
		
		Stack<Integer> downstreamFishSize = new Stack<Integer>();
		int passedUpstream = 0;
		
		for(int i =0;i < A.length; i++) {
			
			// put in stack if downstream
			if(B[i] == 1) {
				downstreamFishSize.push(A[i]);
			} else {
				
				// Increment passedUpstream counter if stack is empty
				// else check if pop downstream and check for sizes
				if(downstreamFishSize.empty()) {
					passedUpstream++;
				}else {
					
					while(!downstreamFishSize.empty() && A[i] > downstreamFishSize.peek()) {
						downstreamFishSize.pop();
					}
					
					if(downstreamFishSize.empty()) {
						passedUpstream++;
					}
					
				}
				
				
			}
			
			
			
			
		}
		
		
		return downstreamFishSize.size() + passedUpstream;
		
	}

}
