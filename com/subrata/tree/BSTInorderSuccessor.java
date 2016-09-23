package com.subrata.tree;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BSTInorderSuccessor<T extends Comparable<T>> extends BinarySearchTree<T> {

	TNode<T> inOrderSuccessor(TNode<T> root, TNode<T> n) {

		// step 1 of the above algorithm
		if (n.getRightNode() != null) {
			return minValue(n.getRightNode());
		}

		// step 2 of the above algorithm
		TNode<T> p = n.getParenNode();
		while (p != null && n == p.getRightNode()) {
			n = p;
			p = p.getParenNode();
		}
		return p;
	}

	/*
	 * Given a non-empty binary search tree, return the minimum data value found
	 * in that tree. Note that the entire tree does not need to be searched.
	 */
	TNode<T> minValue(TNode<T> node) {
		TNode<T> current = node;

		/* loop down to find the leftmost leaf */
		while (current.getLeftNode() != null) {
			current = current.getLeftNode();
		}
		return current;
	}

	public static void main(String[] args) {
		BSTInorderSuccessor<Integer> obj = new BSTInorderSuccessor<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		//obj.addNode(1);

		TNode<Integer> temp = obj.root.getRightNode();
		TNode<Integer> node = obj.inOrderSuccessor(obj.root, temp);
		if(node != null){
			System.out.println("Successor of "+temp.getValue()+" is ::"+node.getValue());
		}
	}
}
