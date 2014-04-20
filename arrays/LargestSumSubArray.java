package arrays;

/**
 * a. start ,end , sum = 0
 * b. maxS ,maxE, maxS = 0
 * c. scan from left to right and calculate sum += arr[end]
 * d. if sum <= maxS increment the pointer start and end to next and sum = 0.
 * e. if sum > maxS then maxS = sum ; maxS = start ; maxE = end;
 * f. print maxS and maxS and maxE for desired result.
 * 
 * @author subratas
 *
 */
public class LargestSumSubArray {
	public static void main(String[] args) {
		int[] arr1 = { 4, 3, -5, 0, 6, -8, 12, 3, -9, 2, 5, 8, -3, 4, 8, 0, 3,
				-3, -5, -9, 4, 2 };
		int[] arr2 = {-2,-3,4,-1,-2,1,5,-3};
		int[] arr = {-1,2,-3,4,-5,6,-7,9,-8};
		maxSumSubArray(arr);
		//System.out.println(maxSubArraySum(arr));
	}
	
	static int maxSubArraySum(int a[]) {
		int max_so_far = 0, max_ending_here = 0;
		int i;
		for (i = 0; i < a.length; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	private static void maxSumSubArray(int[] arr) {
		int currentStart = 0;
		int currentEnd = 0;
		int currentSum = 0;
		int maxStart = 0;
		int maxEnd = 0;
		int maxSum = 0;
		while (currentEnd != arr.length) {
			currentSum += arr[currentEnd];
			System.out.println(" currentSum ::"+currentSum+" maxSum ::"+maxSum);
			if (currentSum > maxSum) {
				maxSum = currentSum;
				maxStart = currentStart;
				maxEnd = currentEnd;
				System.out.println("currentSum > maxSum so maxSum ::"+maxSum+" maxStart ::"+maxStart+" maxEnd ::"+maxEnd);
			}
			if (currentSum <= 0) {
				currentStart = currentEnd + 1;
				currentSum = 0;
				System.out.println(" currentSum <= 0 so currentStart ::"+currentStart+" and currentSum = 0");
			}
			currentEnd++;
			System.out.println(" incrementing  currentEnd as ::"+currentEnd);
		}
		System.out.println("Maximum sum = " + maxSum);
		System.out.println("Indexes (" + maxStart + "," + maxEnd + ")");
	}
}
