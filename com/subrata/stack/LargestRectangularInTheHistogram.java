package com.subrata.stack;

import java.util.Stack;

/**
 * 
 * @author Subrata Saha.
 *
 */
public class LargestRectangularInTheHistogram {

	// The main function to find the maximum rectangular area under given
	// histogram with n bars
	static int getMaxArea() {

		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		int n = hist.length;

		// Create an empty stack. The stack holds indexes of hist[] array
		// The bars stored in stack are always in increasing order of their
		// heights.
		Stack<Integer> s = new Stack<>();

		int max_area = 0; // Initalize max area
		int tp; // To store top of stack
		int area_with_top; // To store area with top bar as the smallest bar

		// Run through all bars of given histogram
		int i = 0;
		while (i < n) {
			// If this bar is higher than the bar on top stack, push it to stack
			System.out.println("****** 0.1 -> empty :: "+s.empty());
			if (s.empty() || hist[s.peek()] <= hist[i]){
				s.push(i++);
				System.out.println("****** 1 -> push -> "+s.toString());
			}

			// If this bar is lower than top of stack, then calculate area of
			// rectangle
			// with stack top as the smallest (or minimum height) bar. 'i' is
			// 'right index' for the top and element before top in stack is
			// 'left index'
			else {
				tp = s.peek(); // store the top index
				s.pop(); // pop the top
                System.out.println("****** 2 -> pop out and tp ::"+tp);
				// Calculate the area with hist[tp] stack as smallest bar
                if(s.empty()){
                	System.out.println("****** 3 -> empty , so i::"+i);
                }else {
                	System.out.println("****** 4 -> stack is ::"+s.toString());
                	System.out.println("****** 5 -> not empty ::"+(i-s.peek()-1));
                }
                
                
				area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

				// update max area, if needed
				if (max_area < area_with_top){
					System.out.println("****** 6 -> max_area ::"+max_area+" area_with_top ::"+area_with_top);
					max_area = area_with_top;
				}else{
					System.out.println("****** 7 -> max_area ::"+max_area+" area_with_top ::"+area_with_top);
				}
			}
			System.out.println("************************** Subrata -> ******************** finished ::"+i);
		}
		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (s.empty() == false) {
			tp = s.peek();
			s.pop();
			System.out.println("****** Subrata -> area tp ::"+tp);
			area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}
		System.out.println("****** Subrata -> Max area ::" + max_area);
		return max_area;
	}
	
	public static void main(String[] args) {
		getMaxArea();
	}
}
