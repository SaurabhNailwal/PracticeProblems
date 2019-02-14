package loc.solution;

import java.util.HashSet;
import java.util.Set;


/**
 * Solution for Chocolate By Numbers problem
 * 
 * @author SN
 *
 */
public class ChocolatesByNumbers {

	public static void main(String[] args) {

		int chocEaten1 = getChocEatenCount_Approach1(947853, 4453);
		int chocEaten2 = getChocEatenCount_Approach2(947853, 4453);
		System.out.println("1 Chocolates eaten: " + chocEaten1);
		System.out.println("2 Chocolates eaten: " + chocEaten2);
	}
	
	/**
	 * Approach 2 - using lcm
	 * 
	 * @param N
	 * @param M
	 * @return
	 */
	private static int getChocEatenCount_Approach2(int N, int M) {

		int chocEaten = 1;

		//find gcd
		int gcd = gcd(N,M);
		
		//find lcm  and divide lcm by m 
		// so removing m directly
		int lcm = N/gcd;
		
		 
		chocEaten = lcm;

		return chocEaten;

	}
	
	
	private static int gcd(int a, int b) {
		
		if(a == 0) {
			return b;
		} 
		
		return gcd(b%a, a);		
		
	}

	/**
	 * Approach 1
	 * 
	 * @param N
	 * @param M
	 * @return
	 */
	private static int getChocEatenCount_Approach1(int N, int M) {

		int chocEaten = 1;

		// Values with 0 indicates chocolate present
		Set<Integer> visitedSet = new HashSet<Integer>();
		
		int nextIndex = 0;

		while (true) {
			
			visitedSet.add(nextIndex);
			nextIndex = (nextIndex + M) % N;

			if (visitedSet.contains(nextIndex)) {
				break;
			}

			chocEaten++;

		}

		return chocEaten;

	}

}
