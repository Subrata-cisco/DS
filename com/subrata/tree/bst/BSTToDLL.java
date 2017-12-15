package com.subrata.tree.bst;

import com.subrata.tree.core.BSTSearchAnItem;
import com.subrata.tree.core.TNode;

public class BSTToDLL<T extends Comparable<T>> extends BSTSearchAnItem<T> {
	
	public TNode<T> toDLL(TNode<T> start){
		if(start == null){
			return start;
		}
		
		// For any root node find the left and right sub tree.
		TNode<T> leftTree = toDLL(start.getLeftNode());
		TNode<T> rightTree = toDLL(start.getRightNode());
		
		// make the root node as DLL by connecting left and right of that node as itself (bring circular nature)
		start.setLeftNode(start);
		start.setRightNode(start);
		
		// merge root and left sub tree
		start = concatenate(start,leftTree);
		
		// merge root with right sub tree.
		start = 	concatenate(start,rightTree);
		
		//return the merged root.s
		return start;
	}
	
    /**
     *   a is a DLL 1 <-> 2 <-> 3      and b is a DLL 4 <-> 5 <-> 6
     *   here        1.left = 3 and 3.right=1
     *   similarly   4.left = 6 and 6.right=4
     *   
     *   As we always return the first node to represent a DLL
     *   So a = 1 and b = 4
     *   So aEnd = 3 and bEnd=6
     *   
     *   To connect a and b we have to do the following and finally return a as the merged DLL
     */
	private TNode<T> concatenate(TNode<T> a, TNode<T> b) {
		if(a == null) return b;
		if(b == null) return a;
		
		TNode<T> aEnd = a.getLeftNode();
		TNode<T> bEnd = b.getLeftNode();
		
		a.setLeftNode(bEnd);
		bEnd.setRightNode(a);
		
		aEnd.setRightNode(b);
		b.setLeftNode(aEnd);
		
		return a;
	}

	public static void main(String[] args) {
		BSTToDLL<Integer> obj = new BSTToDLL<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(20);
		obj.addNode(22);

		TNode<Integer> start = obj.root;
		obj.toDLL(start);
		
		TNode<Integer> startForPrint = obj.root;
		int val = startForPrint.getValue();
		startForPrint = startForPrint.getRightNode();
		
		System.out.println(val);
		while(startForPrint.getValue() != val){
			System.out.println(startForPrint.getValue());
			startForPrint = startForPrint.getRightNode();
		}
		
	}
}
