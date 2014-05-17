package com.subrata.tree.core;


/**
 * Operation on BTree.
 * @author Subrata
 *
 * @param <T>
 */
public interface ITree<T> {
	
	public void addNode(T value);
	
	default void preOrder(TNode<T> node) {

		if (node == null) {
			return;
		}

		System.out.println("***************** pre order value is ::" + node.getValue());
		preOrder(node.leftNode);
		preOrder(node.rightNode);
	}

	default void postOrder(TNode<T> node) {

		if (node == null) {
			return;
		}

		
		postOrder(node.leftNode);
		postOrder(node.rightNode);
		System.out.println("***************** post order value is ::" + node.getValue());
	}

	default void inOrder(TNode<T> node) {

		if (node == null) {
			return;
		}

		inOrder(node.leftNode);
		System.out.println("***************** Inorder value is ::" + node.getValue());
		inOrder(node.rightNode);
	}
}
