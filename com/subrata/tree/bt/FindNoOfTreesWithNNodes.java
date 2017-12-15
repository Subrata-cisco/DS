package com.subrata.tree.bt;

public class FindNoOfTreesWithNNodes {

	private int findtotalTrees(int n) {
		if (n <= 1)
			return 1;

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int l = findtotalTrees(i - 1);
			int r = findtotalTrees(n - i);
			sum += l * r;
		}

		return sum;
	}

	public static void main(String[] args) {
		FindNoOfTreesWithNNodes obj = new FindNoOfTreesWithNNodes();
		int total = obj.findtotalTrees(4);
		System.out.println(" total ::" + total);
	}
}
