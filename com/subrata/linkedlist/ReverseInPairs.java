package com.subrata.linkedlist;

public class ReverseInPairs<T> extends SLL<T> {

	public Node<T> reverseInPairsSLL(Node<T> headd, int no ){
		Node<T> current = headd;
		Node<T> prev = null;
		Node<T> next = null;
		int count = 0;
		
		while(current != null && count < no){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(next != null){
			headd.next = reverseInPairsSLL(next,no);
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
