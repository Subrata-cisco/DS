package com.subrata.tree;

import java.util.HashMap;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

/**
 * 
 * Vertical Sum of the Tree.
 * Fundamental : do a Inorder traversal of the Tree and hash the values in each level. 
 * All the hashed for each level then summed up.
 * 
 * @author Subrata Saha.
 *
 */
public class BSTVerticalSum<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	public void printVerticalSum(TNode<Integer> start){
		
		if(start == null){
			return ;
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		sumAndHashByHorizontalDistance(start,map,0);
		
        System.out.println(map.entrySet());
	}
	
	/*
	 * Starting from root position the further we go left assume it negative distance and going right means positive direction.
	 * root -> left child                       = 0 -> -1
	 * left child -> another left child         = -1 -> -2
	 * from that left child to some right child = -2 -> -1 and so on...
	 */
	private void sumAndHashByHorizontalDistance(TNode<Integer> start,HashMap<Integer,Integer> map,int hd){
		if(start == null){
			System.out.println("Running for null ");
			return;
		}else{
			System.out.println("Running for start ::"+start.getValue());
		}
		sumAndHashByHorizontalDistance(start.getLeftNode(),map,hd-1);
		
		int sum = map.get(hd) == null ? 0 : map.get(hd);
		map.put(hd, sum+start.getValue());
		System.out.println("sum ::"+(sum+start.getValue())+" hd ::"+hd+" strat ::"+start);
		
		sumAndHashByHorizontalDistance(start.getRightNode(),map,hd+1);
	}
	
	public static void main(String[] args) {
		BSTVerticalSum<Integer> obj = new BSTVerticalSum<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		obj.addNode(20);
		
		obj.printVerticalSum(obj.root);
	}
}
