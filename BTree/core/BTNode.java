package btree.core;


/**
 * Node class of the BTree
 * @author Subrata
 *
 * @param <T>
 */
public class BTNode<T> {
	T value;
	BTNode<T> leftNode;
	BTNode<T> rightNode;

	BTNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public BTNode<T> getLeftNode() {
		return leftNode;
	}

	public BTNode<T> getRightNode() {
		return rightNode;
	}
}
