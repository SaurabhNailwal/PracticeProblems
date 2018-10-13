package loc.solution;

public class TapeEquilibrium {

	public static void main(String[] args) {
		/* * 
		 * A non-empty array A consisting of N integers is given, array A represents
		 * numbers on a tape. Any integer P, such that 0 < P < N, splits this tape into
		 * two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N −
		 * 1]. The difference between the two parts is the value of: |(A[0] + A[1] + ...
		 * + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])| In other words, it is the
		 * absolute difference between the sum of the first part and the sum of the
		 * second part.
		 */

		int p = 3;
		int[] arr = { 6, 3, 4, 1, 5, 2, 3, 1 };

		System.out.println("Difference is: " + findDiffFromPoint(arr, p));

	}

	private static int findDiffFromPoint(int[] arr, int p) {

		int sumBefP = 0;
		int sumFromP = 0;

		for (int i = 0; i < p; i++) {
			sumBefP += arr[i];
		}

		for (int j = p; j < arr.length; j++) {
			sumFromP += arr[j];
		}

		int diff = sumBefP - sumFromP;

		if (diff < 0) {
			diff = -diff;
		}

		return diff;
	}

}
