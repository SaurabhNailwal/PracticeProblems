package loc.solution;

import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrogRiverJump {

	public static void main(String[] args) {

		/* *
		 * A small frog wants to get to the other side of a river. The frog
		 * is initially located on one bank of the river (position 0) and 
		 * wants to get to the opposite bank (position X+1). Leaves fall 
		 * from a tree onto the surface of the river.
		 * You are given an array A consisting of N integers representing 
		 * the falling leaves. A[K] represents the position where one leaf 
		 * falls at time K, measured in seconds. 
		 * The goal is to find the earliest time when the frog can jump to 
		 * the other side of the river. The frog can cross only when leaves 
		 * appear at every position across the river from 1 to X (that is, we 
		 * want to find the earliest moment when all the positions from 1 to X 
		 * are covered by leaves). You may assume that the speed of the current 
		 * in the river is negligibly small, i.e. the leaves do not change 
		 * their positions once they fall in the river.
		 * 
		 * For example, you are given integer X = 5 and array A such that:
         *  
		 * A[0] = 1
		 * A[1] = 3
		 * A[2] = 1
		 * A[3] = 4
		 * A[4] = 2
		 * A[5] = 3
		 * A[6] = 5
		 * A[7] = 4
		 * In second 6, a leaf falls into position 5. This is the earliest 
		 * time when leaves appear in every position across the river.
		 * If the frog is never able to jump to the other side of the river,
		 * the function should return −1.
		 * */
		
		int[] arr = {1, 3, 1, 4, 2, 3, 5, 4};
		int X = 5;
		
		System.out.println("Frog will reach in "+ calculateTime(arr, X) +" seconds");
		
	}

	private static int calculateTime(int[] arr, int x) {
		
		int time = -1;
		
		//Approach 1: Storing in Set the values upto X.
		Set<Integer> positions = 
				IntStream.range(1, x+1).mapToObj(i -> i).collect(Collectors.toSet());
		
		for(int i = 0 ; i < arr.length; i++) {
			
			positions.remove(arr[i]);
			
			if(positions.isEmpty()) {
				return i;
			}
		}
		
		//Approach 2: without using set
		boolean found = false;
		
		
		for(int i = 1 ; i <= x; i++) {
			
			time = 0;
			
			for(int j : arr) {
				
				time++;				
				if(i == j) {
					found = true;					
					break;
				}				
				
			}
			
			if(!found) {
				return -1;
			}
			
			found = false;
		}
		
		return time;
	}

}
