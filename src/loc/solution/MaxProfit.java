package loc.solution;

/**
 *  Solution for Max Profit problem
 * 
 * @author SN
 *
 */
public class MaxProfit {

	public static void main(String[] args) {
		
		int[] A= {23171, 21011, 21123, 21366, 21013, 21367}; //output->356
		
		//int[] A= {8, 9, 3, 6, 1, 2}; // output->3
		
		int maxProfit = getMaxTradingProfit(A);
		
		System.out.println("Maxium profit is: "+ maxProfit);
	}
	
	private static int getMaxTradingProfit(int[] A) {
        
        if(A == null || A.length < 2){
            return 0;
        }
        
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = 0;
        
        for(int i=0;i< A.length-1;i++){
            
            // getting the min share price
            if(A[i] < minPrice){
                minPrice = A[i];
            }
            
            // calculating profit
            if(A[i+1] > minPrice){
            	profit = A[i+1] - minPrice;
                maxProfit = (profit > maxProfit)? profit: maxProfit;
            }
            
        }
        
        return maxProfit;
    }

}
