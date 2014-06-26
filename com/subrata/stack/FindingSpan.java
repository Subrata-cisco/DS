package com.subrata.stack;

import java.util.Stack;

public class FindingSpan {

	public static void printSpan(){
		int[] a = {6,3,4,5,2};
		int[] s = new int[5];
		int j;
		for(int i =0;i<5;i++){
			j=1;
			while(j<=i && a[i]>a[i-j]){
				j++;
			}
			s[i]=j;
		}
		for(int i =0;i<5;i++){
			System.out.println(s[i]);
		}
		
	}
	
	static void calculateSpan() {
		
		int[] price = {100,80,60,70,60,75,85};//{6,3,4,5,2};
		int[] S = new int[price.length];
		int n = price.length;

		
		// Create a stack and push index of first element to it
		Stack<Integer> st = new Stack<>();
		st.push(0);

		// Span value of first element is always 1
		S[0] = 1;

		// Calculate span values for rest of the elements
		for (int i = 1; i < n; i++) {
			System.out.println("****** Subrata -> i ::"+i+" price["+i+"] ::"+price[i]);
			// Pop elements from stack while stack is not empty and top of
			// stack is smaller than price[i]
			while (!st.empty() && price[st.peek()] < price[i]){
				//System.out.println("****** Subrata -> stack ::"+st.toString());
				st.pop();
				//System.out.println("****** Subrata -> aftre pop ::"+st.toString());
			}
				

			// If stack becomes empty, then price[i] is greater than all
			// elements
			// on left of it, i.e., price[0], price[1],..price[i-1]. Else
			// price[i]
			// is greater than elements after top of stack
			S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
			//System.out.println("****** Subrata -> peek >>"+st.peek()+" i+1 ::"+(i+1)+" i-st.peek ::"+(i-st.peek()) +" S ::"+S[i]);

			
			// Push this element to stack
			st.push(i);
			System.out.println("****** Subrata -> push ::"+st.toString());
		}
		for (int i = 0; i < n; i++) {
			System.out.println("****** Subrata -> ITEM :: "+S[i]);
		}
		//Arrays.asList(S).stream().forEach(System.out::println);
	}
	
	
	
	public static void main(String[] args) {
		printSpan();
		//calculateSpan();
	}
}
