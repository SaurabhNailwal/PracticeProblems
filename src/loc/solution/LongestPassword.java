package loc.solution;

public class LongestPassword {

	public static void main(String[] args) {

		String S = "zaq123edc";
		// "test 5 a0A pass007 ?xy1";

		System.out.println("The longest password length is: " + longestPasswordCheck(S));
	}

	/**
	 * @param S
	 * @return
	 */
	public static int longestPasswordCheck(String S) {

		// break into individual pwds
		S = S.toLowerCase();
		int letterCount = 0;
		int digitCount = 0;
		int maxPasswordLength = -1;
		boolean isValid = true;

		String[] passwords = S.split(" ");

		// 0-9 48 to 57
		// a-z 97-122
		for (int i = 0; i < passwords.length; i++) {

			// System.out.println(passwords[i]);

			for (int j = 0; j < passwords[i].length(); j++) {

				if (_isNumber(passwords, i, j)) {
					// number
					digitCount++;
				} else if (isLowercaseLetter(passwords, i, j)) {
					// letter
					letterCount++;
				} else {
					// invalid character
					isValid = false;

					// System.out.println("Invalid" + passwords[i]+passwords[i].charAt(j));
					break;
				}

			}

			// check for alphanumerical, even number of letters
			// and odd number of digits
			if (isValid && letterCount % 2 == 0 && digitCount % 2 == 1) {
				if (maxPasswordLength < passwords[i].length()) {
					maxPasswordLength = passwords[i].length();
				}
			}

			letterCount = 0;
			digitCount = 0;
			isValid = true;

		}

		return maxPasswordLength;
	}

	private static boolean isLowercaseLetter(String[] passwords, int i, int j) {
		return passwords[i].charAt(j) > 96 && passwords[i].charAt(j) < 123;
	}

	private static boolean _isNumber(String[] passwords, int i, int j) {
		return passwords[i].charAt(j) > 47 && passwords[i].charAt(j) < 58;
	}

}
