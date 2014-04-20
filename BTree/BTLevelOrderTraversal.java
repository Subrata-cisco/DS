package btree;

import java.util.LinkedList;
import java.util.Queue;

import btree.core.BTNode;
import btree.core.BinaryTree;

public class BTLevelOrderTraversal<T> extends BinaryTree<T> {
	
	/**
	 * Traverse level wise.
	 * @param node
	 */
	public void levelOrder(BTNode<T> node){
		
		
		if(node == null){
			return;
		}
		
		BTNode<T> temp=node;
		Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		
		while(temp != null){
			System.out.println("*****************Subrata val ::"+temp.getValue());
			
			if(temp.getLeftNode() != null){
				queue.offer(temp.getLeftNode());
			}
			
			if(temp.getRightNode() != null){
				queue.offer(temp.getRightNode());
			}
			
			temp = queue.poll();
		}
	}

	public static void main(String[] args) {
		BTLevelOrderTraversal<Integer> obj = new BTLevelOrderTraversal<Integer>(); 
		Integer[] arr = {1,2,3,4,5,6,7};
		for(Integer val : arr){
			obj.addNode(val);
		}
		
		obj.levelOrder(obj.root);
	}

}
