package com.subrata.arrays;

import java.util.Arrays;

/**
 * a. First we can sort the elements of the array. 
 * b. Then we can iterate over the array and find difference between consecutive elements. 
 * c. The least of them would be the least differences between any two elements of the array. 
 *    The complexity will be O(nlogn) because of the sorting step.
 * 
 * @author subratas
 *
 */

public class LeastDifference {
	public static void main(String[] args) {
		int[] arr = { 64, 57, 2, 78, 43, 73, 53, 86 };
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; ++i) {
			int diff = Math.abs(arr[i] - arr[i + 1]);
			if (diff < minDiff)
				minDiff = diff;
		}
		System.out.println(minDiff);
	}
}
