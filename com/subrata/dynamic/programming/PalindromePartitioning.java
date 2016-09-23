package com.subrata.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Idea :
 * 1) Fill all [0,0][1,1][2,2]..... with 1 means we are taking the words..
 * 2) The above thing will fill the diagonal coordinate in [length][length] matrix.
 * 3) We should now fill upper portion of the matrix again diagonally.
 * 4) While doing 3 if a[x] a[y] value matches then pull the value for this field from diagonal down field 
 *    (e.g suppose a[1] and a[3] value is same string value then a[1][3] = a[1+1][3-1] = a[2][2] dynamically computed)
 * 5) If does not match put it zero.
 * 
 * Similar problem : Longest palindromic substring.
 * 
 * @author subrsaha
 *
 */
public class PalindromePartitioning {
	
	public static void main(String[] args) {
		String s = "nitin";
		List<String> list  = palindromePartitioning(s);
		
		list.stream().forEach(System.out::println); 
	}
	
	public static List<String> palindromePartitioning(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null)
			return result;
		if (s.length() <= 1) {
			result.add(s);
			return result;
		}

		int length = s.length();
		int[][] table = new int[length][length];

		// l is length, i is index of left boundary, j is index of right
		// boundary
		for (int l = 1; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;
				System.out.println("l::"+l+"i::"+i+"j::"+j);
				if (s.charAt(i) == s.charAt(j)) {
					if (l == 1 || l == 2) {
						table[i][j] = 1;
					} else {
						table[i][j] = table[i + 1][j - 1];
					}
					if (table[i][j] == 1) {
						result.add(s.substring(i, j + 1));
					}
				} else {
					table[i][j] = 0;
					//printTable(table);
				}
			}
		}
		return result;
	}
	
	static void printTable(int[][] table){
		int i = table[0].length;
		int j = table.length;
		for(int ii=0;ii<i;ii++){
			for(int jj=0;jj<j;jj++){
				System.out.println("tab ::"+table[ii][jj]);
			}
		}
		System.out.println("***************");
	}
}
