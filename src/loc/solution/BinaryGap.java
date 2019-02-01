/*
 * Solution for Codility Binary Gap problem
 */

package loc.solution;

public class BinaryGap {
	
	public static void main(String[] args) {
		//solution(9);
		//solution(15);
		//solution(529);
		//solution(32);
		solution(328);
	}
	
	public static void solution(int N) {
		
		// Approach1: convert to binary and count from 1 to 1 to get binary gap
		String binaryValue = Integer.toBinaryString(N);
		int maxCount = 0;
		int curCount = -1;
		System.out.println(binaryValue);
		
		for(int i=0;i< binaryValue.length(); i++) {
		
			// start counting
			if (binaryValue.charAt(i) == '1') {
				if (curCount > maxCount) {
					maxCount = curCount;
				}
				curCount = 0;

			} else {
				if(curCount >= 0) {
					curCount++;
				}
			}
			
		}
		
		System.out.println("Approach 1 Binary gap: "+ maxCount);
		
		maxCount = 0;
		curCount = -1;		
		//Approach2: Calculate Binary gap while converting
		int rem = 0, divisor = 2;
		
		while(N>0) {
			rem = N % divisor;
			N = N/2;
			
			if(rem == 1) {
				if(curCount >maxCount){
					maxCount = curCount;
				}
				curCount = 0;
				
			}else {
				if(curCount >= 0) {
					curCount++;
				}
				
			}
		}
		
		System.out.println("Approach 2 Binary gap: "+ maxCount);
	}

}
