package com.subrata.tree.core;

import java.util.LinkedList;
import java.util.Queue;

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
	
	public int getHeightNonRecursive(TNode<T> start){
		Queue<TNode<T>> q = new LinkedList<TNode<T>>();
		int height = 0;
		// add root to the queue
		q.add(root);
		// add null as marker
		q.add(null);
		while (q.isEmpty() == false) {
			TNode<T> n = q.remove();
			// check if n is null, if yes, we have reached to the end of the
			// current level, increment the height by 1, and add the another
			// null as marker for next level
			if (n == null) {
				// before adding null, check if queue is empty, which means we
				// have traveled all the levels
				if(!q.isEmpty()){
					q.add(null);
				}
				height++;
			}else{
				// else add the children of extracted node.
				if (n.getLeftNode() != null) {
					q.add(n.getLeftNode());
				}
				if (n.getRightNode() != null) {
					q.add(n.getRightNode());
				}
			}
		}
		return height;
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
