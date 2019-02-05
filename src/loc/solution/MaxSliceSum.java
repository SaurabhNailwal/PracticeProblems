package loc.solution;

/**
 *  Solution for Max Slice Sum problem
 * 
 * @author SN
 *
 */
public class MaxSliceSum {

	public static void main(String[] args) {
		
		
		//int[] A = {3, 2, -6, 4, 0}; // Output -> 5
		
		
		int[] A = {-2, -2};//Output ->-2
		
		System.out.println("Max Slice sum by Approach1: "+calcMaxSliceSum1(A));
		System.out.println("Max Slice sum by Approach2: "+calcMaxSliceSum2(A));
	}
	
	/**
	 * Approach 1 - O(n*n)
	 * 
	 * @param A
	 * @return
	 */
	private static int calcMaxSliceSum1(int[] A) {
		
		if(A == null || A.length == 0) {
			return 0;
		}
		
		if(A.length == 1) {
			return A[0];
		}
        
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0;i<A.length; i++){
            sum = A[i];
            if(sum > maxSum){
                maxSum = sum;
            }
            
            for(int j=i+1;j< A.length;j++){
                sum +=A[j];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
            
            
        }
        
        return maxSum;
    
	}
	
	
	/**
	 * Approach 2 - O(n)
	 * 
	 * @param A
	 * @return
	 */
	private static int calcMaxSliceSum2(int[] A) {
        
		if(A == null || A.length == 0) {
			return 0;
		}
		
		if(A.length == 1) {
			return A[0];
		}
        

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0;i<A.length; i++){
            sum +=A[i];
        	if(sum < A[i]) {
        		sum = A[i];
        	}
        	
        	if(sum > maxSum) {
        		maxSum = sum;
        	}
        	
        }
        
        return maxSum;
    
	}

}
