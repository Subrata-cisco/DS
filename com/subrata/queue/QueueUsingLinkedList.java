package com.subrata.queue;

public class QueueUsingLinkedList implements IQueue {

	QNode front = null;
	QNode rear = null;
	
	class QNode {
		Object value;
		QNode link;
		public QNode(Object value) {
			this.value = value;
		}
	}
	
	@Override
	public void enQueue(Object val) {
		QNode node = new QNode(val);
		if(front == null){
			front = rear = node;
		}else{
			rear.link = node;
			rear = rear.link;
		}
	}

	@Override
	public Object deQueue() {
		if(front == null){
			System.out.println("****** Subrata -> Queue is empty !!");
		}else{
			QNode node = front.link ;
			System.out.println("****** Subrata -> Deleting "+front.value);
			front = null;
			front = node;
			
			if(front == null){
				rear = null;
			}
		}
		return null;
	}
	
	public void display(){
		if(front == null){
			System.out.println("****** Subrata -> Queue is empty !!");
		}else{
			QNode start = front;
			StringBuilder sb = new StringBuilder();
			while(start != null){
				sb.append(start.value).append("->");
				start = start.link ; 
			}
			System.out.println("****** Subrata -> data ::"+sb.toString());
		}
	}
	
	public static void main(String[] args) {
		QueueUsingLinkedList obj = new QueueUsingLinkedList();
		obj.display();
		
		obj.enQueue(1);
		obj.enQueue(2);
		obj.enQueue(3);
		obj.enQueue(4);
		
		obj.display();
		
		obj.deQueue();
		obj.display();
		obj.deQueue();
		obj.display();
		obj.deQueue();
		obj.display();
		obj.deQueue();
		obj.display();
	}

}
