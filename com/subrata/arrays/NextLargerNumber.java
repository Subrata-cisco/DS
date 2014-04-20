package com.subrata.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * - Split the number into digits 
- Scan from right to left (digits) till we find the digit lower than what we have passed by. Let us, call this as flip-point. 
- Find 'Next Highest' of the flip-point left digit with in the flip-point right portion (not in the whole set of digits). 
- Swap and flip-point left digit with 'Next Highest'. 
- Now sort the digits from the flip-point onwards (and including flip-point) 
- Construct the number back from digits 

For example: 
Input = 12345, Flip = 5, Next Highest = 5, Answer = 12354 
Input = 13483, Flip = 8, Next Highest = 8, Answer = 13834 
Input = 37723971, Flip = 9, Next Highest = 7, Answer = 37727139 

 * @author subratas
 *
 */

public class NextLargerNumber {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter an integer value");
		int n = Integer.parseInt(br.readLine());
		NextLargerNumber.big(n);
	}

	static void big(int a) {
		String n = a + "";
		char c[] = n.toCharArray();
		System.out.println("*************Subrata starting comparision from RHS to LHS !!");
		for (int i = c.length - 1; i >= 1; i--) {
			if (c[i - 1] > c[i]) {
				System.out.println("*************Subrata "+c[i-1]+ " > "+c[i]+" so continue ..");
				continue;
			} else {
				// swap
				System.out
						.println("*************Subrata check failed as "
								+ c[i - 1]
								+ "<"
								+ c[i]);
				System.out
						.println("*************Subrata "
								+ " find highest number from right side of the list > "+c[i-1]+" till flip point :"
								+ c[i]);
								
		int index = NextLargerNumber.check(c, c[i - 1]);
				System.out.println("*************Subrata index found at ::"+index+" so swap "+c[i-1]+" with "+c[index]);
				char temp = c[i - 1];
				c[i - 1] = c[index];
				c[index] = temp;
                System.out.println("*************Subrata sort the array from flip index "+i+" to end");
				Arrays.sort(c, i, c.length);

				break;
			}

		}
		NextLargerNumber.print(c);
	}
	
	static int check(char a[], int j) {
		int k;
		for (k = a.length - 1; k >= 0; k--) {
			if (a[k] > j){
				System.out.println("*************Subrata number found as ::"+a[k]+ ", the index will be ::"+k);
				break;
			}
		}
		return k;
	}

	static void print(char c[]) {
		for (int m = 0; m < c.length; m++) {
			System.out.print(c[m]);
		}
	}

	

}
