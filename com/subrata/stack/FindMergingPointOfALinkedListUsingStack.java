package com.subrata.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 *   6->9->3->
 *            | ->1->9
 *         2->   
 *   
 *   So we have linked list 6,9,3,1,9 and 2,1,9 having merge point as 1 , we have solve it using Stack.
 *   Lets assume that the 2 linked has unique data and same data mens it is merging point to keep it simple.
 *   
 *   The program looks dirty but concept is right. TODO - Re factor the code.
 */
public class FindMergingPointOfALinkedListUsingStack<T extends Comparable<T>> {
	
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		
		list.add(6);
		list.add(9);
		list.add(3);
		list.add(1);
		list.add(9);
		
		list2.add(2);
		list2.add(1);
		list2.add(9);
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			s1.push(it.next());
		}
		
		it = list2.iterator();
		while(it.hasNext()){
			s2.push(it.next());
		}
		
		int mergeDataPoint = -1;
		int data1 = -1;
		int data2 =-1;
	
		while(!s1.isEmpty() || !s2.isEmpty()){
			
			if(!s1.isEmpty()) data1 = s1.pop();
			
			if(!s2.isEmpty()) data2 = s2.pop();
			
			if(data1 != data2 && (data1 != -1 || data2!= -1)){
				break;
			}else{
				mergeDataPoint = data1;
			}
		}
		
		System.out.println("****** Subrata -> Merge point ::"+mergeDataPoint);
	}

}
