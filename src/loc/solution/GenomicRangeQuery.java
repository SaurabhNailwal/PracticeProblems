package loc.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Soltuion for Genomic Range Query problem
 * 
 * @author SN
 *
 */

public class GenomicRangeQuery {

	public static void main(String[] args) {
		
		String s = "CAGCCTA";
		int[] P = { 2, 5, 0};
		int[] Q = { 4, 5, 6};
		
		int[] sol = getMinimalImpactFactor(s, P, Q);
		
		//Printing the solution
		IntStream.of(sol).forEach(i -> System.out.println(i));

	}

	private static int[] getMinimalImpactFactor(String s, int[] p, int[] q) {
		
		
		int[] inputNucleotideValues = new int[s.length()];		
		
		// convert string of nucleotides to a list of nucleotide values
		for (int i=0; i < s.length(); i++ ) {
			switch (s.charAt(i)) {
			case 'A':
				inputNucleotideValues[i] = 1;
				break;
			case 'C':
				inputNucleotideValues[i] = 2;
				break;
			case 'G':
				inputNucleotideValues[i] = 3;
				break;
			case 'T':
				inputNucleotideValues[i] = 4;
				break;

			default:
				inputNucleotideValues[i] = 0;
				break;
			}
		}
		
		int minFact = 5;
		int[] returnArr = new int[p.length];
		
		for(int i=0; i < p.length ; i++) {
			
			minFact = 5;
			
			for(int j=p[i]; j <= q[i]; j++) {				
				
				//find minimal factor
				if(minFact > inputNucleotideValues[j]) {
					minFact = inputNucleotideValues[j];
				}
				
			}
			//assign to returnArr
			returnArr[i] = minFact;
		}
		
		return returnArr;
	}

}
