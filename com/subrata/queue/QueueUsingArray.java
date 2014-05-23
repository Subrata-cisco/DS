package com.subrata.queue;
/**
 * Queue implementation using Array. TBD - need to make it generic.
 * @author Subrata Saha.
 *
 */

public class QueueUsingArray implements IQueue {

	private Object[] data = null;
	private int front = -1;
	private int rear = 0;
	private static final int MAX = 3; 
	
	
	public QueueUsingArray(){
		data = new Object[MAX];
	}
	
	@Override
	public void enQueue(Object val) {
		if(front == (rear +1)% MAX){
			System.out.println("****** Subrata -> Queue is Full !!");
			return;
		}
		
		if(front == -1){
			front = 0;
			rear = 0;
		}else{
			rear = (rear +1) % MAX ;
		}
		
		data[rear] = val;
		System.out.println("****** Subrata -> Data is inserted as  ::"+val);
	}

	@Override
	public Object deQueue() {
		if(front == -1){
			System.out.println("****** Subrata -> Queue is empty !!");
			return null;
		}
		
		Object val = data[front]; 
		data[front] = null;
		front = (front + 1) % MAX ;
		System.out.println("****** Subrata -> Value retrieved is ::"+val);
		return val;
	}
	
	public static void main(String[] args) {
		QueueUsingArray obj = new QueueUsingArray();
		obj.enQueue(1);
		obj.enQueue(2);
		obj.enQueue(3);
		obj.enQueue(5);
		
		obj.deQueue();
		obj.enQueue(5);
		
		obj.deQueue();
		obj.deQueue();
		obj.deQueue();
		obj.deQueue();
		
	}

}
