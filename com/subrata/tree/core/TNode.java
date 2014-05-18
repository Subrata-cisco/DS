package com.subrata.tree.core;
/**
 * Node class of the BTree
 * @author Subrata
 *
 * @param <T>
 */
public class TNode<T>  {
	
	T value;
	boolean visited;
	TNode<T> leftNode;
	TNode<T> rightNode;
	TNode<T> parenNode;
	

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
	
	public TNode<T> getParenNode() {
		return parenNode;
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

	public void setParenNode(TNode<T> parenNode) {
		this.parenNode = parenNode;
	}

	@Override
	public String toString() {
		return "TNode [value=" + value + "]";
	}
	
}
