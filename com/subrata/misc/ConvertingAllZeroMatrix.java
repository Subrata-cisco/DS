package com.subrata.misc;

/**
 * 
 * Given a NxN matrix with 0s and 1s. Set every row that contains a 0 to all 0s and set every column that contains a 0 to all 0s.

For example

1 0 1 1 0
0 1 1 1 0
1 1 1 1 1
1 0 1 1 1
1 1 1 1 1
results in

0 0 0 0 0
0 0 0 0 0
0 0 1 1 0
0 0 0 0 0
0 0 1 1 0
 * 
 * 
 * @author subratas
 *
 */
public class ConvertingAllZeroMatrix {
	int arr[][]= {{1 ,0, 1, 1 ,0},
				  {0 ,1, 1, 1 ,0},
				  {1 ,1, 1, 1 ,1},
				  {1 ,0, 1, 1 ,1},
				  {1 ,1, 1, 1 ,1}};
	
	
	public static void main(String[] args) {
		int x = 99;
		int y = 24;
		
		int k = x ^ y;
		System.out.println(" XOR ::"+k);
		System.out.println(" To get 99 :: "+(k^24));
	}

}
