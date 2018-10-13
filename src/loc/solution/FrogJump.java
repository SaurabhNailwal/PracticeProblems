package loc.solution;

public class FrogJump {

	public static void main(String[] args) {
		/*  A small frog wants to get to the other side of the road.
		 *  The frog is currently located at position X and wants to
		 *  get to a position greater than or equal to Y. The small 
		 *  frog always jumps a fixed distance, D.
		 *  Count the minimal number of jumps that the small frog 
		 *  must perform to reach its target.
		 */
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
