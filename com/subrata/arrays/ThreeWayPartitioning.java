package com.subrata.arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * 
 * This is also called Dutch Flag problem.
 * 
 * Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1} Output = {0, 0, 0, 0, 0, 1, 1,
 * 1, 1, 1, 2, 2}
 * 
 * @author subratas
 * 
 */
public class ThreeWayPartitioning {

	void sort012(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0;

		while (mid <= hi) {
			System.out.println("****** Subrata -> mid ::"+mid+" hi ::"+hi+" a[mid] ::"+a[mid]);
			switch (a[mid]) {
			case 0:
				swap(lo++, mid++ , a);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(mid, hi--,a);
				break;
			}
			printArray(a);
		}
	}

	void swap(int low, int hi , int[] a) {
		//System.out.println("****** Subrata -> swap a[low] ::"+a[low]+" with a[hi]"+a[hi] +" low ::"+low+" hi ::"+hi);
		int temp = a[low];
		a[low] = a[hi];
		a[hi] = temp;
	}

	void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		ThreeWayPartitioning partitioning = new ThreeWayPartitioning();
		//int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr[] = { 0, 1, 1, 0, 1, 2};
		int arr_size = arr.length;
		partitioning.sort012(arr, arr_size);
		partitioning.printArray(arr);
	}
}
