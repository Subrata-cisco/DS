package com.subrata.linkedlist;

public class ReverseInPairs<T> extends SLL<T> {

	public Node<T> reverseInPairsSLL(Node<T> head, int no ){
		Node<T> temp = head;
		Node<T> prev = null;
		Node<T> next = null;
		int count = 0;
		
		while(temp != null && count < no){
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			count++;
		}
		
		if(next != null){
			head.next = reverseInPairsSLL(next,no);
		}
		
		return prev;
	}
	
	private void show(){
		createList();
		printList();
		head = reverseInPairsSLL(head,3);
		printList();
	}
	
	public static void main(String[] args) {
		ReverseInPairs<Integer> sll = new ReverseInPairs<Integer>();
		sll.show();
	}
}
