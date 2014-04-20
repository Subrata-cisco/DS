package linkedlist;

import java.util.NoSuchElementException;

import linkedlist.intf.IList;


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

	protected class Node<T> {
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
		add((T)new Integer(2));
		add((T)new Integer(1));
		add((T)new Integer(2));
		add((T)new Integer(1));
		add((T)new Integer(1));
		add((T)new Integer(2));
		add((T)new Integer(0));
		add((T)new Integer(1));
		add((T)new Integer(0));
	}

	public void createList() {
		T number1 = (T) new Integer(1);
		T number2 = (T) new Integer(2);
		T number3 = (T) new Integer(3);
		T number4 = (T) new Integer(4);
		T number5 = (T) new Integer(5);
		T number6 = (T) new Integer(6);
		T number7 = (T) new Integer(7);
		T number8 = (T) new Integer(8);
		T number9 = (T) new Integer(9);
		T number10 = (T) new Integer(10);

		add(number1);
		add(number2);
		add(number3);
		add(number4);
		add(number5);
		add(number6);
		add(number7);
		add(number8);
		add(number9);
		add(number10);
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
		SLL sll = new SLL();
		sll.createList();
		sll.printList();
		sll.destroyList();
	}
}
