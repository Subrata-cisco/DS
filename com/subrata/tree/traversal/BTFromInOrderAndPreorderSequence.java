package com.subrata.tree.traversal;

import com.subrata.tree.core.TNode;

public class BTFromInOrderAndPreorderSequence {
	
	static int index = 0;

	private TNode<Integer> buildTree(int[] in, int[] pre, int start, int end) {
		if (start > end) {
			return null;
		}

		TNode<Integer> node = new TNode<>(pre[index++]);
		if (start == end)
			return node;

		int indexInInOrderArray = search(in, start,end, node.getValue());

		node.setLeftNode(buildTree(in, pre, start, indexInInOrderArray - 1));
		node.setRightNode(buildTree(in, pre, indexInInOrderArray + 1, end)); 

		return node;
	}

	// can implement binary search to improve the performance.
	private int search(int[] inOrder,int start,int end, Integer value) {
		int returnIndex = 0;
		for (int i = start; i <= end; i++) {
			if (value.equals(inOrder[i])) {
				returnIndex = i;
				break;
			}
		}
		return returnIndex;
	}

	void printInorder(TNode<Integer> node) {
		if (node == null)
			return;
		printInorder(node.getLeftNode());
		System.out.print(node.getValue() + " ");
		printInorder(node.getRightNode());
	}
	
	public static void main(String[] args) {
		BTFromInOrderAndPreorderSequence tree = new BTFromInOrderAndPreorderSequence();
		int in[] = new int[] { 15, 30, 35, 40, 45, 50, 60, 70, 72, 75, 77, 80 };
		int pre[] = new int[] { 50, 30, 15, 40, 35, 45, 70, 60, 80, 75, 72, 77 };
		int len = in.length;
		TNode<Integer> root = tree.buildTree(in, pre, 0, len - 1);

		tree.printInorder(root);
	}
}
