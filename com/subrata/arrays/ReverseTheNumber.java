package com.subrata.arrays;
/**
 * Reverse the number using recursion.
 * @author Subrata Saha.
 *
 */
public class ReverseTheNumber {
	
	public static void main(String[] args) {
		StringBuilder sb =new StringBuilder();
		reversDigits(12345,sb);
		System.out.println("****** Subrata -> "+sb.toString());
	}
	
	public static int reversDigits(int num,StringBuilder sb) {
		System.out.println("****** Subrata -> num ::"+num);
		if (num < 1) {
			return 0;
		}

		int temp = num % 10;
		num = (num - temp) / 10;
		sb.append(temp);
		return reversDigits(num,sb);

	}
}
