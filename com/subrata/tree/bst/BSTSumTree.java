package com.subrata.tree.bst;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BSTSumTree extends BinarySearchTree {
	
	/**
	 * TODO - Change to generic type. No time u know !!
	 * @param start
	 * @return
	 */
	public int sumTree(TNode start){
		if(start == null){
			return 0;
		}
		
		if(start.getLeftNode() == null && start.getRightNode() == null){
			return (int)start.getValue();
		}
		
		int s1 = sumTree(start.getLeftNode());
		int s2 = sumTree(start.getRightNode());
		
		start.setValue(s1+s2);
		
		return s1+s2;
	}
	
	public static void main(String[] args) {
		BSTSumTree obj = new BSTSumTree();

		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		obj.addNode(20);
		
		obj.sumTree(obj.root);
		
		obj.preOrder(obj.root);

	}
}
