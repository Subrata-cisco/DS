package BTree;

import BTree.core.BTNode;
import BTree.core.BinaryTree;

public class MaxItemInBTree<T> extends BinaryTree<T> {

	public void maxItem(BTNode<T> node){
		
	}
	
	public static void main(String[] args) {
		MaxItemInBTree<Integer> obj = new MaxItemInBTree<Integer>(); 
		Integer[] arr = {1,2,3,4,5,6,7};
		for(Integer val : arr){
			obj.addNode(val);
		}
	}

}
