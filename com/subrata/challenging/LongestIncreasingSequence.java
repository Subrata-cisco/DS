package com.subrata.challenging;

public class LongestIncreasingSequence {

	private static int[] findLis(int[] arr) {
		int[] is = new int[arr.length];
		int index = 0;
		is[0] = index;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[is[index]]) {
				for (int j = 0; j <= index; j++) {
					if (arr[i] < arr[is[j]]) {
						is[j] = i;
						break;
					}
				}
			} else if (arr[i] == arr[is[index]]) {

			} else {
				is[++index] = i;
			}
		}
		
		for(int k : is){
			System.out.println("*************** Subrata k ::"+k+" index ::"+index);
		}

		int[] lis = new int[index + 1];
		lis[index] = arr[is[index]];

		for (int i = index - 1; i >= 0; i--) {
			System.out.println("*************** Subrata[1] i ::" + i + " is[i] ::"
					+ is[i] + " is[i + 1] ::" + is[i + 1]);
			if (is[i] < is[i + 1]) {
				System.out.println("*************** Subrata[2] i:: " + i
						+ "lis[i] ::" + lis[i] + " is[i] ::" + is[i]
						+ " arr[is[i]] ::" + arr[is[i]]);

				lis[i] = arr[is[i]];
			} else {
				for (int j = is[i + 1] - 1; j >= 0; j--) {
					if (arr[j] > arr[is[i]] && arr[j] < arr[is[i + 1]]) {
						lis[i] = arr[j];
						is[i] = j;
						break;
					}
				}
			}
		}
		
		//for(int k : lis){
			//System.out.println("*************** Subrata lis ::"+k);
		//}

		return lis;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 8, 4, 12, 2};//, 10, 6, 14, 1, 9, 5, 13, 3, 11,7, 15 };
		for (int i : findLis(arr)) {
			System.out.print(i + "-");
		}
		System.out.println();

		/*arr = new int[] { 1, 9, 3, 8, 11, 4, 5, 6, 4, 19, 7, 1, 7 };
		for (int i : findLis(arr)) {
			System.out.print(i + "-");
		}
		System.out.println();*/
	}
}
