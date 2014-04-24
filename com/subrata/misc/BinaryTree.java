package com.subrata.misc;

import java.util.Stack;

/**
 * Program to create a binary tree and various opertionon it.
 * @author subratas
 *
 */
public class BinaryTree {
	static Node head = null;
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(12);
		binaryTree.insert(10);
		binaryTree.insert(14);
		binaryTree.insert(8);
		binaryTree.insert(11);
		binaryTree.insert(11);
		binaryTree.insert(13);
		binaryTree.insert(15);
		
		
		//System.out.println("Pre order traversal !!");
		//preOrder(head);
		//preOrderNR(head);
		//System.out.println("Post order traversal !!");
		//postOrder(head);
		//postOrderNR(head);
		//postOrderNoflag(head);
		//postOrder2Stack(head);
		//System.out.println("In order traversal !!");
		inOrder(head);
		inOrderNR(head);
	}
	
	// Define the node
	static class Node {
		Node left;
		Node right;
		int value;
		boolean visited;

		public Node(int value) {
			this.value = value;
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	public void mirror(Node node) {
		if (node == null)
			return;

		mirror(node.left);
		mirror(node.right);

		Node tmp = node.left;
		node.left = node.right;
		node.left = tmp;

	}
	
	public void mirrorTreeNR(Node root) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		Node current = null;
		Node temp = null;

		while (!stack.isEmpty()) {
			current = stack.pop();
			temp = current.left;
			current.left = current.right;
			current.right = temp;

			if (current.left != null)
				stack.push(current.left);
			if (current.right != null)
				stack.push(current.right);
		}
		return;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	public static void inOrderNR(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.empty())
					return;
				root = stack.pop();
				System.out.println(root.value);
				root = root.right;
			}
		}
	}
	
	public static void preOrderNR(Node root){
		if(root == null){
			System.out.println("Empty tree !!");
			return;
		}
		System.out.println("Non iterative pre order traversal :");
		Stack<Node> stack = new Stack<Node>(); 
		Node prev = root;
		stack.push(prev);
		
		while(!stack.isEmpty()){
			Node next = stack.pop();
			System.out.println(next.value);
			
			if(next.right != null){
				stack.push(next.right);
			}
			
			if(next.left != null){
				stack.push(next.left);
			}
		}
	}
	
	/**
	 * With visited logic
	 * @param root
	 */
	public static void postOrderNR(Node root) {
		System.out.println("BinaryTree.postOrderNR() :");
		Stack<Node> stack = new Stack<Node>();
		
		Node node = root;

		if (node != null)
			stack.push(node);

		while (!stack.isEmpty()) {
			node = stack.peek();
			if (node.visited) {
				stack.pop();
			} else {
				node.visited = true;
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
	}
	
	/**
	 * iterating the post order with out flag
	 * @param root
	 * @return
	 */
	public static void postOrderNoflag(Node root) {
		System.out.println("BinaryTree.postOrderNoflag()");
		Stack<Node> stack = new Stack<Node>();
		Node prev = null;
		Node curr = root;
		stack.push(root);
		while (!stack.isEmpty()) {
			while (curr != null) {
				if (curr.left != null) {
					curr = curr.left;
					stack.push(curr);
				} else {
					break; // break loop
				}
			}
			curr = stack.peek();
			if (curr.right != null && prev != curr.right) {
				curr = curr.right;
				stack.push(curr);
			} else {
				stack.pop();
				System.out.println(curr.value);
				prev = curr;
				curr = null;
			}
		}
	}
	
	/**
	 * doing post order traversal with 2 stacks.
	 * @param root
	 */
	public static void postOrderUsingTwoStack(Node root) {
		if (root == null)
			return;
		Stack<Node> childStack = new Stack<Node>();
		Stack<Node> nodeStack = new Stack<Node>();
		childStack.add(root);
		while(!childStack.isEmpty()) {
			root = childStack.pop();
			if(root.left != null)
				childStack.push(root.left);
			if(root.right != null)
				childStack.push(root.right);
			nodeStack.push(root);
		}
		while(!nodeStack.isEmpty())
			System.out.print(nodeStack.pop().value + " ");
		System.out.println();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	
	public static void preOrder(Node root){
		Node tempHead = root;
		if(tempHead != null){
			System.out.println(tempHead.value);
			preOrder(tempHead.left);
			preOrder(tempHead.right);
		}
	}
	
	public static void postOrder(Node root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}
	}
	
	public static void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.println(root.value);
			inOrder(root.right);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	
	public void insert(int value) {
		
		Node newNode = new Node(value);
		
		if(head == null){
			head = newNode;
			return;
		}
		
		Node temp = head  , prev = null;
		
		while(temp != null){
			prev = temp;
			if(value < temp.value){
				temp = temp.left ;
			}else if (value > temp.value){
				temp = temp.right ;
			} else {
				temp = null; // loop terminating condition.
			}
		}
		
		if(newNode.value < prev.value){
			prev.left = newNode ;
		}else if(newNode.value > prev.value){
			prev.right = newNode ;
		}else {
			System.out.println("Neglecting the already inserted value ::"+value);
		}
	}

}
