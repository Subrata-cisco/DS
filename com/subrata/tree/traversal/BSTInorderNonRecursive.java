package com.subrata.tree.traversal;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * In order traversal in a non recursive way.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTInorderNonRecursive<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	public  void inOrderNR(TNode<T> root) {
		Stack<TNode<T>> stack = new Stack<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeftNode();
			} else {
				if (stack.empty())
					return;
				root = stack.pop();
				System.out.println(root.getValue());
				root = root.getRightNode();
			}
		}
	}
	
	
}
