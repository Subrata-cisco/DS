package com.subrata.linkedlist;

import java.util.NoSuchElementException;

import com.subrata.linkedlist.intf.IList;

/**
 * Linked list impl.
 * 
 * @author subratas
 * 
 * @param <T>
 */

public class SLL<T> implements IList<T> {

	protected Node<T> head;
	protected Node<T> tail;

	protected class Node<K> {
		T item;
		Node<T> next;

		Node(T value) {
			item = value;
		}
	}

	public void add(T item) {
		add(item, false);
	}

	public void add(T item, boolean beginning) {
		// first element to be inserted.
		if (head == null) {
			Node<T> node = new Node<T>(item);
			head = node;
			tail = node;
		} else {
			// insert node in the SLL
			insertNodeInTheSLL(item, beginning);
		}
	}

	private void insertNodeInTheSLL(T item, boolean addInHead) {
		Node<T> node = new Node<T>(item);
		if (addInHead) {
			// add at the beginning.
			node.next = head;
			tail = head;
			head = node;
		} else {
			// add at the last.
			tail.next = node;
			tail = node;
		}
	}

	public void remove() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		remove(false);
	}

	public void remove(boolean fromBeginning) {
		// if only one element is there.
		if (head.next == null) {
			System.out.println(" Item removed is[1] ::" + head.item);
			head = null;
			tail = null;
			return;
		}

		if (fromBeginning) {
			System.out.println(" Item removed is[2] ::" + head.item);
			// if only 2 element is there and we are deleting the head
			head = head.next;
		} else {
			System.out.println(" Item removed is[3] ::" + tail.item);
			Node<T> temp = head;
			while (temp.next != tail) {
				temp = temp.next;
			}
			tail = temp;
			tail.next = null;
		}
	}
	
	
	public void createAll012List(){
		add((T)new Integer(0));
		add((T)new Integer(2));
		add((T)new Integer(2));
		add((T)new Integer(1));
		add((T)new Integer(1));
		add((T)new Integer(1));
		add((T)new Integer(0));
		add((T)new Integer(0));
		add((T)new Integer(2));
	} 
	
	public void createList(){
		add((T)new Integer(1));
		add((T)new Integer(2));
		add((T)new Integer(3));
		add((T)new Integer(4));
		add((T)new Integer(5));
		add((T)new Integer(6));
		add((T)new Integer(7));
		add((T)new Integer(8));
		add((T)new Integer(9));
	}

	
	
	public void destroyList(){
		for(int i=0;i<10;i++)
			remove();
	}
	
	public void printList() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.print(temp.item + "->");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SLL<Integer> sll = new SLL<Integer>();
		
		/*sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		sll.add(5);
		sll.add(6);
		sll.add(7);
		sll.add(8);
		sll.add(9);
		sll.add(10);*/
		
		sll.printList();
		sll.destroyList();
	}
}
