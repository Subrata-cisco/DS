package com.subrata.stack;
/**
 * Simple Stack implementation using Linked node.
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class Stack<T extends Comparable<T>> implements IStack<T> {

	LinkedNode<T> top = null;
	
	class LinkedNode<K> {
		K val;
		LinkedNode<K> next;
		
		LinkedNode(K val){
			this.val = val;
		}
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	@Override
	public void push(T val) {
		LinkedNode<T> node = new LinkedNode<T>(val);
		node.next = top;
		top = node;
	}

	@Override
	public T pop() {
		T returnVal = null;
		if(top == null){
			System.out.println("****** Subrata -> Stack is empty !!");
			return returnVal;
		}else{
			LinkedNode<T> temp = top;
			returnVal = temp.val;
			top = top.next;
			temp = null;
		}
		//System.out.println("****** Subrata -> popped value ::"+returnVal);
		return returnVal;
	}
	
	public void display(){
		StringBuilder sb = new StringBuilder();
		LinkedNode<T> node = top;
		while(node!= null){
			sb.append(node.val).append("->");
			node = node.next;
		}
		System.out.println("****** Subrata -> Data ::"+sb.toString());
	}
	
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.display();
		
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
	}

}
