package com.subrata.stack;

import java.util.Arrays;
import java.util.List;

public class StackUsingArray<T extends Comparable<T>> implements IStack<T> {

	private static final int MAX = 3;
	private int count = 0;
	Object[] store = new Object[MAX];
	
	@Override
	public void push(T val) {
		if(count < MAX){
			store[count] = val;
			count++;
			System.out.println("****** Subrata -> Item added ::"+val);
		}else{
			System.out.println("****** Subrata -> Stack is full !!");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		T returnVal = null;
		if(count < 0){
			System.out.println("****** Subrata -> Stack is empty !!");
		}else{
			if(count < MAX){
				returnVal = (T) store[count] ;
				store[count] = null;
				count --;
			}
		}
		return returnVal;
	}
	
	public void display(){
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) Arrays.asList(store);
		if(list != null){
			list.forEach(System.out::println);
		}
	}
	
	public static void main(String[] args) {
		StackUsingArray<Integer>  obj = new StackUsingArray<>();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		
		obj.display();
		
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();
		
		obj.display();
	}


}
