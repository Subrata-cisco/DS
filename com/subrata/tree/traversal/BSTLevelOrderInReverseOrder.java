package com.subrata.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

/**
 * Printing the item by lever order butin reverse direction.
 * 
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTLevelOrderInReverseOrder<T extends Comparable<T>> extends BinarySearchTree<T> {

	public void printInReverseOrder(TNode<T> node) {
		if (node == null) {
			return;
		}

		TNode<T> temp = node;
		Stack<T> stack = new Stack<>();
		Queue<TNode<T>> queue = new LinkedList<>();

		while (temp != null) {
			stack.push(temp.getValue());

			if (temp.getLeftNode() != null) {
				queue.offer(temp.getLeftNode());
			}

			if (temp.getRightNode() != null) {
				queue.offer(temp.getRightNode());
			}

			temp = queue.poll();
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.append(stack.pop()).append("->");
		}

		System.out.println("****** Subrata -> Level order traversal in reverse order ::" + sb.toString());
	}

	public static void main(String[] args) {
		BSTLevelOrderInReverseOrder<Integer> obj = new BSTLevelOrderInReverseOrder<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);

		obj.levelOrder(obj.root);

		obj.printInReverseOrder(obj.root);

	}
}
