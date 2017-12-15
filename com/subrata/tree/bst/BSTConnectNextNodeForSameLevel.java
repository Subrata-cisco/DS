package com.subrata.tree.bst;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;

public class BSTConnectNextNodeForSameLevel<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	public void connectNode(TNode<T> p) {
		
		if(p == null){
			return;
		}
		
		// set root next as nothing.
		p.setNextNode(null);
		
		// Set next pointer for all level
		while(p != null){
			
			TNode<T> q = p;
			// Set next pointer for each level
			while(q != null){
				
				// set the next of left node of the root
				if(q.getLeftNode() != null){
					if(q.getRightNode() != null){
						q.getLeftNode().setNextNode(q.getRightNode());
					}else{
						q.getLeftNode().setNextNode(getNextRight(q));
					}
				}
				
				
				// set the next of right node of the root
				if(q.getRightNode() != null){
					q.getRightNode().setNextNode(getNextRight(q));
				}
				
				//advance the pointer for node
				q = q.getNextNode();
			}
			
			// to go to next level take left or right or next right from other tree.
			if(p.getLeftNode() != null){
				 p = p.getLeftNode();
			}else if(p.getRightNode() != null){
				p = p.getRightNode();
			}else{
				p = getNextRight(p);
			}
		}
	}
	
	private TNode<T> getNextRight(TNode<T> q) {
		TNode<T> temp = q.getNextNode();
		while(temp != null){
			if(q.getLeftNode() != null){
				return q.getLeftNode();
			}
			
			if(q.getRightNode() != null){
				return q.getRightNode();
			}
			temp = temp.getNextNode();
		}
		return null;   
	}

	public static void main(String[] args) {
		BSTConnectNextNodeForSameLevel<Integer> obj = new BSTConnectNextNodeForSameLevel<>();
		
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		obj.addNode(20);
		
		obj.connectNode(obj.root);
		
		System.out.println("obj"+obj);
	}
}
