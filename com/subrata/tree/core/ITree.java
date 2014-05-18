package com.subrata.tree.core;

import java.util.LinkedList;
import java.util.Queue;


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
	
	default void levelOrder(TNode<T> node){
		
		if(node == null){
			return;
		}
		
		TNode<T> temp=node;
		Queue<TNode<T>> queue = new LinkedList<TNode<T>>();
		StringBuilder sb = new StringBuilder();
		
		while(temp != null){
			sb.append(temp.getValue()).append("->");
			
			if(temp.getLeftNode() != null){
				queue.offer(temp.getLeftNode());
			}
			
			if(temp.getRightNode() != null){
				queue.offer(temp.getRightNode());
			}
			
			temp = queue.poll();
		}
		
		System.out.println("*****************Subrata val ::"+sb.toString());

	}
}
