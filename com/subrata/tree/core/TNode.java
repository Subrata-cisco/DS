package com.subrata.tree.core;
/**
 * Node class of the BTree
 * @author Subrata
 *
 * @param <T>
 */
public class TNode<T>  {
	T value;
	TNode<T> leftNode;
	TNode<T> rightNode;
	boolean visited;

	TNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public TNode<T> getLeftNode() {
		return leftNode;
	}

	public TNode<T> getRightNode() {
		return rightNode;
	}
	
	public boolean getVisited(){
		return visited;
	}
	
	public void setVisited(boolean visited){
		this.visited = visited;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setLeftNode(TNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(TNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	
}
