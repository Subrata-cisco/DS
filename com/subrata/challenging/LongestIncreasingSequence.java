package com.subrata.challenging;
/**
 * Fundamental :
 * @author Subrata Saha.
 *
 */
public class LongestIncreasingSequence {

	
	//static int[] lis = null;
	//static int[] is = null;
	
	private static int[] findLis(int[] arr) {
		int[]  is = new int[arr.length];
		int index = 0;
		is[0] = index;
		print();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[is[index]]) {
				for (int j = 0; j <= index; j++) {
					if (arr[i] < arr[is[j]]) {
						is[j] = i;
						print();
						break;
					}
				}
			} else if (arr[i] == arr[is[index]]) {

			} else {
				
				is[++index] = i;
				print();
			}
		}
		System.out.println("****** Subrata -> index ::"+index);
		print();
		
		int[] lis = new int[index + 1];
		lis[index] = arr[is[index]];

		for (int i = index - 1; i >= 0; i--) {
			//System.out.println("*************** Subrata[default] i ::" + i + " is[i] ::"
					//+ is[i] + " is[i + 1] ::" + is[i + 1]);
			if (is[i] < is[i + 1]) {
				lis[i] = arr[is[i]];
				System.out.println("*************** Subrata[<]  "
						+ "lis["+i+"] ::" + lis[i] + " is["+i+"] ::" + is[i]
						+ " arr["+is[i]+"] ::" + arr[is[i]]);
				print();
			} else {
				for (int j = is[i + 1] - 1; j >= 0; j--) {
					if (arr[j] > arr[is[i]] && arr[j] < arr[is[i + 1]]) {
						lis[i] = arr[j];
						is[i] = j;
						System.out.println("****** Subrata -> >> lis["+i+"] = "+arr[j]+"   and is["+i+"] = "+j);
						print();
						break;
					}
				}
			}
		}
		
		print();
		return lis;
	}
	
	static void print(){
//		StringBuilder sb1 = new StringBuilder();
//		StringBuilder sb2 = new StringBuilder();
//		
//		if(is == null){
//			return;
//		}
//		
//		for(int k : is){
//			sb1.append(k).append(",");
//		}
//		
//		if(lis == null){
//			return;
//		}
//		
//		for(int k : lis){
//			sb2.append(k).append(",");
//		}
//		System.out.println("*************** Subrata is ::"+sb1.toString()+ " lis is ::"+sb2.toString());
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
