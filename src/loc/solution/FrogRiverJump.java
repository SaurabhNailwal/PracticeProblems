package loc.solution;

import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Solution for Frog River Jump problem
 * 
 * @author SN
 *
 */

public class FrogRiverJump {

	public static void main(String[] args) {
		
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
