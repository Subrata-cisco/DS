package com.subrata.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a Stack using two queue.
 * 
 * Idea : 
 * 
 * @author Subrata Saha.
 *
 */
public class StackUsingTwoQueue<T extends Comparable<T>> extends Stack<T> {

	Queue<T> q1;
	Queue<T> q2;
	
	public StackUsingTwoQueue(){
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}
	
	public void pushUsingQueue(T val){
		if(q1.isEmpty()){
			q2.offer(val);
		}else{
			q1.offer(val);
		}
		System.out.println("****** Subrata -> pushed value is  ::"+val);
	}
	
	public T popUsingQueue(){
		T val = null;
		if(q1.isEmpty()){
			while(q2.size()-1>=1){ // keep the last element in q2
				q1.offer(q2.poll());
			}
			val = q2.poll();
		}else{
			while(q1.size()-1>=1){
				q2.offer(q1.poll());
			}
			val = q1.poll();
		}
		System.out.println("****** Subrata -> popped value ::"+val);
		return val;
	}
	
	public static void main(String[] args) {
		StackUsingTwoQueue<Integer> obj = new StackUsingTwoQueue<>();
		obj.pushUsingQueue(1);
		obj.pushUsingQueue(2);
		obj.pushUsingQueue(3);
		
		obj.popUsingQueue();
		obj.popUsingQueue();
		obj.popUsingQueue();
	}
}
