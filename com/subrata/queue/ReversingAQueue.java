package com.subrata.queue;

import java.util.Stack;

/**
 * Reverse a Queue using a stack.
 * 
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class ReversingAQueue<T extends Comparable<T>> extends QueueUsingStack<T> {
	
	public void reverse(){
		
		Stack<T> stack = new Stack<>();
		
		while(!isEmpty()){
			stack.push(deQueue());
		}
		
		while(!stack.isEmpty()){
			enQueue(stack.pop());
		}
		
	}
	
	public static void main(String[] args) {
		ReversingAQueue<Integer> obj = new ReversingAQueue<>();
		obj.enQueue(1);
		obj.enQueue(2);
		obj.enQueue(3);
		obj.enQueue(4);
		obj.enQueue(5);
		
		obj.reverse();
		
		obj.deQueue();
		obj.deQueue();
		obj.deQueue();
		obj.deQueue();
		obj.deQueue();
	}

}
