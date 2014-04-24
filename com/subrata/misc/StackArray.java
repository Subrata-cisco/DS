package com.subrata.misc;

interface stack {
	int size();

	int pop();

	void push(int val);

	boolean isEmpty();

	boolean isFullStack();
}

public class StackArray implements stack {

	int[] content = new int[SIZE];
	static final int SIZE = 5;
	int ptr = -1;

	public boolean isEmpty() {
		return ptr == -1;
	}

	public boolean isFullStack() {
		return ptr >= SIZE;
	}

	public int size() {
		return ptr;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Under flow !!");
			return -1;
		} else {
			int top = content[ptr];
			content[ptr--] = -1;
			return top;
		}
	}

	public void push(int val) {
		if (isFullStack()) {
			System.out.println("Over flow !!");
		} else {
			content[++ptr] = val;
		}
	}

}
