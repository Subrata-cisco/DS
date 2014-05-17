package com.subrata.challenging;
/**
 * Fundamental :
 * 
 0:  m = [0, 0]        - ([0] is a subsequence of length 1.)
 8:  m = [0, 0, 8]     - (8 can be added after [0] to get a sequence of length 2.)
 4:  m = [0, 0, 4]     - (4 is better than 8. This can be added after [0] instead.)
 12: m = [0, 0, 4, 12] - (12 can be added after [...4])
 2:  m = [0, 0, 2, 12] - (2 can be added after [0] instead of 4.)
 10: m = [0, 0, 2, 10]
 6:  m = [0, 0, 2, 6]
 14: m = [0, 0, 2, 6, 14]
 1:  m = [0, 0, 1, 6, 14]
 9:  m = [0, 0, 1, 6, 9]
 5:  m = [0, 0, 1, 5, 9]
 13: m = [0, 0, 1, 5, 9, 13]
 3:  m = [0, 0, 1, 3, 9, 13]
 11: m = [0, 0, 1, 3, 9, 11]
 7:  m = [0, 0, 1, 3, 7, 11]
 15: m = [0, 0, 1, 3, 7, 11, 15]
 * @author Subrata Saha.
 *
 */

public class LongestIncreasingSequnceUsingSearch {

	// search for the index which can be replaced by the X. as the index can't
	// be
	// 0 or end (because if 0 then replace in the findLIS() and if it's greater
	// than the
	// current maximum the just append)of the array "result" so most of the
	// boundary
	// conditions are not required.
	public static int search(Integer[] array, int start, int end, int number) {
		if (start > end)
			return -1;
		int middle = (start + end) / 2;
		if (array[middle] < number && array[middle + 1] > number) {
			return middle + 1;
		} else if (array[middle] > number) {
			return search(array, start, middle, number);
		} else {
			return search(array, middle + 1, end, number);
		}
	}

	public static Integer[] findLIS(Integer[] inputArray) {
		Integer[] result = new Integer[inputArray.length];
		result[0] = inputArray[0];
		int index = 0;
		for (int i = 1; i < inputArray.length; i++) {
			int no = inputArray[i];
			System.out.println("****** Subrata ->  no is ::"+no);
			if (no < result[0]) // replacing the min number
			{
				result[0] = no;
				System.out.println("****** Subrata ->  Replace result[0]"+no);
			} else if (no > result[index]) {// if the number is bigger then the
											// current big then append
				result[++index] = no;
				System.out.println("****** Subrata -> put result["+index+"] :: "+no);
			} else {
				int c = search(result, 0, index, no);
				result[c] = no;
				System.out.println("****** Subrata -> Search te position for "+no+" and put it in result["+c+"] as "+no);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1, 8, 4, 12, 2};
		Integer[] result = findLIS(arr);
		
		for(Integer val : result){
			System.out.println("****** Subrata -> "+val);
		}
	}
}
