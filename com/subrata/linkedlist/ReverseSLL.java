package com.subrata.linkedlist;

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
	   Node<T> temp = head;	
	   Node<T> prev = null;
	   Node<T> next = null;
	   while(temp != null){
		   next = temp.next;
		   temp.next = prev;
		   prev = temp;
		   head = temp;
		   temp = next;
	   }
	}
	
	public static void main(String[] args) {
		ReverseSLL<Integer> sll = new ReverseSLL<Integer>();
		sll.createList();
		sll.printList();
		sll.reverseSLL();
		sll.printList();
	}

}
