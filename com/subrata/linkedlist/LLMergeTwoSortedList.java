package com.subrata.linkedlist;

public class LLMergeTwoSortedList extends SLL<Integer> {

	private Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null && head2 != null) {
			return head2;
		}

		if (head2 == null && head1 != null) {
			return head1;
		}

		Node<Integer> mergedHeadNode = null;

		if (head1.item <= head2.item) {
			mergedHeadNode = head1;
			mergedHeadNode.next = merge(head1.next, head2);
		} else {
			mergedHeadNode = head2;
			mergedHeadNode.next = merge(head1, head2.next);
		}
		
		return (mergedHeadNode);
	}
	
	private Node<Integer> merge2(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null && head2 != null) {
			return head2;
		}

		if (head2 == null && head1 != null) {
			return head1;
		}

		Node<Integer> mergedHeadNode = new Node<>(0) ;
		Node<Integer> p = mergedHeadNode ;

		while(head1 != null || head2 != null){
			if(head1 != null && head2 != null){
				if (head1.item < head2.item) {
					mergedHeadNode.next = head1;
					head1 = head1.next;
				} else {
					mergedHeadNode.next = head2;
					head2 = head2.next;
				}
				mergedHeadNode = mergedHeadNode.next;
			}else if(head1 == null){
				mergedHeadNode.next = head2;
				break;
			}else {
				mergedHeadNode.next = head1;
				break;
			}
		}
		return (p.next);
	}

	public static void main(String[] args) {
		LLMergeTwoSortedList list = new LLMergeTwoSortedList();
		list.add(3);
		list.add(4);
		list.add(10);
		list.add(12);

		list.printList();

		LLMergeTwoSortedList list2 = new LLMergeTwoSortedList();
		list2.add(4);
		list2.add(6);
		list2.add(9);

		list2.printList();

		Node<Integer> mergedHeadNode = list.merge2(list.head, list2.head);

		list.printList(mergedHeadNode);

	}

}
