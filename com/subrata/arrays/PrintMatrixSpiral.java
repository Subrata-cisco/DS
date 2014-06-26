package com.subrata.arrays;

/**
 * a. print the periphery of the matrix b. Then recursively call this function
 * to do the same thing with inner concentric rectangles. c. We will pass this
 * information by a variable named depth, which will tell how many layers from
 * outside should be ignored.
 * 
 * a. print first remaining row.    -> (l,n),[k][i], k++
 * b. print last remaining column.  -> (k,m),[i][n-1] ,n--
 * c. print last remaining row.     -> m--
 * d. print first remaining column. -> l++
 * 
 * @author subratas
 * 
 */
public class PrintMatrixSpiral {
	public static void main(String[] args) {

		/*int[][] matrix1 = { { 3, 4, 5, 6, 2, 5 }, { 2, 4, 6, 2, 5, 7 },
				{ 2, 5, 7, 8, 9, 3 }, { 2, 4, 7, 3, 5, 8 },
				{ 6, 4, 7, 3, 5, 7 } };*/

		int[][] matrix = { { 1, 2, 3}, { 8,9,4 }, { 7,6,5}};

		//printSpiral(matrix);
		//spiralPrint(4,4,matrix);
		spiralOrder(matrix);
	}

	static void spiralPrint(int m, int n, int[][] a) {
		int i, k = 0, l = 0;

		/*
		 * k - starting row index m - ending row index l - starting column index
		 * n - ending column index i - iterator
		 */

		while (k < m && l < n) {
			/* Print the first row from the remaining rows */
			for (i = l; i < n; ++i) {
				System.out.print(" " + a[k][i]);
			}
			k++;

			/* Print the last column from the remaining columns */
			for (i = k; i < m; ++i) {
				System.out.print(" " + a[i][n-1]);
			}
			n--;

			/* Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(" " + a[m-1][i]);
				}
				m--;
			}

			/* Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(" " + a[i][l]);
				}
				l++;
			}
		}
	}
	
	
	
	private static void spiralOrder(int[][] matrix) {
		if (matrix.length == 0)
			return;
		// Initialize our four indexes
		int top = 0;
		int down = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (true) {
			// Print top row
			for (int j = left; j <= right; ++j)
				System.out.print(matrix[top][j] + " ");
			top++;
			if (top > down || left > right)
				break;
			// Print the rightmost column
			for (int i = top; i <= down; ++i)
				System.out.print(matrix[i][right] + " ");
			right--;
			if (top > down || left > right)
				break;
			// Print the bottom row
			for (int j = right; j >= left; --j)
				System.out.print(matrix[down][j] + " ");
			down--;
			if (top > down || left > right)
				break;
			// Print the leftmost column
			for (int i = down; i >= top; --i)
				System.out.print(matrix[i][left] + " ");
			left++;
			if (top > down || left > right)
				break;
		}
	}
}
