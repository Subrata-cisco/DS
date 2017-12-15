package com.subrata.tree.bst;

import com.subrata.tree.core.TNode;

public class BSTDeepestNode<T> {

	int deepestlevel;
	T value;

	public T Deep(TNode<T> root) {
		find(root, 0);
		return value;
	}

	public void find(TNode<T> root, int level) {
		if (root != null) {
			find(root.getLeftNode(), ++level);
			if (level > deepestlevel) {
				value = root.getValue();
				deepestlevel = level;
			}
			find(root.getRightNode(), level);
		}
	}

}
