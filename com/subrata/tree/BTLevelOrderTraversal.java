package com.subrata.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.subrata.tree.core.BinaryTree;
import com.subrata.tree.core.TNode;
/**
 * Level order traversal.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BTLevelOrderTraversal<T> extends BinaryTree<T>  {
	
	/**
	 * Traverse level wise.
	 * @param node
	 */
	public void levelOrder(TNode<T> node){
		
		if(node == null){
			return;
		}
		
		TNode<T> temp=node;
		Queue<TNode<T>> queue = new LinkedList<TNode<T>>();
		
		while(temp != null){
			System.out.println("*****************Subrata val ::"+temp.getValue());
			
			if(temp.getLeftNode() != null){
				System.out.println("****** Subrata -> inserting "+temp.getLeftNode().getValue());
				queue.offer(temp.getLeftNode());
			}
			
			if(temp.getRightNode() != null){
				System.out.println("****** Subrata -> inserting "+temp.getRightNode().getValue());
				queue.offer(temp.getRightNode());
			}
			
			temp = queue.poll();
		}
	}

	public static void main(String[] args) {
		BTLevelOrderTraversal<Integer> obj = new BTLevelOrderTraversal<Integer>(); 
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
        for(int val : list){
        	obj.addNode(val);
        }
		
		obj.levelOrder(obj.root);
	}

	

}
