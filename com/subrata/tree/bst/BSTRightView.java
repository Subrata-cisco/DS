package com.subrata.tree.bst;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BSTRightView<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	int currentLevel = 0; 
	
	public void rightView(TNode<T> start,int nextLevel){
		
		if(start == null){
			return ;
		}
		
		if(currentLevel < nextLevel){
			System.out.println(start.getValue());
			currentLevel = nextLevel;
		}
		
		rightView(start.getRightNode(),nextLevel+1);
		rightView(start.getLeftNode(),nextLevel+1);
	}
	
	
	public static void main(String[] args) {
		
		BSTRightView<Integer> obj = new BSTRightView<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		obj.addNode(20);

		obj.rightView(obj.root,1); 
		
	}
}
