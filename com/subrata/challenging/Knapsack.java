package com.subrata.challenging;

public class Knapsack {
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0){
					System.out.println("i = "+i+"w ="+w+" => k["+i+"]["+w+"] = 0" );
					K[i][w] = 0;
				}
				else if (wt[i - 1] <= w){
					System.out.println("w[" + i + " - 1] i.e " + wt[i - 1]
							+ " <= " + w + " so find max " + "val[" + i
							+ " - 1] i.e -" + val[i - 1] + " k[" + i + " -1]["
							+ w + " - wt[" + i + "-1]] i.e -"
							+ K[i - 1][w - wt[i - 1]]);
					K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]],
							K[i - 1][w]);
					System.out.println("finally k["+i+"]["+w+"] = "+K[i][w]);
				}
				else {
					System.out.println("k["+i+"]["+w+"] :: k["+i+"-1]["+w+"] i.e ::"+K[i-1][w]);
					K[i][w] = K[i - 1][w];
				}
			}
		}

		return K[n][W];
	}

	public static void main(String[] args) {
		//int val[] = { 5, 3, 4 };
		//int wt[] = { 3, 2, 1 };
		
		int val[] = { 3,4,5,6 };
		int wt[] = { 2,3,4,5 };

		
		int W = 5;
		int n = 4;
		System.out.println(knapSack(W, wt, val, n));
	}
}
