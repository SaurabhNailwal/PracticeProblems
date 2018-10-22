package loc.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GenomicRangeQuery {

	public static void main(String[] args) {

		/* *
		 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T,
		 * which correspond to the types of successive nucleotides in the sequence. Each nucleotide
		 * has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact
		 * factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form:
		 * What is the minimal impact factor of nucleotides contained in a particular part of the given
		 * DNA sequence?
		 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N 
		 * characters. There are M queries, which are given in non-empty arrays P and Q, each consisting
		 * of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of
		 * nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

		 * For example, consider string S = CAGCCTA and arrays P, Q such that:
         *
		 *		    P[0] = 2    Q[0] = 4
		 *		    P[1] = 5    Q[1] = 5
		 *		    P[2] = 0    Q[2] = 6
		 *
		 * The answers to these M = 3 queries are as follows:
		 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact
		 * factors are 3 and 2 respectively, so the answer is 2.
		 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so 
		 * the answer is 4.
		 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular
		 * nucleotide A whose impact factor is 1, so the answer is 1.
		 * */
		
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
