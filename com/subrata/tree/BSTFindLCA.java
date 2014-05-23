package com.subrata.tree;

import com.subrata.tree.core.BinarySearchTree;
import com.subrata.tree.core.TNode;
/**
 * Find LCA.
 * Idea : 
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BSTFindLCA<T extends Comparable<T>> extends BinarySearchTree<T> {
	
	
	public TNode<T> findLeastCommonAncestor2(TNode<T> root, T n1, T n2) {
		if (root == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (root.getValue().compareTo(n1) > 0
				&& root.getValue().compareTo(n2) > 0)
			return findLeastCommonAncestor2(root.getLeftNode(), n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (root.getValue().compareTo(n1) < 0
				&& root.getValue().compareTo(n2) < 0)
			return findLeastCommonAncestor2(root.getRightNode(), n1, n2);

		return root;
	}
	
	int count  = 0;

	// This function returns pointer to LCA of two given values n1 and n2.
	// This function assumes that n1 and n2 are present in Binary Tree
	public TNode<T> findLeastCommonAncestor1(TNode<T> root, T n1, T n2) {
		// Base case
		if (root == null){
			System.out.println("****** Subrata -> Root null");
			return null;
		}
		System.out.println("****** Subrata -> Incoming ::"+root.getValue());

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.getValue().compareTo(n1) == 0
				|| root.getValue().compareTo(n2) == 0){
			count++;
			System.out.println("****** Subrata -> root matched ::"+root.getValue()+" with n1-n2   ::"+n1+"-"+n2);
			return root;
		}

		System.out.println("****** Subrata -> 111111");
		// Look for keys in left and right subtrees
		TNode<T> left_lca = findLeastCommonAncestor1(root.getLeftNode(), n1, n2);
		System.out.println("****** Subrata -> 222222");
		TNode<T> right_lca = findLeastCommonAncestor1(root.getRightNode(), n1, n2);
		System.out.println("****** Subrata -> 3333333");

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null){
			System.out.println("****** Subrata -> left ::"+left_lca.getValue()+" right ::"+right_lca.getValue());
			return root;
		}
		
		//if ((left_lca != null && right_lca == null) || (right_lca != null && left_lca == null))
			//return null;
        if(left_lca != null){
        	System.out.println("****** Subrata -> left_lca :"+left_lca.getValue());
        }
        
        if(right_lca != null){
        	System.out.println("****** Subrata -> right_lca :"+right_lca.getValue());
        }
        
        
		// Otherwise check if left subtree or right subtree is LCA
        TNode<T> node = (left_lca != null) ? left_lca : right_lca;
        if(node != null){
        System.out.println("****** Subrata -> Finally returned ::"+node.getValue());
        }else {
        	System.out.println("****** Subrata -> finall returning null");
        }
        System.out.println("********************************* Subrata -> *************************************");
		return node;
	}
	
	public static void main(String[] args) {
		BSTFindLCA<Integer> obj = new BSTFindLCA<>();
		obj.addNode(16);
		obj.addNode(12);
		obj.addNode(8);
		obj.addNode(14);
		obj.addNode(18);
		obj.addNode(17);
		obj.addNode(22);
		
		TNode<Integer> ancestor = obj.findLeastCommonAncestor1(obj.root,142,262);
		System.out.println("****** Subrata -> ancestor ::"+(ancestor != null ? ancestor.getValue() :" No common ancestor !!"));
	}

}
