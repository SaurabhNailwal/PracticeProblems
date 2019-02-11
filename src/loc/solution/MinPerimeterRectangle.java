package loc.solution;

public class MinPerimeterRectangle {

	public static void main(String[] args) {
		int N = 36;// output -> 24
		
		// int N=1; // output -> 4
		
		System.out.println("Min Perimeter is: "+ getMinPerimeter(N) );

	}
	
	private static int getMinPerimeter(int N) {
        
        if(N == 1){
            return 4;
        }
        
        int minPerimeter = 2* (1+N);
        int perimeter = 0;
        
        for(int i=2; i <= Math.sqrt(N); i++){
            
            if(N%i == 0){
                
                perimeter = 2* (i + N/i);
                if(minPerimeter > perimeter){
                	//System.out.println(minPerimeter);
                    minPerimeter = perimeter;
                }
            }
            
            
        }
        
        
        return minPerimeter;}

}
