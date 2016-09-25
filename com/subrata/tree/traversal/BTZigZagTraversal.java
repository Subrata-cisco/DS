package com.subrata.tree.traversal;

import com.subrata.tree.core.BinaryTree;
import com.subrata.tree.core.TNode;
/**
 *         16
 *     12     18
 *    8 14   17 22
 *    
 * You have to print like : 16 , 18 , 12 , 8, 14, 17, 22
 *    
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BTZigZagTraversal<T extends Comparable<T>> extends
		BinaryTree<T> {

	// The idea is do a level order traversal but change the printing order alternative time.
	private void printGivenLevel(TNode<T> start, int level, boolean lr) {
		if (start == null) {
			return;
		}

		if (level == 1) {
			System.out.println("****** Subrata -> " + start.getValue());
		}else if (level > 1) {
			if (lr) {
				printGivenLevel(start.getLeftNode(), level - 1, lr);
				printGivenLevel(start.getRightNode(), level - 1, lr);
			} else {
				printGivenLevel(start.getRightNode(), level - 1, lr);
				printGivenLevel(start.getLeftNode(), level - 1, lr);
			}
		}
	}
	
	void printSpiral(TNode<T> start) {
		int h = height(start);
		int i;

		/*
		 * ltr -> Left to Right. If this variable is set, then the given level
		 * is traverseed from left to right.
		 */
		boolean ltr = true;
		for (i = 1; i <= h; i++) {
			printGivenLevel(start, i, ltr);
			System.out.println("****** Subrata -> *********");

			/* Revert ltr to traverse next level in oppposite order */
			ltr = !ltr;
		}
	}
	
	private int height(TNode<T> start) {
		if (start == null)
			return 0;
		else {
			/* compute the height of each subtree */
			int lheight = height(start.getLeftNode());
			int rheight = height(start.getRightNode());

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}	
	
	public static void main(String[] args) {
		BTZigZagTraversal<Integer> obj = new BTZigZagTraversal<>();
		obj.addNode(1);
		obj.addNode(2);
		obj.addNode(3);
		obj.addNode(4);
		obj.addNode(5);
		obj.addNode(6);
		obj.addNode(7);
		
		obj.printSpiral(obj.root);
	}
}
