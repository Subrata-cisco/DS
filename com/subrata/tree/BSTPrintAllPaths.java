package com.subrata.tree;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BSTPrintAllPaths<T extends Comparable<T>> extends BinarySearchTree<T> {

	/**
	 * Starting from root.
	 */
	public void printAllPaths(TNode<T> start, Stack<TNode<T>> stack) {

		if (start == null) {
			return;
		}

		stack.push(start);

		if (isLeaf(start)) {
			for (int i = 0; i < stack.size(); i++) {
				System.out.println(stack.elementAt(i));
			}
		} else {
			printAllPaths(start.getLeftNode(), stack);
			printAllPaths(start.getRightNode(), stack);
		}
		
		stack.pop();
	}

	private boolean isLeaf(TNode<T> start) {
		return start.getLeftNode() == null && start.getRightNode() == null;
	}

	public static void main(String[] args) {
		BSTPrintAllPaths<Integer> obj = new BSTPrintAllPaths<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		Stack<TNode<Integer>> stack = new Stack<>();
		obj.printAllPaths(obj.root, stack);
	}
}
