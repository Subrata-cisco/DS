package com.subrata.tree.bst;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BSTClosestNode extends BinarySearchTree<Integer> {
	
	private TNode<Integer> minNode = null;
	private TNode<Integer> inputNode = null;
	private int min = Integer.MAX_VALUE;
	
	public int closestNode(TNode<Integer> start){
		TNode<Integer> temp = start; 
		
		if(temp == null){
			return min;
		}
		
		int diff = temp.getValue() > inputNode.getValue() ? temp.getValue() - inputNode.getValue()
				: inputNode.getValue() - temp.getValue();	
		
		if(diff < min){
			min = diff ;
			minNode = temp;
		}
			
		closestNode(temp.getLeftNode());
		closestNode(temp.getRightNode());
		
		return min;
	}
	
	
	public static void main(String[] args) {
		BSTClosestNode obj = new BSTClosestNode();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);

		obj.inputNode = new TNode<Integer>(6);
		obj.closestNode(obj.root);
		
		System.out.println("Closest node of "+obj.inputNode+" is ::"+obj.minNode);
	}

}
