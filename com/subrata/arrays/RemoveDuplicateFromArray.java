package com.subrata.arrays;

import com.subrata.sorting.MergeSortUtility;

/**
 * Remove the duplicate element from array.
 * Idea : Sort the array , remove the duplicate with -99 , push all the elements to the left, make all the right side element as -1.
 * @author Subrata Saha.
 *
 */
public class RemoveDuplicateFromArray {

	private static int INVALID = -999;
	
	public static void main(String[] args) {
		int array[] = {1,2,3,3,9,1,2,4,8};
		
		MergeSortUtility.mergeSort(array, 0, array.length -1);
		MergeSortUtility.print(array);
		
		for(int i=0;i<array.length-1;i++){
			if(array[i] == array[i+1]){
				array[i+1] = INVALID;
			}
		}
		
		
		int pointer = -1;
		for(int i=0;i<array.length;i++){
			if(array[i] == INVALID && pointer == -1){
				pointer = i;
			}else{
				if(pointer != -1 && array[i] != INVALID){
					array[pointer] = array[i];
					pointer = pointer+1;
				}
				
				// last iteration remove the extra space. i.e compacting.
				if(i == (array.length -1)){
					while(pointer != (array.length)){
						array[pointer] = -1;
						pointer +=1 ;
					}
				}
			}
		}
		
		MergeSortUtility.print(array);
	}
}
