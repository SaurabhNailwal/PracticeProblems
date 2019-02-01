package loc.solution;

/**
 * Solution for Frog Jump problem
 * 
 * @author SN
 *
 */

public class FrogJump {

	public static void main(String[] args) {
		
		int xPosition = 10;
		int yPosition = 85;
		int d = 30;
		
		System.out.println("Minimum jumps: "+ findMinimumJumps(xPosition, yPosition, d));

	}

	private static int findMinimumJumps(int x, int y, int d) {
		
		//Subtract start and end position to get distance
		y-=x;
		
		//Divide to the distance to cover by jump distance
		int minJumps = (y%d ==0) ? y/d : y/d+1;
		
		
		return minJumps;
	}

}
