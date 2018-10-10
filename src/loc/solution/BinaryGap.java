/*
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros 
 * that is surrounded by ones at both ends in the binary representation of N.
 *
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of 
 * length 4 and one of length 3. The number 20 has binary representation 10100 and contains one
 * binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
 *  The number 32 has binary representation 100000 and has no binary gaps.
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
