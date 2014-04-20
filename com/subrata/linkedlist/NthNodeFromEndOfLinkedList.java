package com.subrata.linkedlist;

/**
 * Question : Find the nth node from the end of the linked list.
 * Solution :
 * 1) Brute force : Calculate the length of Linked List. Let the length be length,
 *    Print the ((len – n )+ 1)th node from the begining of the Linked List.
 * 2) Using Hashtable we can store the pointers according the positions.
 * 3) We can solve it one scan : using 2 pointer.
 * @author subratas
 *
 * @param <T>
 */
public class NthNodeFromEndOfLinkedList<T> extends SLL<T> { 
	
	/**
	 * Worst case = O(n) + O(n)
	 * @param n
	 */
	void printNthNode_1(int n){
		int count = 0;
		Node<T> temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		
		int nodeNumber = (count - n) + 1 ;
		
		if(nodeNumber <= 0){
			System.out.println("No Such node exist !!");
			return;
		}
		
		temp = head;
		count = 1 ;
		
		while(count != nodeNumber){
			temp = temp.next;
			count++;
		}
		
		System.out.println(" Node found as ::"+temp.item);
	}
	
	/**
	 * Worst case = O(n)
	 * @param n
	 */
	void printNthNode_2(int n){
		Node<T> first = null;
		Node<T> second = null;
		int i= 0;
		for(second = head ; second != null;){
			i++;
			
			if(i-n == 0){
				first = head;
				second = second.next;
				System.out.println(" Assigning first as head node !!");
			}else if(i-n < 0) {
				System.out.println(" As ("+i+" - "+n+") is ::"+(i-n)+" < 0 , so advancing second node !!");
				second = second.next;
			}else if (i-n > 0){
				System.out.println(" As ("+i+" - "+n+") is ::"+(i-n)+" > 0 , so advancing first and second node !!");
				first = first.next;
				second = second.next;
			}
		}

		if(first != null){
			System.out.println(" Node found as ::"+first.item);
		}else{
			System.out.println(" No such node exist !!");
		}
		
	}

	
	public static void main(String[] args) {
		NthNodeFromEndOfLinkedList<Integer> sll = new NthNodeFromEndOfLinkedList<Integer>();
		sll.createList();
		sll.printList();
		//sll.printNthNode_1(4);
		sll.printNthNode_2(3);
	}
	
}
