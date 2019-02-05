package loc.solution;

/**
 * Solution for StoneWall problem
 * 
 *  
 * @author SN
 *
 */
public class Nesting {

	public static void main(String[] args) {

		String S = "(()(())())";
		//String S = "())";
		
		int nested = isStringNested(S);
		
		if(nested == 1) {
			System.out.println("String is nested");
		} else {
			System.out.println("String is not nested");
		}

	}
	
	private static int isStringNested(String S) {
        
        if(S == null || S.length() == 0){
            return 1;
        }
        
        if(S.length()%2 != 0){
            return 0;
        }
        
        int openBracketCount = 0;
        
        for(int i=0; i < S.length(); i++){
            if(S.charAt(i)=='('){
                openBracketCount++;
            } else{
                if(openBracketCount <= 0){
                    return 0;
                }
                openBracketCount--;
                
            }
        }
        
        int isNested = 1;
        
        if(openBracketCount != 0){
            isNested = 0;
        }
        
        return isNested;
        
    }

}
