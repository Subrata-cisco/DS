package com.subrata.hackerrankarticle;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(" Sqrt of 4 ::" + floorSqrt(4));
	}

	public static int floorSqrt(int number) {
		// Base Cases
		if (number == 0 || number == 1)
			return number;

		// Do Binary Search for floor(sqrt(x))
		int start = 1, end = number, ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			System.out.println("mid ::"+mid);

			// If x is a perfect square
			if (mid * mid == number){
				System.out.println("Perfect square so answer is::"+mid);
				return mid;
			}
				

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			if (mid * mid < number) {
				start = mid + 1;
				ans = mid;
			} else {// If mid*mid is greater than x
				end = mid - 1;
			}
		}
		return ans;
	}

}
