package loc.solution;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

	public static void main(String[] args) {

		int A[] = {3,4,3,2,3,-1,3,3};
         
		int index = getDominatorIndex(A);
		System.out.println("Index of Domainator: "+ index );
	}

	private static int getDominatorIndex(int A[]) {

		if (A == null || A.length == 0) {
			return -1;
		}
		
		if(A.length == 1) {
			return 0;
		}

		int domIndex = -1;
		int ONE = 1;
		int count = 0;
		int inpArrLen = A.length;

		Map<Integer, Integer> elementCount = new HashMap<Integer, Integer>();

		// Find the dominator and return index
		for (int i = 0; i < inpArrLen; i++) {
			if (elementCount.containsKey(A[i])) {
				// increase element count
				count = elementCount.get(A[i]);
				if (count >= inpArrLen / 2) {
					return i;
				}
				elementCount.put(A[i], count + ONE);
			} else {
				// add to map
				elementCount.put(A[i], ONE);
			}
		}

		return domIndex;
	}

}
