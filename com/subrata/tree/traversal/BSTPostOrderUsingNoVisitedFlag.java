package com.subrata.tree.traversal;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Doing an Post order traversal with out using a flag.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTPostOrderUsingNoVisitedFlag<T extends Comparable<T>> extends
		BinarySearchTree<T> {
	
	public void postOrderNoflag(TNode<T> root) {
		Stack<TNode<T>> stack = new Stack<>();
		TNode<T> prev = null;
		TNode<T> curr = root;
		stack.push(root);
		while (!stack.isEmpty()) {
			while (curr != null) {
				if (curr.getLeftNode() != null) {
					curr = curr.getLeftNode();
					System.out.println("****** Subrata -> Pushing ::"+curr.getValue());
					stack.push(curr);
				} else {
					break; // break loop
				}
			}
			curr = stack.peek();
			System.out.println("****** Subrata -> Geeting peek ::"+curr.getValue());
			if (curr.getRightNode() != null && prev != curr.getRightNode()) {
				curr = curr.getRightNode();
				System.out.println("****** Subrata -> Pushing 2nd time ::"+curr.getValue());
				stack.push(curr);
			} else {
				stack.pop();
				System.out.println(curr.getValue());
				prev = curr;
				curr = null;
			}
		}
	}
	
	public static void main(String[] args) {
		BSTPostOrderUsingNoVisitedFlag<Integer> obj = new BSTPostOrderUsingNoVisitedFlag<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		
		//obj.inOrder(obj.root);
		
		obj.postOrderNoflag(obj.root);
	}

}
