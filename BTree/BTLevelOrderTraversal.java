package BTree;

import java.util.LinkedList;
import java.util.Queue;

public class BTLevelOrderTraversal<T> extends BinaryTree<T> {
	
	/**
	 * Traverse level wise.
	 * @param node
	 */
	public void levelOrder(BTNode<T> node){
		Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		
		if(node == null){
			return;
		}
		
		BTNode<T> temp=node;
		
		while(temp != null){
			System.out.println("*****************Subrata val ::"+temp.getValue());
			
			if(temp.leftNode != null){
				queue.offer(temp.leftNode);
			}
			
			if(temp.rightNode != null){
				queue.add(temp.rightNode);
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
