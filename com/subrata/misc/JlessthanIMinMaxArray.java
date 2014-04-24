package com.subrata.misc;

import java.util.Stack;

/**
given an array A[0-n], find the combination of A[i] and A[j] such that 
1) A[j] - A[i] is max 
2) A[j] > A[i] 
and 
3) j > i 
please suggest a better solution than n-square.
 * @author subratas
 *
 */
public class JlessthanIMinMaxArray {

	
	public static void main(String[] args) {
		int [] arr = {20,19,18,17,16,16,16,30,17,25,20};
		findMaxMin(arr);
	}

	
	/**
	  Go through the array from the beginning, for each step pushing the current minimum onto the stack. Then go through the array from the back, at each step checking the current value minus the minimum value, and popping off the stack as you go towards the first element. If the current value minus the minimum is positive and the largest value so far, store it as the max. 
		O(N) for generating the minimum stack and O(N) for array traversal so O(N) all up.
		
		It is always better to explain using dryruns:
		 {20,19,18,17,16,16,16,30,17,25,20};
		a. start traversing from 0 to rightmost index and put the minimum found til now in stack.So we put numbers in the stack as below:
		topmost bottomost
		16 16 16 16 16 16 16 17 18 19 20
		so 16 is the least.
		b.Start traversing from rightmost to leftmost in the array and subtract the array element with topmost element of the stack at each step as below:
		20 - 16 = 4
		25 - 16 = 9  
		-
		-
		30-16 = 14
		-
		
		-
		-
		20 - 20 = 0
		so greatest is 14 and we have the answer.
		
	 @param arr
	 */
	public static void findMaxMin(int [] arr)
	{
		Stack <Integer> minStack = new Stack();
		Stack <Integer> minAt= new Stack();
		int curMin = Integer.MAX_VALUE;
		int curMinAt = -1;
		for(int i = 0; i < arr.length-1; i++)
		{
			if(arr[i] < curMin)
			{
				curMin = arr[i];
				curMinAt = i;
			}
			minStack.push(curMin);
			minAt.push(curMinAt);
		}
		
		int curMaxSum = Integer.MIN_VALUE;
		int curMaxAt = -1;
		
		for(int i = arr.length-1; i >= 1; i--)
		{
			if(arr[i] - minStack.peek() > curMaxSum)
			{
				curMaxSum = arr[i] - minStack.peek();
				curMaxAt = i;
				curMinAt = minAt.peek();
			}
			minStack.pop();
			minAt.pop();
		}
		
		if(curMaxAt != -1)
			System.out.println("Max: " + curMaxSum + " from " + arr[curMaxAt] + " - " + arr[curMinAt]);
		else
			System.out.println("No max");
	}

}
