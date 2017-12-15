package com.subrata.tree.bst;

import java.util.Stack;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BSTKthSmallestNode<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	
	public void findKthSmallestNode(int k){
		TNode<T> temp = root;
		Stack<TNode<T>> stack = new Stack<>();
		int count = 0;
		
		while(true){
			if(temp != null){
				stack.push(temp);
				temp = temp.getLeftNode();
			}else{
				if(stack.isEmpty()){
					return;
				}
				temp = stack.pop();
				count ++;
				if(count == k){
					System.out.println(k+"th smallest element is ::"+temp.getValue());
					break;
				}
				temp = temp.getRightNode();
			}
		}
		
	}
	
	public static void main(String[] args) {
		BSTKthSmallestNode<Integer> obj = new BSTKthSmallestNode<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);
		
		obj.findKthSmallestNode(3);
	}
	
}
