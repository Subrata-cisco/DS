package BTree;


/**
 * Operation on BTree.
 * @author Subrata
 *
 * @param <T>
 */
public interface IntfBTree<T> {
	public void addNode(T value);
	public void preorder(BTNode<T> node);
	public void levelOrder(BTNode<T> node);
}
