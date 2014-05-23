package com.subrata.tree.core;

import java.util.LinkedList;
import java.util.Queue;


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
	Queue<TNode<T>> nodesToBeFilled = null;

	public void addNode(T value) {
		TNode<T> newNode = new TNode<T>(value);
		if (root == null) {
			root = newNode;
			//System.out.println("****** Subrata -> root ::"+root.getValue());
			levelNode = newNode;
			nodesToBeFilled = new LinkedList<>();
		} else {
			if (levelNode.leftNode == null) {
				levelNode.leftNode = newNode;
				nodesToBeFilled.offer(newNode);
				//System.out.println("****** Subrata -> "+levelNode.getValue()+" left child is ::"+newNode.getValue());
			} else if(levelNode.rightNode == null) {
				levelNode.rightNode = newNode;
				//System.out.println("****** Subrata -> "+levelNode.getValue()+" right child is ::"+newNode.getValue());
				nodesToBeFilled.offer(newNode);;
			} else if (levelNode.leftNode != null && levelNode.rightNode != null){
				levelNode = nodesToBeFilled.poll();
				//System.out.println("****** Subrata -> "+levelNode.getValue()+ " left and right is full ,so pointer is ::"+levelNode.getValue());
				addNode(value);
			}
		}
		size++;
	}
}
