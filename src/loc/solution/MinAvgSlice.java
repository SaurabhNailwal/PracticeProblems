package loc.solution;

/**
 * Solution for Min Avg Slice problem
 * 
 * @author SN
 *
 */

public class MinAvgSlice {

	public static void main(String[] args) {
				
		int[] arr = { 4, 2, 2, 5, 1, 5, 8};
		
		System.out.println("Minimum average slice starting position is: "+ findMinAvgSlice(arr));

	}

	private static int findMinAvgSlice(int[] arr) {
		
		double minAvg = Double.MAX_VALUE;
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		float sum = 0;
		int divisor = 1;
		double currAvg = 0;
		int minIndex = -1;
		
		// Approach 1
		for (int i = 0; i < arr.length-1; i++) {
			
			sum = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				
				sum += arr[j];
				divisor = (j - i)+1;
				currAvg = sum / divisor;
				//System.out.println("i: "+ i+" j: "+j+ " currAvg: "+ currAvg +" sum: "+sum +" divisor: "+divisor);
				
				if(currAvg < minAvg) {
					
					minAvg = currAvg;
					minIndex = i;
					//System.out.println("i: "+ i+" j: "+ j+ " minAvg: "+ minAvg);
				}
				
			}
			
		}
		
		// Approach 2: finding only first 2 and 3 slices
		// Proof : https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility
		
		minAvg = Double.MAX_VALUE;
		sum = 0;
		divisor = 1;
		currAvg = 0;
		minIndex = -1;
		
		for (int i = 0; i < arr.length-1; i++) {
			
			sum = arr[i];			
			
			// 2 element slice
			sum += arr[i+1]; 
			currAvg = sum/2.0;
			if(currAvg < minAvg){
				minAvg = currAvg;
				minIndex = i;				
			}
			
			if(i < arr.length-2) {
				// 3 element slice
				sum += arr[i+2];
				currAvg = sum/3.0;
				if(currAvg < minAvg){
					minAvg = currAvg;
					minIndex = i;				
				}		
			}			
			
		}
		
		
		return minIndex;
	}

}
