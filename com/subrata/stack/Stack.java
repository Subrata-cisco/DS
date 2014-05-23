package com.subrata.stack;

public class Stack<T extends Comparable<T>> implements IStack<T> {

	SNode<T> top = null;
	
	class SNode<K> {
		K val;
		SNode<K> next;
		
		SNode(K val){
			this.val = val;
		}
	}
	
	@Override
	public void push(T val) {
		SNode<T> node = new SNode<T>(val);
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
			SNode<T> temp = top;
			returnVal = temp.val;
			top = top.next;
			//temp.next = null;
			temp = null;
		}
		System.out.println("****** Subrata -> popped value ::"+returnVal);
		return returnVal;
	}
	
	public void display(){
		StringBuilder sb = new StringBuilder();
		SNode<T> node = top;
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
