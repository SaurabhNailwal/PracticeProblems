package loc.solution;

import java.util.Stack;

/**
 * Solution for StoneWall problem
 * 
 *  
 * @author SN
 *
 */
public class StoneWall {

	public static void main(String[] args) {

		int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
		
		int blocks = findNumberOfBlocks(H);
		
		System.out.println("Number of blocks needed is: "+ blocks);

	}
	
	private static int findNumberOfBlocks(int H[]) {

		int numOfBlocks = 0;
		
		if(H == null || H.length == 0) {
			return numOfBlocks;
		}
		
		if(H.length == 1) {
			return ++numOfBlocks;
		}
		
		Stack<Integer> blockHeights = new Stack<Integer>();
		
		for(int i=0; i< H.length; i++) {
			
			while(!blockHeights.empty() && blockHeights.peek() > H[i]){
				blockHeights.pop();
			}
			
			if(blockHeights.empty()) {
				blockHeights.push(H[i]);
				numOfBlocks++;
			} else {
				if(blockHeights.peek() != H[i]) {
					blockHeights.push(H[i]);
					numOfBlocks++;
				}
			}			
			
		}		
		
		
		return numOfBlocks;
	}

}
