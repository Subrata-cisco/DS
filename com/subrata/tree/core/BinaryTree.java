package com.subrata.tree.core;


/**
 * Idea : No need to check if lesser than left or else right side etc. Keep
 * filling the new nodes in each level.
 * 
 * Simple implementation to understand the concept, i am sure you will be able
 * to generalize for any data type.
 * 
 * @author Subrata
 * 
 */
public class BinaryTree<T> implements ITree<T> {
	// this is root node.
	protected TNode<T> root = null;
	protected TNode<T> levelNode = null;
	int size;

	public void addNode(T value) {
		TNode<T> newNode = new TNode<T>(value);
		if (root == null) {
			root = newNode;
			levelNode = newNode;
		} else {
			if (levelNode.leftNode == null) {
				levelNode.leftNode = newNode;
			} else {
				levelNode.rightNode = newNode;
				levelNode = levelNode.leftNode;
			}
		}
		size++;
	}
}
