package com.subrata.queue;

import java.util.Stack;
/**
 * Queue implementation using 2 stack.
 * 
 * Idea : Insert in to always in one stack, while removing if 2nd stack is empty then transfer all the item from stack 1 to stack 2
 * so stack will have now all the items from stack 1 but in reverse order , so pop them out until it is empty.
 * 
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class QueueUsingStack<T extends Comparable<T>> implements IQueue<T> { 

	Stack<T> s1 = null;
	Stack<T> s2 = null;
	protected int length = 0;
	
	public QueueUsingStack(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	@Override
	public void enQueue(T val) {
		System.out.println("****** Subrata -> Pushing :: "+val);
		s1.push(val);
		length++;
	}

	@Override
	public T deQueue() {
		T val = null;
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		
		try {
			val = s2.pop();
			length--;
		} catch (Exception e) {
		}
		
		if(val != null){
			System.out.println("****** Subrata -> popping val ::"+val);
		}else{
			System.out.println("****** Subrata -> Queue is empty !!");
		}
		
		return val;
	}
	
	public boolean isEmpty(){
		return length == 0;
	}
	
	public static void main(String[] args) {
		QueueUsingStack<Integer> obj = new QueueUsingStack<>();
		
		obj.enQueue(1);
		obj.enQueue(2);
		obj.enQueue(3);
		obj.enQueue(4);
		obj.enQueue(5);
		
		obj.deQueue();
		obj.deQueue();
		obj.deQueue();
		obj.deQueue();obj.deQueue();
		obj.deQueue();obj.deQueue();
	}

}
