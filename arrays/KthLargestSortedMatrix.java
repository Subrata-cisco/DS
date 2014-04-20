package arrays;

/**
 * 
 * @author subratas
 *
 */
public class KthLargestSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 5, 7, 8, 9 }, { 6, 9, 11, 13 }, { 7, 11, 12, 14 },
				{ 8, 13, 16, 17 } };
		printMatrix(matrix);
		int result = findKthLargest(matrix, 2);
		System.out.println("Result ::"+result);
	}
	
	static void printMatrix(int[][]m){
	//	System.out.println();
		for(int i =0;i<m[0].length;i++){
			for(int j =0;j<m.length;j++){
				System.out.print(" "+m[i][j]);
			}
		}
		System.out.println();
	}

	private static int findKthLargest(int[][] matrix, int k) {
		for (int i = 0; i < k - 1; ++i){
			System.out.println("********* LOOP START **********");
			reArrange(matrix, matrix.length - 1, matrix[0].length - 1);
			System.out.println("********* LOOP END **********");
		}
		printMatrix(matrix);
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}

	private static void reArrange(int[][] matrix, int row, int col) {
		System.out.println("********* REARRANGE START ********** row ::"+row+" col ::"+col);
		int newRow = 0;
		int newCol = 0;
		if (row == 0 && col == 0) {
			matrix[row][col] = Integer.MIN_VALUE;
			System.out.println(" as row == 0 and col == 0 assign matrix[0][0] as MIN_VALUE and return..");
			return;
		} else if (row == 0) {
			newRow = row;
			newCol = col - 1;
			System.out.println(" as row == 0 as newRow ::"+row+" and newCol as ::"+(col-1));
		} else if (col == 0) {
			newRow = row - 1;
			newCol = col;
			System.out.println(" as col == 0 as newRow ::"+(row-1)+" and newCol as ::"+(col));
		} else if (matrix[row][col - 1] > matrix[row - 1][col]) {
			newRow = row;
			newCol = col - 1;
			System.out.println(" as matrix[" + row + "][" + (col - 1) + "] :: "
					+ matrix[row][col - 1] + " > matrix[" + (row - 1) + "]["
					+ col + "] ::" + matrix[row - 1][col] + " ,so newRow ::"
					+ row + " and newCol as ::" + (col - 1));
		} else {
			newRow = row - 1;
			newCol = col;
			System.out.println(" as matrix[" + row + "][" + (col - 1) + "] :: "
					+ matrix[row][col - 1] + " < matrix[" + (row - 1) + "]["
					+ col + "] ::" + matrix[row - 1][col] + " ,so newRow ::"
					+ (row - 1) + " and newCol as ::" + (col));
		
		}
		matrix[row][col] = matrix[newRow][newCol];
		System.out.println(" changing matrix ["+row+"]col["+col+"] to ::"+matrix[newRow][newCol]);
		printMatrix(matrix);
		reArrange(matrix, newRow, newCol);
		System.out.println("********* REARRANGE END **********");
	}

}
