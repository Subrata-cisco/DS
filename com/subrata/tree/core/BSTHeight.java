package com.subrata.tree.core;

/**
 * TBD- Need to fix !!
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTHeight<T extends Comparable<T>> extends BinarySearchTree<T> {

	public int getHeightOfTheTree(TNode<T> start){
		if(start == null){
			return 0;
		}
		
		int leftHeight = getHeightOfTheTree(start.getLeftNode());
		int rightHeight = getHeightOfTheTree(start.getRightNode());
		
		if(leftHeight > rightHeight){
			return leftHeight+1 ;
		}else{
			return rightHeight+1 ;
		}
	}
	
	/*
	 * TBD 
	 */
	public int getHeightNonRecursive(TNode<T> start){
		return -1;
	}
	
	public static void main(String[] args) {
		BSTHeight<Integer> obj = new BSTHeight<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		obj.addNode(22);
		
		System.out.println("****** Subrata ->  Height of the Tree :: "+obj.getHeightOfTheTree(obj.root));
	}
}
