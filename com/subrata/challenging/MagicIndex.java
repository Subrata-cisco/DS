package com.subrata.challenging;


public class MagicIndex {

	static int a[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
	
	public static void main(String[] args) {
		
		System.out.println("*************** Subrata magicIndex :: "+findMagicIndex_sorted_unique(a,0,a.length));
	}
	
	/**
	 * Here because the items are not unique ,so the only optimization we can do is
	 * if(a[5] = x) then magic index can be there at a[0] to a[x] etc
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static int findMagicIndex_sorted_notunique(int array[],int start,int end){
		if(start < 0 || end > array.length || end < start){
			return -1;
		}
		int midIndex = (start + end)/2;
		int midValue = array[midIndex];
		
		if(midIndex == midValue){
			return midIndex;
		}

		// scan left
		int leftIndex = Math.min(midIndex-1, midValue);
		int left = findMagicIndex_sorted_notunique(array,start,leftIndex);
		if(left > 0){
			return left;
		}
		
		// scan right
		int rightIndex = Math.max(midIndex+1,midValue);
		int right = findMagicIndex_sorted_notunique(array,rightIndex,end);
		return right;
		
	}
	
	/**
	 * If the passes array is sorted and has all unique data then the following algo will work.
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static int findMagicIndex_sorted_unique(int array[],int start,int end){
		if(start < 0 || end > array.length || end < start){
			return -1;
		}
		
		int mid = (start + end)/2;
		
		if(array[mid] == mid){
			return mid;
		}else if(array[mid] < mid){
			return findMagicIndex_sorted_unique(array,mid+1,end);
		}else {
			return findMagicIndex_sorted_unique(array,start,mid-1);
		}
		
	}
	
	private int findMagicIndex_bruteForce(){
		int magicIndex = -1;
		for(int no=0;no<a.length;no++){
			if(a[no] == no){
				magicIndex = no;
				break;
			}
		}
		return magicIndex;
	}
	
}
