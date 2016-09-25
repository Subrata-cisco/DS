package com.subrata.tree;

import com.subrata.tree.core.BSTSearchAnItem;
import com.subrata.tree.core.TNode;

public class BTPruneNotMatchingPathWithGivenSum<T extends Comparable<Integer>> extends BSTSearchAnItem<Integer> {

	public TNode<Integer> prune(TNode<Integer> start, int sum) {
		if (start == null) {
			return null;
		}

		start.setLeftNode(prune(start.getLeftNode(), sum - start.getValue()));
		start.setRightNode(prune(start.getRightNode(), sum - start.getValue()));

		if (start.getLeftNode() == null && start.getRightNode() == null) {
			if (start.getValue() < sum) {
				//deleteNode(start, root);
				start = null;
				//start.getParenNode()
			}
		}

		return start;
	}
	

	

	public static void main(String[] args) {
		BTPruneNotMatchingPathWithGivenSum<Integer> obj = new BTPruneNotMatchingPathWithGivenSum<>();

		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(18);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(20);
		obj.addNode(22);

		obj.prune(obj.root,42);

		obj.inOrder(obj.root);
	}
}
