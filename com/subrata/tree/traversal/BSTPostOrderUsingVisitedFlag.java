package com.subrata.tree.traversal;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Post order using visited flag.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTPostOrderUsingVisitedFlag<T extends Comparable<T>> extends
		BinarySearchTree<T> {
	
	public void postOrderNR(TNode<T> root) {
		Stack<TNode<T>> stack = new Stack<>();
		
		TNode<T> node = root;

		if (node != null)
			stack.push(node);

		while (!stack.isEmpty()) {
			node = stack.peek();
			if (node.getVisited()) {
				TNode<T> poppedNode = stack.pop();
				System.out.println("****** Subrata -> poppedNode ::"+poppedNode.getValue());
			} else {
				node.setVisited(true);
				if (node.getRightNode() != null) {
					stack.push(node.getRightNode());
				}
				if (node.getLeftNode() != null) {
					stack.push(node.getLeftNode());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BSTPostOrderUsingVisitedFlag<Integer> obj = new BSTPostOrderUsingVisitedFlag<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		
		
		obj.postOrderNR(obj.root);
	}
}
