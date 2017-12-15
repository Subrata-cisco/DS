package com.subrata.tree.bt;

import java.util.ArrayList;
import java.util.List;

import com.subrata.tree.core.BinaryTree;
import com.subrata.tree.core.TNode;
/**
 * Level with max sum in binary tree.
 * Fundamental : Do a level order traversing and accumulate all the value in a list.
 * From the client sum all the value and print it.
 * 
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BTLevelWithMaxSum<T extends Comparable<T>> extends BinaryTree<T> {

	public void levelWithMaxSum(TNode<Integer> start){
		int height = getTreeHeight(start);
		List<Integer> list = new ArrayList<>();
		
		for(int i=1;i<= height;i++){
			findSumForLevel(start,i,list);
			int sum = list.stream().mapToInt(k -> k).sum();
			list.clear();
			System.out.println("****** Subrata -> level ::"+i+" and sum ::"+sum);
		}
		
	}
	
	private void findSumForLevel(TNode<Integer> start,int level,List<Integer> list){
		
		if(start == null){
			return ;
		}
		
		if(level == 1 ){
			list.add(start.getValue());
		}else if(level > 1){
			findSumForLevel(start.getLeftNode(), level - 1,list);
			findSumForLevel(start.getRightNode(), level - 1,list);
		}
	}
	
	private int getTreeHeight(TNode<Integer> start){
		if(start == null){
			return 0;
		}
		
		int leftTreeHeight = getTreeHeight(start.getLeftNode());
		int rightTreeHeight = getTreeHeight(start.getRightNode());
		
		if(leftTreeHeight > rightTreeHeight){
			return leftTreeHeight +1;
		}else{
			return rightTreeHeight+1;
		}
	}
	
	public static void main(String[] args) {
		BTLevelWithMaxSum<Integer> obj = new BTLevelWithMaxSum<>();
		obj.addNode(1);
		obj.addNode(2);
		obj.addNode(3);
		obj.addNode(4);
		obj.addNode(5);
		obj.addNode(6);
		obj.addNode(7);
		
		obj.levelWithMaxSum(obj.root);
	}
}
