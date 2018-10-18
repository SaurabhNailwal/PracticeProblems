package loc.solution;
import java.io.IOException;
import java.util.Scanner;

public class EnglishAlphabets {

	public static void main(String[] args) throws IOException {

		/**
		 * Finding the specified word in 2D Array
		 * 
		 * eg: Given array A A K A S K A K K
		 * 
		 * word: ASK
		 * 
		 * return count of ASK as 4 as ASK can be found 4 times in the array.
		 */
		Scanner in = new Scanner(System.in);
		int output = 0;
		int ip1_rows = 0;
		int ip1_cols = 0;
		ip1_rows = Integer.parseInt(in.nextLine().trim());
		ip1_cols = Integer.parseInt(in.nextLine().trim());

		String[][] ip1 = new String[ip1_rows][ip1_cols];
		for (int ip1_i = 0; ip1_i < ip1_rows; ip1_i++) {
			for (int ip1_j = 0; ip1_j < ip1_cols; ip1_j++) {
				ip1[ip1_i][ip1_j] = in.next();

			}
		}
		in.nextLine();
		String ip2 = in.nextLine().trim();
		output = word_count(ip1, ip2);
		System.out.println(String.valueOf(output));

		in.close();
	}

	public static int word_count(String[][] input1, String input2) {
		int occurrences = 0;
		int charIndex = 0;

		if (input2.length() == 0 || input1.length < input2.length() && input1[0].length < input2.length()) {
			return occurrences;
		}

		System.out.println("r: " + input1.length + " c: " + input1[0].length);

		for (int i = 0; i < input1.length; i++) {
			for (int j = 0; j < input1[0].length; j++) {

				occurrences = findOccurrences(input1, i, j, input2, charIndex, occurrences);

			}
		}

		return occurrences;

	}

	public static int findOccurrences(String[][] input1, int row, int col, String input2, int charIndex,
			int occurrences) {

		//System.out.println(
		//		"row: " + row + " col: " + col + " letter: " + input2.charAt(charIndex) + " Occ: " + occurrences);

		if (row > input1.length - 1 || col > input1[0].length - 1) {
			return occurrences;
		}

		if (input1[row][col].charAt(0) != input2.charAt(charIndex)) {
			return occurrences;
		}

		if (charIndex + 1 > input2.length() - 1) {
			return occurrences;
		}

		// find occurences with direction

		String[] directions = { "top left", "top", "top right", "left", "right", "bottom left", "bottom",
				"bottom right" };

		for (String direction : directions) {
			occurrences = findOccurencesWithDirection(input1, row, col, input2, charIndex, occurrences, direction);
		}

		return occurrences;
	}

	private static int findOccurencesWithDirection(String[][] input1, int row, int col, String input2, int charIndex,
			int occurrences, String direction) {

		// top left
		// find if it exists and also if it is the last char in input2
		if (row - 1 >= 0 && col - 1 >= 0 && direction.equalsIgnoreCase("top left")) {
			if (input1[row - 1][col - 1].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row - 1, col - 1, input2, charIndex + 1,
							occurrences, direction);
				}

			}
		}

		// top
		if (row - 1 >= 0 && direction.equalsIgnoreCase("top")) {
			if (input1[row - 1][col].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row - 1, col, input2, charIndex + 1, occurrences,
							direction);
				}

			}
		}
		// top right
		if (row - 1 >= 0 && col + 1 <= input1[0].length - 1 && direction.equalsIgnoreCase("top right")) {
			if (input1[row - 1][col + 1].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row - 1, col + 1, input2, charIndex + 1,
							occurrences, direction);
				}

			}
		}
		// left
		if (col - 1 >= 0 && direction.equalsIgnoreCase("left")) {
			if (input1[row][col - 1].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row, col - 1, input2, charIndex + 1, occurrences,
							direction);
				}

			}
		}

		// right
		if (col + 1 <= input1[0].length - 1 && direction.equalsIgnoreCase("right")) {
			if (input1[row][col + 1].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row, col + 1, input2, charIndex + 1, occurrences,
							direction);
				}

			}
		}

		// bottom left
		if (row + 1 <= input1.length - 1 && col - 1 >= 0 && direction.equalsIgnoreCase("bottom left")) {
			if (input1[row + 1][col - 1].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row + 1, col - 1, input2, charIndex + 1,
							occurrences, direction);
				}

			}
		}

		// bottom
		if (row + 1 <= input1.length - 1 && direction.equalsIgnoreCase("bottom")) {
			if (input1[row + 1][col].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row + 1, col, input2, charIndex + 1, occurrences,
							direction);
				}

			}

		}

		// bottom right
		if (row + 1 <= input1.length - 1 && col + 1 <= input1[0].length - 1
				&& direction.equalsIgnoreCase("bottom right")) {
			if (input1[row + 1][col + 1].charAt(0) == input2.charAt(charIndex + 1)) {
				if (charIndex + 1 == input2.length() - 1) {
					occurrences++;
				} else {
					occurrences = findOccurencesWithDirection(input1, row + 1, col + 1, input2, charIndex + 1,
							occurrences, direction);
				}

			}
		}

		return occurrences;
	}

}
