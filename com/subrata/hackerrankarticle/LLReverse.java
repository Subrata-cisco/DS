package com.subrata.hackerrankarticle;

public class LLReverse {
	class Node {
		int data;
		Node next;
	}

	Node Reverse(Node head) {
		Node temp = head;
		Node prev = null;
		Node next = null;
		
		while(temp != null){
			next = temp.next;
			temp.next = prev;
			prev = temp;
			head = temp;
			temp = next; 
		}
		
		return head;
    }
	
	void ReversePrint(Node head) {
		  Node temp = head;
		  Node prev = null;
		  Node next = null;

		  while(temp != null){
		      next = temp.next;
		      temp.next = prev;
		      prev = temp;
		      head = temp;
		      temp = next; 
		  }
		    
		  temp = head;
		  while(temp != null){ 
		     System.out.println(temp.data);
		     temp = temp.next;
		  }
		    
		}
}
