package com.subrata.tree.core;

public class BSTSize<T extends Comparable<T>> extends BinarySearchTree<T> {

	public int getRecursiveSize(TNode<T> node){
         if(node == null){
        	 return 0;
         }else{
        	 return getRecursiveSize(node.getLeftNode())+1+getRecursiveSize(node.getRightNode());
         }
	}
	
	public static void main(String[] args) {
		BSTSize<Integer> obj = new BSTSize<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		
		//obj.postOrder(obj.root);
		System.out.println("****** Subrata ->  Size ::"+obj.getRecursiveSize(obj.root));
		System.out.println("****** Subrata -> Size ::"+obj.getSize());
	}
}