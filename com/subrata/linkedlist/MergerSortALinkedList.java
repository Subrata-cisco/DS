package com.subrata.linkedlist;

/*MergeSort(headRef)

 1) If head is NULL or there is only one element in the Linked List 
 then return.
 2) Else divide the linked list into two halves.  
 FrontBackSplit(head, &a, &b);  a and b are two halves 
 3) Sort the two halves a and b.
 MergeSort(a);
 MergeSort(b);
 4) Merge the sorted a and b (using SortedMerge() discussed here) 
 and update the head pointer using headRef.
 *headRef = SortedMerge(a, b);
 **/

public class MergerSortALinkedList extends SLL {

	void MergeSort(Node headRef) {
		Node current = headRef;

		Node a = null;
		Node b = null;

		if ((current == null) || (current.next == null)) {
			return;
		}

		FrontBackSplit(head, a, b);

		MergeSort(a);
		MergeSort(b);

		headRef = merge(a, b);
	}

	void FrontBackSplit(Node source, Node frontRef, Node backRef) {
		Node fast;
		Node slow;
		if (source == null || source.next == null) {
			/* length < 2 cases */
			frontRef = source;
			backRef = null;
		} else {
			slow = source;
			fast = source.next;

			/* Advance 'fast' two nodes, and advance 'slow' one node */
			while (fast != null) {
				fast = fast.next;
				if (fast != null) {
					slow = slow.next;
					fast = fast.next;
				}
			}

			/*
			 * 'slow' is before the midpoint in the list, so split it in two at
			 * that point.
			 */
			frontRef = source;
			backRef = slow.next;
			slow.next = null;
		}
	}

	Node merge(Node a, Node b) {
		Node result = null;

		/* Base cases */
		if (a == null)
			return (b);
		else if (b == null)
			return (a);

		/* Pick either a or b, and recur */

		if ((Integer) a.item <= (Integer) b.item) {
			result = a;
			result.next = merge(a.next, b);
		} else {
			result = b;
			result.next = merge(a, b.next);
		}
		return (result);
	}

	public void show() {
		createList();
		printList();
		MergeSort(head);
		printList();
	}

	public static void main(String[] args) {
		MergerSortALinkedList sll = new MergerSortALinkedList();
		sll.show();
	}

}
