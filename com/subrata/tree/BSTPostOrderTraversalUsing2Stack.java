package com.subrata.tree;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Post order traversal using two stack.
 * Fundamental : First stack shall push the nodes and second stack is printing.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTPostOrderTraversalUsing2Stack<T extends Comparable<T>> extends
		BinarySearchTree<T> {
	
	
	public void postOrderUsingTwoStack(TNode<T> root) {
		if (root == null)
			return;
		Stack<TNode<T>> childStack = new Stack<>();
		Stack<TNode<T>> nodeStack = new Stack<>();
		childStack.add(root);
		while (!childStack.isEmpty()) {
			root = childStack.pop();
			if (root.getLeftNode() != null)
				childStack.push(root.getLeftNode());
			if (root.getRightNode() != null)
				childStack.push(root.getRightNode());
			nodeStack.push(root);
		}
		while (!nodeStack.isEmpty())
			System.out.print(nodeStack.pop().getValue() + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		BSTPostOrderTraversalUsing2Stack<Integer> obj = new BSTPostOrderTraversalUsing2Stack<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		
		obj.postOrder(obj.root);
		
		obj.postOrderUsingTwoStack(obj.root);
	}
}
