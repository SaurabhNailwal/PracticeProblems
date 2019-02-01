package loc.solution;

/**
 * Solution for Passing Car Count problem
 * 
 * @author SN
 *
 */

public class PassingCarCount {

	public static void main(String[] args) {
		
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
