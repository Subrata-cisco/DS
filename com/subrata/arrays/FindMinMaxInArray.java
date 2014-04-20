package com.subrata.arrays;

/**
 * Given an array of integers, find the maximum and minimum of the array.
 * Idea : Check next 2 consecutive number and assign min ,max . 
 * If odd no of total events check the min/max with last number and assign them accordingly.
 * 
 * @author subratas
 *
 */
public class FindMinMaxInArray {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 1, 2, 6, 9, 2, 0 };
		//int[] arr = { 4, 3, 5, 1, 2, 6, 9, 2, 10, 15 };
		int max = arr[0];
		int min = arr[0];
		System.out.println("*************Subrata Initial max ::"+max +" min ::"+min);
		int i = 0;
		for (; i < arr.length / 2; i++) {
			int num1 = arr[i * 2];
			int num2 = arr[i * 2 + 1];
			System.out.println("*************Subrata no ["+(i*2)+","+(i*2 +1)+" num1 ::"+num1+" num2 ::"+num2);
			if (arr[i * 2] >= arr[i * 2 + 1]) {
				if (num1 > max)
					max = num1;
				if (num2 < min)
					min = num2;
			} else {
				if (num2 > max)
					max = num2;
				if (num1 < min)
					min = num1;
			}
		}
		System.out.println("*************Subrata Loop finished !!");
		if (i * 2 < arr.length) {
			System.out.println("*************Subrata Yes i*2 < arr.length , so num is ::"+arr[i*2]);
			int num = arr[i * 2];
			if (num > max)
				max = num;
			if (num < min)
				min = num;
		}
		System.out.println("maximum= " + max);
		System.out.println("minimum= " + min);
	}

}
