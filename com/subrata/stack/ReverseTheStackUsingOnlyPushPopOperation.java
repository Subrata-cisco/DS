package com.subrata.stack;
/**
 * Input to the stack is => 1,2,3
 * Reverse the stack using only push and pop.
 * 
 * Idea : Pop the stack recursively = incoming data, and push the incoming data recursively.
 * So,  pop result = 3 ,2, 1 => (i.e top is 3, second top is 2, third top is 1)
 *  So starting from last popped value to first popped value.
 *  for 1 = Stack is 1 [top to bottom]
 *  for 2 = pop stack (got 1) => push 2  and then push 1 => Stack is 1,2  [top to bottom]
 *  for 3 = pop stack (got 1,2) => push 3 and then [push 2, and push 1] => Stack is 1,2,3
 *  
 *  so pop the result you get 1,2,3 Done !!
 *  
 * @author Subrata Saha.
 *
 */
public class ReverseTheStackUsingOnlyPushPopOperation<T extends Comparable<T> > extends Stack<T> {

	public void reverseTheStack(){
		if(isEmpty()){
			return;
		}
		
		T data = pop();
		System.out.println("****** Subrata -> data ::"+data);
		reverseTheStack();
		pushRecursively(data);
	}
	
	private void pushRecursively(T data){
		if(isEmpty()){
			System.out.println("****** Subrata -> stack empty , so push ::"+data);
			push(data);
			return;
		}else{
			T temp = pop();
			System.out.println("****** Subrata -> stack not empty , so pop ::"+temp);
			pushRecursively(data);
			System.out.println("****** Subrata -> push temp finally ::"+temp);
			push(temp);
		}
	}
	
	public static void main(String[] args) {
		ReverseTheStackUsingOnlyPushPopOperation<Integer> obj = new ReverseTheStackUsingOnlyPushPopOperation<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		
		obj.display();
		
		obj.reverseTheStack();
		
		obj.display();
	}
}
