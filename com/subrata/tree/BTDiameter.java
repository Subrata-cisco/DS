package com.subrata.tree;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BTDiameter<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	private int diameter(TNode<Integer> start) {
		if(start == null){
			return 0;
		}
		System.out.println("*********** start *****************");
		int lh = height(start.getLeftNode());
		int rh = height(start.getRightNode());
		
		int ld = diameter(start.getLeftNode());
		int rd = diameter(start.getRightNode());
		
		System.out.println("start ::"+start+" lh::"+lh+" rh ::"+rh+" ld ::"+ld+" rd ::"+rd);
		
		return (Math.max((lh+rh),Math.max(ld, rd)));
		
	}
	
	private int height(TNode<Integer> start) {
		if(start == null){
			return 0;
		}
		
		int lh = height(start.getLeftNode());
		int rh = height(start.getRightNode());
	
		return Math.max(lh, rh) + 1;
	}

	public static void main(String[] args) {
		BTDiameter<Integer> obj = new BTDiameter<>();

		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		obj.addNode(20);

		int h = obj.diameter(obj.root);
		System.out.println(h);

	}

	
}
