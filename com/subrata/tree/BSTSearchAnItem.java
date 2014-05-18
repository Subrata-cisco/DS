package com.subrata.tree;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Searching an Item in binary search Tree
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTSearchAnItem<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	public boolean searchWithRecursion(TNode<T> node, T data){
		if(node == null){
			return false;
		}else{
			if(node.getValue().compareTo(data) == 0){
				return true;
			}else if (node.getValue().compareTo(data) > 0){
				return searchWithRecursion(node.getLeftNode(),data);
			} else {
				return searchWithRecursion(node.getRightNode(),data);
			}
		}
	}
	
	public boolean searchWithOutRecursion(TNode<T> node, T data){
		boolean found = false;
		while(node != null){
				if(node.getValue().compareTo(data) == 0){
					found = true;
					break;
				}else{
					if(node.getValue().compareTo(data) > 0){
						node = node.getLeftNode();
					}else{
						node = node.getRightNode();
					}
				}
		}
		return found;
	}
	
	public static void main(String[] args) {
		BSTSearchAnItem<Integer> obj = new BSTSearchAnItem<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		
		
		boolean found = obj.searchWithRecursion(obj.root,8);
		System.out.println("****** Subrata ->  Search number 8 recursively :: found ::"+found);
		
		
		found = obj.searchWithOutRecursion(obj.root,8);
		System.out.println("****** Subrata ->  Search number 8 non recursively :: found ::"+found);

	}
	
}
