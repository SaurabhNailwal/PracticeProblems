package loc.solution;

import java.util.Stack;

/**
 * Codility Brackets problem.
 * 
 * @author sn
 *
 */
public class Brackets {

	public static void main(String[] args) {
		

		// String S = "{[()()]}";
		String S = ")(";
		// String S ="([)()]";

		int isNested = isProperlyNested(S);

		if (isNested == 1) {
			System.out.println("Is properly nested");
		} else {
			System.out.println("Is not properly nested");
		}

	}

	private static int isProperlyNested(String S) {

		// if Sting is empty, then it is properly nested
		if (S == null || S.isEmpty()) {
			return 1;
		}

		// if String length is odd then it is not properly nested
		if (S.length() % 2 != 0) {
			return 0;
		}

		int porperlyNested = 1;

		// Approach: Using a stack to check when close brackets are reached
		Stack<Character> bracketStack = new Stack<Character>();
		char bracket;

		for (int i = 0; i < S.length(); i++) {
			bracket = S.charAt(i);
			if (bracket != '}' && bracket != ']' && bracket != ')') {
				bracketStack.push(S.charAt(i));
			} else {
				if (bracket == ')') {

					if (bracketStack.empty() || bracketStack.pop() != '(') {
						return 0;
					}

				} else if (bracket == ']') {
					if (bracketStack.empty() || bracketStack.pop() != '[') {
						return 0;
					}

				} else if (bracket == '}') {
					if (bracketStack.empty() || bracketStack.pop() != '{') {
						return 0;
					}

				}
			}

		}
		
		if(!bracketStack.empty()) {
			porperlyNested = 0;
		}

		return porperlyNested;
	}

}
