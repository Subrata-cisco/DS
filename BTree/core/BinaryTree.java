package btree.core;


/**
 * Idea : No need to check if lesser than left or else right side etc. Keep
 * filling the new nodes in each level.
 * 
 * Simple implementation to understand the concept, i am sure you will be able
 * to generalize for any data type.
 * 
 * @author Subrata
 * 
 */
public abstract class BinaryTree<T> implements IntfBTree<T> {
	// this is root node.
	protected BTNode<T> root = null;
	protected BTNode<T> levelNode = null;
	int size;

	public void addNode(T value) {
		BTNode<T> newNode = new BTNode<T>(value);
		if (root == null) {
			root = newNode;
			levelNode = newNode;
		} else {
			if (levelNode.leftNode == null) {
				levelNode.leftNode = newNode;
			} else {
				levelNode.rightNode = newNode;
				levelNode = levelNode.leftNode;
			}
		}
		size++;
	}

	public void preOrder(BTNode<T> node) {

		if (node == null) {
			return;
		}

		System.out.println("***************** pre order value is ::" + node.getValue());
		preOrder(node.leftNode);
		preOrder(node.rightNode);
	}

	public void postOrder(BTNode<T> node) {

		if (node == null) {
			return;
		}

		
		postOrder(node.leftNode);
		postOrder(node.rightNode);
		System.out.println("***************** post order value is ::" + node.getValue());
	}

	public void inOrder(BTNode<T> node) {

		if (node == null) {
			return;
		}

		inOrder(node.leftNode);
		System.out.println("***************** Inorder value is ::" + node.getValue());
		inOrder(node.rightNode);
	}
}
