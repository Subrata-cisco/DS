package com.subrata.linkedlist;

public class SLLZeroOneTwoArrange extends SLL<Integer> {

	public void sortIt() {
		int count[] = { 0, 0, 0 }; // Initialize count of '0', '1' and '2' as 0
		Node current = head;

		/*
		 * count total number of '0', '1' and '2' count[0] will store total
		 * number of '0's count[1] will store total number of '1's count[2] will
		 * store total number of '2's
		 */
		while (current != null) {
			Integer i = ((Integer) current.item);
			count[i.intValue()] += 1;
			current = current.next;
		}

		int i = 0;
		current = head;

		/*
		 * Let say count[0] = n1, count[1] = n2 and count[2] = n3 now start
		 * traversing list from head node, 1) fill the list with 0, till n1 > 0
		 * 2) fill the list with 1, till n2 > 0 3) fill the list with 2, till n3
		 * > 0
		 */
		while (current != null) {
			if (count[i] == 0) {
				++i;
			} else {
				current.item = i;
				--count[i];
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		SLLZeroOneTwoArrange sll = new SLLZeroOneTwoArrange();
		sll.createAll012List();
		sll.printList();
		sll.sortIt();
		sll.printList();
	}

}
