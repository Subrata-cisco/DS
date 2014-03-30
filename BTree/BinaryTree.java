package BTree;

import java.util.Queue;
import java.util.LinkedList;
/**
 * Idea : No need to check if lesser than left or else right side etc.
 * Keep filling the new nodes in each level.
 * 
 *  Simple implementation to understand the concept, i am sure you will be
 *  able to generalize for any data type.
 * 
 * @author Subrata
 *
 */
public class BinaryTree<T> implements IntfBTree<T> { 
	// this is root node.
	BTNode<T> root = null;
	BTNode<T> levelNode = null;
	int size;
	
	public void addNode(T value){
		BTNode<T> newNode = new BTNode<T>(value);
		if(root == null){
			root = newNode;
			levelNode = newNode;
		}else{
			if(levelNode.leftNode == null){
				levelNode.leftNode = newNode;
			}else{
				levelNode.rightNode = newNode;
				levelNode = levelNode.leftNode;
			}
		}
		size++;
	}
	
	public void preorder(BTNode<T> node){
		
		if(node == null){
			return;
		}
		
		System.out.println("***************** value is ::"+node.getValue());
		preorder(node.leftNode);
		preorder(node.rightNode);
	}
	
	/**
	 * 
	 * @param node
	 */
	public void levelOrder(BTNode<T> node){
		Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		
		if(node == null){
			return;
		}
		
		BTNode<T> temp=node;
		
		while(temp != null){
			System.out.println("***************** val ::"+temp.getValue());
			
			if(temp.leftNode != null){
				queue.offer(temp.leftNode);
			}
			
			if(temp.rightNode != null){
				queue.add(temp.rightNode);
			}
			
			temp = queue.poll();
		}
	}
	
	
	private void addAll(T[] arr){
        for(T val : arr){
      	  addNode(val);
        }
	}
	

	public static void main(String[] args) {
		BinaryTree<Integer> obj = new BinaryTree<Integer>();
		Integer[] arr = {1,2,3,4,5,6,7};
		obj.addAll(arr);
		
		//obj.preorder(obj.root);
		obj.levelOrder(obj.root);
	}
}
