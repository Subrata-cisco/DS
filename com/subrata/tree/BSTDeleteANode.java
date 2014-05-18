package com.subrata.tree;

import com.subrata.tree.core.TNode;

public class BSTDeleteANode<T extends Comparable<T>> extends BSTSearchAnItem<T> {

	public void deleteNode(T data, TNode<T> start) {
		TNode<T> nodeToBeDeleted = searchWithRecursion(start, data);
		if(nodeToBeDeleted == null){
			return;
		}
		deleteNode(nodeToBeDeleted , start);
	}
	
	private void deleteNode(TNode<T> nodeToBeDeleted, TNode<T> start){
		
		TNode<T> parent = nodeToBeDeleted.getParenNode();
		
		// Case when node to deleted has no children.
		if(nodeToBeDeleted.getLeftNode() == null && nodeToBeDeleted.getRightNode() == null){
			if(parent != null && parent.getLeftNode().equals(nodeToBeDeleted)){
				parent.setLeftNode(null);
				nodeToBeDeleted = null;
			}else if(parent != null && parent.getRightNode().equals(nodeToBeDeleted)){
				parent.setRightNode(null);
				nodeToBeDeleted = null;
			}
		} // has only right children.
		else if(nodeToBeDeleted.getLeftNode() == null){
			if(parent != null && parent.getLeftNode().equals(nodeToBeDeleted)){
	             parent.setLeftNode(nodeToBeDeleted.getRightNode());    //Reassign the parents reference to the correct node.
			}else if(parent != null && parent.getRightNode().equals(nodeToBeDeleted)) {
				 parent.setRightNode(nodeToBeDeleted.getRightNode()); 
	        }
		} // has only left children.
		else if(nodeToBeDeleted.getRightNode() == null) {
			if(parent != null && parent.getLeftNode().equals(nodeToBeDeleted)){
	             parent.setLeftNode(nodeToBeDeleted.getLeftNode());    //Reassign the parents reference to the correct node.
			}else if(parent != null && parent.getRightNode().equals(nodeToBeDeleted)) {
				 parent.setRightNode(nodeToBeDeleted.getLeftNode()); 
	        }
		}	// has both left and right children.
		else {
			TNode<T> leftNode = nodeToBeDeleted.getLeftNode();
			TNode<T> maxItemInLeftTree = findMaxItem(leftNode);
			nodeToBeDeleted.setValue(maxItemInLeftTree.getValue());
			deleteNode(maxItemInLeftTree,start);
		}
	}
	
	private TNode<T> findMaxItem(TNode<T> start){
		TNode<T> node = null;
		if(start != null){
			if(start.getRightNode() == null){
				node = start;
			}else{
				node = findMaxItem(start.getRightNode());
			}
		}
		return node;
	}
	

	public static void main(String[] args) {
		BSTDeleteANode<Integer> obj = new BSTDeleteANode<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);

		obj.levelOrder(obj.root);
		obj.deleteNode(16, obj.root);
		obj.levelOrder(obj.root);

	}
}
