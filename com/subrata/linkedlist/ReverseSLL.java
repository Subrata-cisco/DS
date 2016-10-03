package com.subrata.linkedlist;

import com.subrata.linkedlist.SLL.Node;

/**
 * a. iterate until temp is not null : temp is nothing but starting from head.
 * b. keep 2 pointer prev,next
 * c. next will be temp.link
 * d. temp.link = prev  [the directiion is reversed here]
 * e. prev/head will be your current node which is temp
 * f. advance to next pointer which becomes new temp.
 * 
 * @author subratas
 *
 * @param <T>
 */
public class ReverseSLL<T> extends SLL<T> {
  
	public void reverseSLL(){
	   Node<T> current = head;	
	   Node<T> prev = null;
	   Node<T> next = null;
	   while(current != null){
		   next = current.next;
		   current.next = prev;
		   prev = current;
		   head = current;
		   current = next;
	   }
	}
	
	public Node<T> reverseBetween(Node<T> head, int m, int n) {
		Node<T> current = head;	
		Node<T> prev = null;
		
		int count = 1;
		while(count < m){
			prev = current;
			current = current.next;
			count++;
		}
		
		prev.next = reverseUpTo(current,n-m+1);
		
		return head;
	}
	
	private Node<T> reverseUpTo(Node<T> head, int i) { 
		Node<T> current = head, newHead=null,temp=null;
		for (int k = 0; k < i; k++) {
           temp = current;
           current = current.next;
           temp.next = newHead;
           newHead = temp;
		}
		head.next = current;
		return newHead;
	}

	public static void main(String[] args) {
		ReverseSLL<Integer> sll = new ReverseSLL<Integer>();
		sll.createList();
		sll.printList();
		sll.reverseBetween(sll.head, 2, 4);
		sll.printList();
	}

}
