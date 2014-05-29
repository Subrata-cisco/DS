package com.subrata.sorting;
/**
 * 
 * @author Subratas
 *
 */
public class MergeSort {

	/**
	 * 1) copy the entire array into a arry object.
	 * 2) partiation the 2 sorted arrays in the same array such that
	 *    hl= starting pointer of first sorted array.
	 *    hr= starting point of the second sorted array.
	 * 
	 * 
	 * @param array
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] array ,int low,int mid, int high){
		
		int leftPtr = low;
		int rightPtr = mid+1;
		int current = low;
		
		int[] resultantArray = new int[array.length];
		
		for(int i=low;i<=high;i++){
			resultantArray[i]=array[i];
		}
		
		// compare the common length elts from both the arrays and merge them.
		while(leftPtr<=mid && rightPtr<=high){
			if(resultantArray[leftPtr]<=resultantArray[rightPtr]){
				array[current] = resultantArray[leftPtr];
				leftPtr++;
			}else{
				array[current] = resultantArray[rightPtr];
				rightPtr++;
			}
			current++;
		}
		// copy only the left over from left side to the target array.
		// because the entire array is already copied in array , so right most things will always be there, no need to copy.
		int remaining = mid - leftPtr;
		for(int j=0;j<=remaining;j++){
			array[current+j] = resultantArray[leftPtr+j];
		}
		print(array);
	}
	
	public static void mergeSort(int[] array,int low, int high){
		if(low < high){
			int mid = (low+high)/2;
			mergeSort(array,low,mid);
			mergeSort(array,mid+1,high);
			merge(array,low,mid,high);
		}
	}

	public static void main(String[] args) {
		int[] array = {1,4,7,8,9,2};//,5,6,7,10,12,18};
		mergeSort(array,0,array.length-1);
		print(array);
		
		//int[] array = {1,2,3,4,5,6,7,8};
		//merge(array, 0, 4, array.length-1);
	}

	private static void print(int[] c){
		StringBuilder sb= new StringBuilder();
		for(int number : c){
			sb.append("->"+number);
		}
		System.out.println("Print ::"+sb.toString());

	}
}
