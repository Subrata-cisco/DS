package com.subrata.tree;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Preorder traversal using stack.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTPreorderNonRecursive<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	
	public void preOrderNR(TNode<T> root){
		if(root == null){
			System.out.println("Empty tree !!");
			return;
		}
		System.out.println("Non iterative pre order traversal :");
		Stack<TNode<T>> stack = new Stack<>(); 
		TNode<T> prev = root;
		stack.push(prev);
		
		while(!stack.isEmpty()){
			TNode<T> next = stack.pop();
			System.out.println(next.getValue());
			
			if(next.getRightNode() != null){
				stack.push(next.getRightNode());
			}
			
			if(next.getLeftNode() != null){
				stack.push(next.getLeftNode());
			}
		}
	}
}
