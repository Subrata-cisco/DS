package com.subrata.linkedlist;

public class LLAddNumbers<T extends Number> extends SLL<Integer>{
	
	Integer carry = 0;
	
	public Node<Integer> add(SLL<Integer> a, SLL<Integer> b){
		if(a.head == null || b.head == null){
            return null;
        }
		
		int s1 = a.size;
		int s2 = b.size;
		
		Node larger = null;
        Node smaller = null;
        
        if(s1 >= s2){
            larger = a.head;
            smaller = b.head;
        }else{
            larger = b.head;
            smaller = a.head;
        }
        
        int diff = Math.abs(s1 - s2);
        Node<Integer> largerStart = larger;
        while(diff > 0){
            largerStart = largerStart.next;
            diff--;
        }
        Node<Integer> carryResult = calculateCarry(largerStart,smaller);
        Node<Integer> reminderResult = addReminder(larger,largerStart);
        
        if(carry != 0){
        	Node<Integer> top = new Node<>(carry);
        	top.next = reminderResult;
            reminderResult = top;
        }
        
        if(reminderResult != null){
            Node<Integer> tail = reminderResult;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = carryResult;
            return reminderResult;
        }
        return carryResult;
        
	}
	
	public Node<Integer> calculateCarry(Node<Integer> a, Node<Integer> b){
		if(a == null){
			return null;
		}
		Node<Integer> result = new Node<>(0);
		result.next = calculateCarry(a.next,b.next);
		int number = a.item + b.item + carry ;
		result.item =  number % 10;
		carry = number / 10 ;
		return result;
	}
	
	public Node<Integer> addReminder(Node<Integer> start, Node<Integer> last){
		if(start != last){
			Node<Integer> result = new Node<>(0);
			result.next = addReminder(start.next,last.next);
			int number = start.item + carry ;
			result.item =  number % 10;
			carry = number / 10 ;
			return result;
		}else{
			return null;
		}
	}
	
	public static void main(String[] args) {
		LLAddNumbers<Integer> list = new LLAddNumbers<>();
		list.add(3);
		list.add(4);
		list.add(10);
		list.add(12);

		list.printList();

		LLAddNumbers<Integer> list2 = new LLAddNumbers<>();
		list2.add(4);
		list2.add(6);
		list2.add(9);

		list2.printList();
		
		
		list.add(list, list2);
		
		System.out.println();
	}
}
