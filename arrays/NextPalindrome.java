package arrays;

/**
 * 
 * @author subratas
 *
 *  If the number is even.
 *  Find the decimal representation of the input number ("3133").
	Split it into the left half and right half ("31", "33");
	Compare the last digit in the left half and the first digit in the right half.
	a. If the right is greater than the left, increment the left and stop. ("32") [if > 10 it gets carried over]
	b. If the right is less than the left, stop.
	c. If the right is equal to the left, repeat step 3 with the second-last digit in the left and the second digit in the right (and so on).
	Take the left half and append the left half reversed. That's your next largest palindrome. ("3223")
 * 
 *  If the number is odd then
 *  a. divide the left /right half in such that left.length = right.length +1
 *  b. Same above rules applies here.
 *  c. take the left half and append the left half reversed apart from the right most digit of it.
 *  
 *  e.g 1234628 -> 1234 628 ->1235 628 -> 1235 321 -> 1235321 
 *  e.g 94187978322 -> 941879 78322 -> 941880 78322 -> 941880 88149 -> 94188088149
 */
public class NextPalindrome {
	public static void main(String[] args) {
		System.out.println(nextPalindrome(112100));
	}

	public static int nextPalindrome(int num) {
		return nextPalindrome(num, true);
	}

	private static int nextPalindrome(int num, boolean firstTime) {
		String numString = "" + num;
		int leftEndIndex = -1;
		int rightStartIndex = -1;
		boolean isOdd = numString.length() % 2 == 1;
		if (isOdd) {
			leftEndIndex = numString.length() / 2;
			rightStartIndex = leftEndIndex + 1;
		} else {
			leftEndIndex = rightStartIndex = numString.length() / 2;

		}
		String leftHalf = numString.substring(0, leftEndIndex);
		String rightHalf = numString.substring(rightStartIndex);

		String leftReversed = new StringBuffer(leftHalf).reverse().toString();
		String palindrome = null;
		if (Integer.parseInt(leftReversed) > Integer.parseInt(rightHalf)
				|| !firstTime) {
			if (isOdd)
				palindrome = leftHalf + numString.charAt(leftEndIndex)
						+ leftReversed;
			else
				palindrome = leftHalf + leftReversed;
			return Integer.parseInt(palindrome);
		} else {
			if (isOdd) {
				String leftAndMiddle = leftHalf
						+ numString.charAt(leftEndIndex);
				int incrementedLeft = Integer.parseInt(leftAndMiddle) + 1;
				return nextPalindrome(Integer.parseInt(incrementedLeft
						+ rightHalf), false);
			} else {
				int incrementedLeft = Integer.parseInt(leftHalf) + 1;
				return nextPalindrome(Integer.parseInt(incrementedLeft
						+ rightHalf), false);
			}
		}

	}
}
