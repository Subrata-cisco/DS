package com.subrata.tree;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Make a mirroe tree in a recursive way.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTMirrorTreeRecursive<T extends Comparable<T>> extends
		BinarySearchTree<T> {

	
	public void mirror(TNode<T> node) {
		if (node == null)
			return;

		mirror(node.getLeftNode());
		mirror(node.getRightNode());

		TNode<T> tmp = node.getLeftNode();
		node.setLeftNode(node.getRightNode());
		node.setRightNode(tmp);  

	}
	
}
