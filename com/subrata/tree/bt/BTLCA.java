package com.subrata.tree.bt;

import com.subrata.tree.core.TNode;

public class BTLCA<T> {

	public TNode<T> getLCA(TNode<T> root, TNode<T> n1, TNode<T> n2) {
		if (root == null) {
			return null;
		} else {
			if (root.getValue() == n1.getValue() || root.getValue() == n2.getValue()) {
				return root;
			}
			TNode<T> left = getLCA(root.getLeftNode(), n1, n2);
			TNode<T> right = getLCA(root.getRightNode(), n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			} else if (right != null) {
				return right;
			}
			return null;
		}
	}

}
