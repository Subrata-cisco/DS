package com.subrata.challenging;


public class Staircase {

	public static void main(String[] arg) {
		int n = 4;
		int[] map = new int[n + 1];

		System.out.println("*************** Subrata value ::"
				+ countWaysDP(n, map));
		System.out.println("*************** Subrata value ::" + countWaysR(n));
	}

	public static int countWaysR(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysR(n - 1) + countWaysR(n - 2) + countWaysR(n - 3);
		}
	}

	public static int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > 0) {
			return map[n];
		} else {
			// remember the line.
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map)
					+ countWaysDP(n - 3, map);
			System.out.println("*************** Subrata map[" + n
					+ "] value ::" + map[n]);
			return map[n];
		}
	}

}
