package com.subrata.tree;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Make a mirror tree in a non recursive way.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTMirrorTreeNonRecursive<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	
	public void mirrorTreeNR(TNode<T> root) {
		Stack<TNode<T>> stack = new Stack<>();
		stack.push(root);

		TNode<T> current = null;
		TNode<T> temp = null;

		while (!stack.isEmpty()) {
			current = stack.pop();
			temp = current.getLeftNode();
			current.setLeftNode(current.getRightNode());
			current.setRightNode(temp);

			if (current.getLeftNode() != null)
				stack.push(current.getLeftNode());
			if (current.getRightNode() != null)
				stack.push(current.getRightNode());
		}
		return;
	}
}
