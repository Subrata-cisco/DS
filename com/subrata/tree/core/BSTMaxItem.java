package com.subrata.tree.core;

/**
 * Max Item in Binary Search Tree.
 * Fundamental : The right most item is the highest item, if right item is null then root is highest item.
 * But the above shall be done iteratively.
 * 
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTMaxItem<T extends Comparable<T>> extends BinarySearchTree<T> {

	public TNode<T> findMaxItem(TNode<T> start){
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
		BSTMaxItem<Integer> obj = new BSTMaxItem<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		
		System.out.println("****** Subrata -> Max Item in BST is  ::"+obj.findMaxItem(obj.root));
	}
}
