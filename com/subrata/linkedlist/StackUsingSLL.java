package com.subrata.linkedlist;

import com.subrata.linkedlist.intf.IStack;



public class StackUsingSLL<T> extends SLL<T> implements IStack<T> {

	public void pop() {
		remove(true);
	}

	public void push(T item) {
		add(item, true);
	}

	public static void main(String[] args) {
		StackUsingSLL<Integer> sll = new StackUsingSLL<Integer>();
		sll.createList();
		sll.printList();
		sll.push(7);
		sll.push(8);
		sll.push(9);
		sll.printList();
		sll.pop();
		sll.pop();
		sll.pop();
		sll.printList();
	}

}
