package loc.solution;

/**
 * Solution for Count Factors problem
 * 
 * @author SN
 *
 */
public class CountFactors {

	public static void main(String[] args) {
		
		CountFactors cF = new CountFactors();
		
		int N = 24; // output -> 8 
		
		int factorsCount = cF.getfactorCount(N);
		
		System.out.println("Number of factors is: "+ factorsCount);

	}
	
	private int getfactorCount(int N) {
        
        if(N == 1){
            return 1;
        }
        
        //counting 1 and the number itself
        int factorCount = 2;
        
        int sqrtN =  (int) Math.sqrt(N);
        
        for(int i=2;i<= sqrtN; i++){
            
            if(N%i == 0){
            	
            	if(i*i == N) {
            		factorCount++;
            	} else {
            		factorCount+=2;
            	}
                //System.out.println(i);
            }
            
        }
        
        return factorCount;
        
    }

}
