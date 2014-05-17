package com.subrata.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.subrata.tree.core.BinaryTree;
import com.subrata.tree.core.TNode;


/**
 * We have traverse the entire tree to check as there is no gurentee 
 * how the items are distributed , so do a level order traverse and 
 * find the max.
 * TODO - write recursive version of the algorithm with out extra space.
 * 
 * @author Subrata Saha
 *
 * @param <T>
 */
public class MaxItemInBTree<T> extends BinaryTree<T> {

	
	public void maxItem(TNode<T> node){
		
		if(node == null){
			return;
		}
		
		TNode<T> temp = node;
		Queue<TNode<T>> queue = new LinkedList<TNode<T>>();
		Integer max = -1;
		
		while(temp != null){
			// fix this dirty casting later on
			Integer val = (Integer)temp.getValue();
			if (val > max){
				max = val;
			}
			
			if(temp.getLeftNode() != null){
				queue.offer(temp.getLeftNode());
			}
			
			if(temp.getRightNode() != null){
				queue.offer(temp.getRightNode());
			}
			
			temp = queue.poll();
		}
		
		System.out.println("***************** Max is ::"+max);
	}
	
	public static void main(String[] args) {
		MaxItemInBTree<Integer> obj = new MaxItemInBTree<Integer>(); 
		Integer[] arr = {1,2,3,4,5,6,7};
		for(Integer val : arr){
			obj.addNode(val);
		}
		
		obj.maxItem(obj.root);
	}

}
