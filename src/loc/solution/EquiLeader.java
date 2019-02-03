package loc.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Solution for EquiLeader problem
 * 
 * @author SN
 *
 */
public class EquiLeader {

	public static void main(String[] args) {

		// int[] A = {4,3,4, 4, 4,2};
		// int[] A = { -1000000000, -1000000000 };
		int[] A = { 1, 2};
		// int count = getEquiLeaderCount1(A);
		int count = getEquiLeaderCount2(A);
		System.out.println(" EquiLeader count is: " + count);

	}

	/**
	 * Approach 2
	 * 
	 * @param A
	 * @return
	 */
	private static int getEquiLeaderCount2(int[] A) {
		
		if(A == null || A.length == 0 || A.length == 1) {
			return 0;
		}

		// Find leader using Stack - still O(n)
		Stack<Integer> elementStack = new Stack<Integer>();

		for (int i = 0; i < A.length; i++) {

			if (!elementStack.empty() && elementStack.peek() != A[i]) {
				elementStack.pop();
			} else {
				elementStack.push(A[i]);
			}

		}
		
		if (elementStack.empty()) {
			return 0;
		}

		int leader = elementStack.pop();

		// Find the leader count till that index and
		//List<Integer> leaderCountList = new ArrayList<Integer>();
		int totalLeaderCount = 0;
		int equiLeaderCount = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == leader) {
				totalLeaderCount++;
			}

		}

		int currentLeaderCount = 0;

		for (int i = 0; i < A.length-1; i++) {
			
			if (A[i] == leader) {
				currentLeaderCount++;
			}
			// first half and second half leader count compare
			if(currentLeaderCount > (i+1)/2 && (totalLeaderCount - currentLeaderCount > (A.length - (i+1))/2)) {
				equiLeaderCount++;
			}			

		}

		return equiLeaderCount;
	}
	
	

	/**
	 * Approach 1
	 * 
	 * @param A
	 * @return
	 */
	private static int getEquiLeaderCount1(int A[]) {

		if (A == null || A.length == 0 || A.length == 1) {
			return 0;
		}

		// First find the leader

		int inputLength = A.length;
		// two ways:
		// 1) Using HashMap
		// 2) Using Stack and elimination
		int leader = findLeader(A, 0, inputLength);

		if (leader == -1) {
			return 0;
		}

		int firstHalfLeader = 0;
		int secondHalfLeader = 0;

		// Find the equileader
		int equiLeaderCount = 0;

		for (int i = 1; i < A.length; i++) {
			firstHalfLeader = findLeader(A, 0, i);
			secondHalfLeader = findLeader(A, i, inputLength);

			if (firstHalfLeader != -1 && secondHalfLeader != -1) {

				if (firstHalfLeader == leader && firstHalfLeader == secondHalfLeader) {
					equiLeaderCount++;
				}
			}

		}

		return equiLeaderCount;
	}

	private static int findLeader(int[] A, int start, int end) {

		if (start == end - 1) {
			return A[start];
		}

		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

		int expectedLeaderCount = (end - start) / 2 + 1;
		int count = 0;
		int leader = 0;
		int ONE = 1;
		boolean leaderFound = false;

		for (int i = start; i < end; i++) {
			if (elementCountMap.containsKey(A[i])) {

				count = elementCountMap.get(A[i]);
				if (count >= expectedLeaderCount - 1) {
					leader = A[i];
					leaderFound = true;
					break;
				} else {
					elementCountMap.put(A[i], count + ONE);
				}

			} else {
				elementCountMap.put(A[i], ONE);
			}

		}

		if (!leaderFound) {
			return -1;
		}

		return leader;
	}

}
