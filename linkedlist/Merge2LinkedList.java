package linkedlist;

public class Merge2LinkedList extends SLL<Integer> {

	public void merge2List(SLL list1, SLL list2) {
		Node<Integer> head1 = list1.head;
		Node<Integer> head2 = list2.head;
	}

	Node<Integer> mergedHeadNode = null;

	private Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null && head2 != null) {
			return head2;
		}

		if (head2 == null && head1 != null) {
			return head1;
		}

		Node<Integer> temp = null;

		if (head1.item < head2.item) {
			
			if (mergedHeadNode == null) {
				mergedHeadNode = head1;
			}
			temp = head1.next;
			head1.next = head2;
			
		} else {
			
			if (mergedHeadNode == null) {
				mergedHeadNode = head2;
			}
			
		}

		return null;
	}

}
