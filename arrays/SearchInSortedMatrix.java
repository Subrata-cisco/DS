package arrays;

public class SearchInSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 5, 7, 8, 9 }, { 6, 9, 11, 13 }, { 7, 11, 12, 14 },
				{ 8, 13, 16, 17 } };
		boolean result = contains(matrix, 12);
		System.out.println(result);

	}

	private static boolean contains(int[][] matrix, int k) {
		System.out.println(" strating to search ::"+k);
		int row = matrix.length;
		int col = matrix[0].length;
		int currentRow = 0;
		int currentCol = col - 1;
		System.out.println(" row ::"+row+" col ::"+col+" currentRow ::"+currentRow+" currentCol ::"+currentCol);
		while (currentRow != row && currentCol != -1) {
			System.out.println("matrix["+currentRow+"]["+currentCol+"] ::"+matrix[currentRow][currentCol]);
			if (matrix[currentRow][currentCol] == k){
				System.out.println("Match found return true !!");
				return true;
			}
			else if (matrix[currentRow][currentCol] > k){
				System.out.println("matrix["+currentRow+"]["+currentCol+"] ::"+matrix[currentRow][currentCol]+" > "+k+" , so currentCol --");
				currentCol--;
				System.out.println("currentCol decremented ::"+currentCol);
			}
			else {
				currentRow++;
				System.out.println("currentRow incremented ::"+currentRow);
			}
		}
		return false;
	}
}
